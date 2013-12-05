<%@ page import="fr.ippon.demo.grails.Contact" %>



<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'last_name', 'error')} ">
	<label for="last_name">
		<g:message code="contact.last_name.label" default="Lastname" />
		
	</label>
	<g:textField name="last_name" value="${contactInstance?.last_name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'first_name', 'error')} ">
	<label for="first_name">
		<g:message code="contact.first_name.label" default="Firstname" />
		
	</label>
	<g:textField name="first_name" value="${contactInstance?.first_name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'email_address', 'error')} ">
	<label for="email_address">
		<g:message code="contact.email_address.label" default="Emailaddress" />
		
	</label>
	<g:textField name="email_address" value="${contactInstance?.email_address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'company', 'error')} required">
	<label for="company">
		<g:message code="contact.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="company" name="company.id" from="${fr.ippon.demo.grails.Company.list()}" optionKey="id" required="" value="${contactInstance?.company?.id}" class="many-to-one"/>
</div>

