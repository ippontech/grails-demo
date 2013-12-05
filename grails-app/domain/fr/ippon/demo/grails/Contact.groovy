package fr.ippon.demo.grails

class Contact {
    
    /**
     * Les propriétés ci-dessous référencent les colonnes
     * qui vont être créées dans la base de données lors
     * du lancement de l'application. Elle permettent
     * aussi de déclarer les champs qui seront affichés
     * sur l'interface de l'application.
     */
    String last_name
    String first_name
    String email_address

    /**
     * Cette section permet de spécifier des contraintes
     * liées à l'ajustement des champs sur l'interface.
     */
    static constraints = {
        
        /**
        * Je spécifie l'ordre d'affichage des champs dans
        * l'interface qui sera automatiquement générée par Grails.
        */
        last_name()
        first_name()
        email_address()
    }
}
