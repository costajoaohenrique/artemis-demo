/*
 * Copyright (c) 2017 Otávio Santana and others
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

package org.jnosql.artemis.demo.se.ravendb;


import org.jnosql.artemis.document.DocumentTemplate;
import org.jnosql.diana.api.document.DocumentQuery;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Arrays;
import java.util.Optional;

import static org.jnosql.diana.api.document.query.DocumentQueryBuilder.select;

public class App {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Address address = new Address("Av nove de julho", "São Paulo");
            Job job = new Job(12.12, "Developer");
            Person person = Person.builder().
                    withPhones(Arrays.asList("234", "432"))
                    .withName("Ada Lovelace")
                    .withAddress(address)
                    .withAge(30)
                    .withJob(job)
                    .build();
            DocumentTemplate template = container.select(DocumentTemplate.class).get();
            Person saved = template.insert(person);
            System.out.println("Person saved" + saved);


            DocumentQuery query = select().from("Person")
                    .where("_id").eq(person.getId()).build();

            Optional<Person> personOptional = template.singleResult(query);
            System.out.println("Entity found: " + personOptional);

        }
    }

    private App() {
    }
}
