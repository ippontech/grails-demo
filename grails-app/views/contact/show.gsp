
<%@ page import="fr.ippon.demo.grails.Contact" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contact.label', default: 'Contact')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-contact" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-contact" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list contact">
			
				<g:if test="${contactInstance?.last_name}">
				<li class="fieldcontain">
					<span id="last_name-label" class="property-label"><g:message code="contact.last_name.label" default="Lastname" /></span>
					
						<span class="property-value" aria-labelledby="last_name-label"><g:fieldValue bean="${contactInstance}" field="last_name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contactInstance?.first_name}">
				<li class="fieldcontain">
					<span id="first_name-label" class="property-label"><g:message code="contact.first_name.label" default="Firstname" /></span>
					
						<span class="property-value" aria-labelledby="first_name-label"><g:fieldValue bean="${contactInstance}" field="first_name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contactInstance?.email_address}">
				<li class="fieldcontain">
					<span id="email_address-label" class="property-label"><g:message code="contact.email_address.label" default="Emailaddress" /></span>
					
						<span class="property-value" aria-labelledby="email_address-label"><g:fieldValue bean="${contactInstance}" field="email_address"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:contactInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${contactInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
