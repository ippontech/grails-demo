import fr.ippon.demo.grails.Company
import fr.ippon.demo.grails.Contact
import fr.ippon.demo.grails.ActivityType
import javax.servlet.ServletContext

class BootStrap {

    /**
     * C'est dans cette méthode qu'on initialise les données. Dans cet exemple,
     * les données sont ajoutés que si le projet est lancé en environnement
     * de développement.
     */
    def init = { servletContext ->
        environments {
            development {

                /**
                 * Les modifications en base de données se feront si les
                 * tables Company et Contact sont vides.
                 */
                if(!Company.count() && !Contact.count()){

                    /**
                     * Appel à chaque méthode qui ajoute des données
                     * par entreprise
                     */
                    createIpponData()
                    createCulturaData()
                    createCompanyWithoutContact()
                    createContactWithoutCompany()
                }
            }
        }
    }
    def destroy = {
    }

    /**
     * Cette méthode permet de créer la société Ippon avec ses contacts associés.
     */
    void createIpponData(){

        Company ippon = new Company(company_name: "Ippon Technologies", activityType: ActivityType.Informatique)
        ippon.save()

        new Contact(last_name: "Morgan", first_name: "Uriah", email_address: "morgan@ippon.fr", company: ippon).save()
        new Contact(last_name: "Willis", first_name: "Carson", email_address: "willis@ippon.fr", company: ippon).save()
        new Contact(last_name: "Bentley", first_name: "Imani", email_address: "bentley@ippon.fr", company: ippon).save()
    }

    /**
     * Cette méthode permet de créer la société Cultura avec ses contacts associés.
     */
    void createCulturaData(){

        Company cultura = new Company(company_name: "Cultura", activityType: ActivityType.Commerce)
        cultura.save()

        new Contact(last_name: "Dodson", first_name: "Yuri", email_address: "dodson@cultura.fr", company: cultura).save()
        new Contact(last_name: "Poole", first_name: "Dennis", email_address: "poole@cultura.fr", company: cultura).save()
        new Contact(last_name: "Pace", first_name: "Stella", email_address: "pace@cultura.fr", company: cultura).save()
    }

    /**
     * Cette méthode permet de créer la société Quick sans contacts associés.
     */
    void createCompanyWithoutContact(){

        new Company(company_name: "Quick", activityType: ActivityType.Restauration).save()
    }

    /**
     * Cette méthode permet de créer des contacts sans company associé.
     */
    void createContactWithoutCompany(){

        new Contact(last_name: "Lindsay", first_name: "Mary", email_address: "lindsay@quick.fr", company : null).save()
        new Contact(last_name: "Schwartz", first_name: "Brittany", email_address: "schwartz@auchan.fr", company : null).save()
    }
}
