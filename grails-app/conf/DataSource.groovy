dataSource {
    pooled = true

    /**
     * Ajout du driver PostgreSQL pour la connection à la base
     * Il ne faut pas oublier de rajouter le fichier .jar du driver PostgreSQL
     * dans le dossier lib/ à la racine du projet Grails.
     */
    driverClassName = "org.postgresql.Driver"
    dialect = org.hibernate.dialect.PostgreSQLDialect

    /**
     * L'ajout du username et du password dans cette section permet de les spécifier qu'une
     * seule fois dans le fichier pour tous les environnemments.
     */
    username = "postgres"
    password = "test"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {

            /**
             * Lors de la génération du fichier, dbCreate = "create-drop" est automatiquement
             * ajoutée et efface toutes les données de la base lors de chaque démarrage
             * de l'application. L'ajout de dbCreate = "update" permet de ne pas les effacer.
             */
            dbCreate = "update"

            // Ajout de l'URL de la base PostgreSQL grails-demo.
            url = "jdbc:postgresql://localhost:5432/grails-demo"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://localhost:5432/grails-demo"

            /**
             * Si les username et password changent sur un des environnement, il faut les spécifier
             * dans une de ces sections.
             */
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://localhost:5432/grails-demo"
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=false
               validationQuery="SELECT 1"
               jdbcInterceptors="ConnectionState"
            }
        }
    }
}
