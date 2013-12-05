package fr.ippon.demo.grails



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContactController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Contact.list(params), model:[contactInstanceCount: Contact.count()]
    }

    def show(Contact contactInstance) {
        respond contactInstance
    }

    def create() {
        respond new Contact(params)
    }

    @Transactional
    def save(Contact contactInstance) {
        if (contactInstance == null) {
            notFound()
            return
        }

        if (contactInstance.hasErrors()) {
            respond contactInstance.errors, view:'create'
            return
        }

        contactInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contactInstance.label', default: 'Contact'), contactInstance.id])
                redirect contactInstance
            }
            '*' { respond contactInstance, [status: CREATED] }
        }
    }

    def edit(Contact contactInstance) {
        respond contactInstance
    }

    @Transactional
    def update(Contact contactInstance) {
        if (contactInstance == null) {
            notFound()
            return
        }

        if (contactInstance.hasErrors()) {
            respond contactInstance.errors, view:'edit'
            return
        }

        contactInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Contact.label', default: 'Contact'), contactInstance.id])
                redirect contactInstance
            }
            '*'{ respond contactInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Contact contactInstance) {

        if (contactInstance == null) {
            notFound()
            return
        }

        contactInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Contact.label', default: 'Contact'), contactInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contactInstance.label', default: 'Contact'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
