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

package org.jnosql.artemis.demo.se.couchbase;


import org.jnosql.artemis.DatabaseQualifier;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App4 {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Villain lock = new Villain();
            lock.setId("lock");
            lock.setName("Lock");

            Villain doom = new Villain();
            doom.setId("doom");
            doom.setName("Dc Doom");

            VillainRepository repository = container.select(VillainRepository.class, DatabaseQualifier.ofKeyValue()).get();

            repository.save(lock);
            repository.save(doom);
            System.out.println(repository.findById("lock"));
            System.out.println(repository.findById("doom"));

        }
    }

    private App4() {
    }
}
