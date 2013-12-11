package fr.ippon.demo.grails

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Company)
class CompanySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    /**
     * Test que le nom de l'entreprise ne puisse pas être null.
     */
    void "Test that company_name can't be null"(){

        when: 'the company_name is null'
        def company = new Company(company_name: null)

        then: 'validation should fail'
        !company.validate()

        when: 'the company_name is not null'
        company = new Company(company_name: 'Ippon')

        then: 'validation should pass'
        company.validate()
    }

    /**
     * Test que le nom de la company ne puisse pas être vide.
     */
    void "Test that company_name can't be blank"(){

        when: 'the company_name is blank'
        def company = new Company(company_name: "")

        then: 'validation should fail'
        !company.validate()

        when: 'the company_name is not null'
        company = new Company(company_name: 'Ippon')

        then: 'validation should pass'
        company.validate()
    }

    /**
     * Test que le nom de l'entreprise doit obligatoirement commencer
     * par une majuscule.
     */
    void "Test that company_name must begin with an upper case"() {

        when: 'the name begins with a lower letter'
        def company = new Company(company_name: 'ippon')

        then: 'validation should fail'
        !company.validate()

        when: 'the name begins with an upper case letter'
        company = new Company(company_name: 'Ippon')

        then: 'validation should pass'
        company.validate()
    }

    /**
     * Test que le champ activityType puisse être null.
     */
    void "Test that activityType can be null"(){

        when: 'the activityType is null'
        def company = new Company(company_name: 'Ippon', activityType: null)

        then: "validation should pass"
        company.validate()
    }
}