package fr.ippon.demo.grails

class Company {

    /**
     * Les propriétés ci-dessous référencent les colonnes
     * qui vont être créées dans la base de données lors
     * du lancement de l'application. Elle permettent
     * aussi de déclarer les champs qui seront affichés
     * sur l'interface de l'application.
     */
    String company_name
    ActivityType activityType

    /**
     * Permet de déclarer une relation one-to-many avec
     * le domaine Contact.
     */
    static hasMany = [contacts: Contact]

    /**
     * Cette section permet de spécifier des contraintes
     * liées à l'ajustement des champs sur l'interface.
     */
    static constraints = {

        /**
         * Je spécifie l'ordre d'affichage des champs dans
         * l'interface qui sera automatiquement générée par Grails.
		 * company_name ne peut pas être null ni vide, et la première
		 * doit être une majuscule.
         */
        company_name(nullable: false, blank: false, matches: /[A-Z].*/)

        /**
         * activityType peut-être null.
         */
        activityType(nullable: true)
    }

    /**
     * Cette méthode permet d'indiquer que sur l'interface,
     * nous voulons que les company soient affiché avec son nom, et non
     * avec le package du domaine et l'id de la company.
     */
    def String toString(){
        return "${company_name}"
    }
}
