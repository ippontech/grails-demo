<%@ page import="fr.ippon.demo.grails.Company" %>



<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'company_name', 'error')} required">
	<label for="company_name">
		<g:message code="company.company_name.label" default="Companyname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="company_name" pattern="${companyInstance.constraints.company_name.matches}" required="" value="${companyInstance?.company_name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'activityType', 'error')} ">
	<label for="activityType">
		<g:message code="company.activityType.label" default="Activity Type" />
		
	</label>
	<g:select name="activityType" from="${fr.ippon.demo.grails.ActivityType?.values()}" keys="${fr.ippon.demo.grails.ActivityType.values()*.name()}" value="${companyInstance?.activityType?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'contacts', 'error')} ">
	<label for="contacts">
		<g:message code="company.contacts.label" default="Contacts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${companyInstance?.contacts?}" var="c">
    <li><g:link controller="contact" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="contact" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'contact.label', default: 'Contact')])}</g:link>
</li>
</ul>

</div>

