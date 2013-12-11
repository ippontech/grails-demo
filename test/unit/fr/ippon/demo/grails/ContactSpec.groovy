package fr.ippon.demo.grails

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Contact)
class ContactSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    /**
     * Test que le nom de famille ne puisse pas être null.
     */
    void "test that last_name can't be null"() {

        /**
         * On défini un premier test sur le nom de famille d'un contact.
         */
        when: 'the last_name is null'
        def contact = new Contact(last_name: null, first_name: "Jean", email_address: "test@gmail.com")

        /**
         * La validation doit échouer puisque le nom de famille
         * est null.
         */
        then: 'validation should fail'
        !contact.validate()

        /**
         * On défini une deuxième test, le nom de famille n'est
         * pas null cette fois-ci.
         */
        when: 'the last_name is not null'
        contact = new Contact(last_name: "Willis", first_name: "Jean", email_address: "test@gmail.com")

        /**
         * La validation doit passer puisque le nom
         * de famille n'est pas null ni vide.
         */
        then: 'validation should pass'
        contact.validate()
    }

    /**
     * Test que le nom de famille ne puisse pas être vide.
     */
    void "test that last_name can't be blank"(){

        when: 'the last_name is blank'
        def contact = new Contact(last_name: "", first_name: "Jean", email_address: "test@gmail.com")

        then: 'validation should fail'
        !contact.validate()

        when: 'the last_name is not blank'
        contact = new Contact(last_name: "Willis", first_name: "Jean", email_address: "test@gmail.com")

        then: 'validation should pass'
        contact.validate()
    }

    /**
     * Test que le nom de famille doit comporter au minimum
     * 5 caractères.
     */
    void "test that last_name can't be under 5 caracters"(){

        when: 'the last_name is under 5 caracters'
        def contact = new Contact(last_name: "Plot", first_name: "Jean", email_address: "test@gmail.com")

        then: 'validation should fail'
        !contact.validate()

        when: 'the last_name is over 5 caracters'
        contact = new Contact(last_name: "Dujardin", first_name: "Jean", email_address: "test@gmail.com")

        then: 'validation should pass'
        contact.validate()
    }

    /**
     * Test que le nom de famille doit comporter au maximum
     * 20 caractères.
     */
    void "test that last_name can't be over 20 caracters"(){

        when: 'the last_name is over 20 caracters'
        def contact = new Contact(last_name: "martinez-rodriguez-jean", first_name: "Jean", email_address: "test@gmail.com")

        then: 'validation should fail'
        !contact.validate()

        when: "the last_name is under 20 caracters"
        contact = new Contact(last_name: "Dujardin", first_name: "Jean", email_address: "test@gmail.com")

        then: 'validation should pass'
        contact.validate()
    }

    /**
     * Test que le prénom ne puisse pas être null.
     */
    void "test that first_name can't be null"(){

        when: 'the first_name is null'
        def contact = new Contact(last_name: "Willis", first_name: null, email_address: "test@gmail.com")

        then: 'validation should fail'
        !contact.validate()

        when: 'the first_name is not null'
        contact = new Contact(last_name: "Willis", first_name: "Jean", email_address: 'test@gmail.com')

        then: 'validation should pass'
        contact.validate()
    }

    /**
     * Test que le prénom ne puisse pas être vide.
     */
    void "test that first_name can't be blank"(){

        when: 'the first_name is blank'
        def contact = new Contact(last_name: "Willis", first_name: "", email_address: "test@gmail.com")

        then: 'validation should fail'
        !contact.validate()

        when: 'the first_name is not blank'
        contact = new Contact(last_name: "Willis", first_name: "Jean", email_address: "test@gmail.com")

        then: 'validation should pass'
        contact.validate()
    }

    /**
     * Test que l'email puisse être du type d'un email.
     */
    void "test that email_address is email type"(){

        when: 'the email_address is not email type'
        def contact = new Contact(last_name: "Willis", first_name: "Jean", email_address: "gmail.com")

        then: 'validation should fail'
        !contact.validate()

        when: 'the email_address is email type'
        contact = new Contact(last_name: "Willis", first_name: "Jean", email_address: "test@gmail.com")

        then: 'validation should pass'
        contact.validate()
    }

    /**
     * Test que la company puisse être null.
     */
    void "test that company can be null"(){

        when: 'the company field is null'
        def contact = new Contact(last_name: "Willis", first_name: "Jean", email_address: "test@gmail.com")

        then: 'validation should pass'
        contact.validate()
    }
}
