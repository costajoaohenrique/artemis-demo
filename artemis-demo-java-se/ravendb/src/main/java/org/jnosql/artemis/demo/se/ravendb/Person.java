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


import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.List;


@Entity
public class Person {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private List<String> phones;

    @Column
    private Address address;

    @Column
    private Job job;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public List<String> getPhones() {
        return phones;
    }


    public Person() {
    }

    Person(String id, String name, List<String> phones, Integer age, Address address, Job job) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.address = address;
        this.job = job;
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phones=").append(phones);
        sb.append(", address=").append(address);
        sb.append(", job=").append(job);
        sb.append('}');
        return sb.toString();
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }
}
