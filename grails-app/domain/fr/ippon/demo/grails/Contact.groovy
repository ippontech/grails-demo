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
     * En ajoutant la section belongsTo, les ajouts, modifications
     * et suppressions de données se feront en cascade.
     */
    Company company

    /**
     * Permet de mettre en place des actions en cascade pour
     * les deux domaines. De ce fait, si une company est supprimé, ajoutée,
     * ou modifié, cela impactera les contacts associés.
     */
    static belongsTo = Company

    /**
     * Cette section permet de spécifier des contraintes
     * liées à l'ajustement des champs sur l'interface.
     */
    static constraints = {

        /**
        * Je spécifie l'ordre d'affichage des champs dans
        * l'interface qui sera automatiquement générée par Grails.
        * Des contraintes ont été spécifiés pour le nom de famille
        * qui ne doit pas être null, ni vide, et doit être au minimum
        * de 5 caractères et au maximum de 20 caractères.
        */
        last_name(nullable: false, blank: false, size: 5..20)

        /**
         * Le prénom ne peut pas être null ni vide.
         */
        first_name(nullable: false, blank: false)

        /**
         * L'adresse email doit être forcément de type email.
         */
        email_address(email: true)

        /**
         * En plus de spécifier que la company s'affichera en dernière sur
         * l'interface de Contact, on passe en paramètre nullable: true
         * pour spécifier que la valeur "null" est acceptée pour la colonne
         * "company".
         */
        company(nullable: true)
    }

    /**
     * Cette méthode permet d'indiquer que sur l'interface,
     * nous voulons que les contacts dans l'interface concernant
     * la company soient affiché avec le prénom et le nom, et non
     * avec le package du domaine et l'id du contact.
     */
    def String toString(){
        return "${first_name}, ${last_name}"
    }
}
