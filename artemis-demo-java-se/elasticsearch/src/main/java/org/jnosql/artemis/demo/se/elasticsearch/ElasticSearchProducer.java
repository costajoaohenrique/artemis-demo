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

package org.jnosql.artemis.demo.se.elasticsearch;


import org.jnosql.diana.elasticsearch.document.ElasticsearchDocumentCollectionManager;
import org.jnosql.diana.elasticsearch.document.ElasticsearchDocumentCollectionManagerFactory;
import org.jnosql.diana.elasticsearch.document.ElasticsearchDocumentConfiguration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ElasticSearchProducer {

    private static final String COLLECTION = "developers";

    private ElasticsearchDocumentConfiguration configuration;

    private ElasticsearchDocumentCollectionManagerFactory managerFactory;

    @PostConstruct
    public void init() {
        configuration = new ElasticsearchDocumentConfiguration();
        managerFactory = configuration.get();
    }


    @Produces
    public ElasticsearchDocumentCollectionManager getManager() {
        return managerFactory.get(COLLECTION);

    }

}
