/*
 * Copyright (c) 2019 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */
package org.jnosql.artemis.demo.se.parking;


import org.javamoney.moneta.Money;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class App1 {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            DriverRepository repository = container.select(DriverRepository.class).get();
            CurrencyUnit usd = Monetary.getCurrency(Locale.US);

            Car ferrari = Car.builder().withPlate("BRL-1234")
                    .withModel("812 Superfast")
                    .withColor(Color.RED)
                    .withPrice(Money.of(315_000, usd))
                    .build();

            Car mustang = Car.builder().withPlate("BRL-1234")
                    .withModel("812 Superfast")
                    .withColor(Color.RED)
                    .withPrice(Money.of(55_000, usd))
                    .build();

            Driver michael = Driver.builder().withAge(25)
                    .withCars(Arrays.asList(ferrari))
                    .withEmail("michael@ferrari.com")
                    .withLicense(true)
                    .withName("Michael Schumacher").build();

            Driver rubens = Driver.builder().withAge(25)
                    .withCars(Arrays.asList(mustang))
                    .withEmail("rubens@mustang.com")
                    .withLicense(true)
                    .withName("Rubens Barrichello").build();

            repository.save(michael);
            repository.save(rubens);

            repository.findByColor(Color.RED.get()).forEach(System.out::println);

        }
    }

    private App1() {
    }
}
