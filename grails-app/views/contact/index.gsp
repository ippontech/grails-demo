
<%@ page import="fr.ippon.demo.grails.Contact" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contact.label', default: 'Contact')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>

		<!-- Cette balise permet d'inclure le Javascript et les css concernant filterpane. -->
		<r:require module="filterpane" />
	</head>
	<body>
		<a href="#list-contact" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-contact" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="last_name" title="${message(code: 'contact.last_name.label', default: 'Lastname')}" />
					
						<g:sortableColumn property="first_name" title="${message(code: 'contact.first_name.label', default: 'Firstname')}" />
					
						<g:sortableColumn property="email_address" title="${message(code: 'contact.email_address.label', default: 'Emailaddress')}" />
					
						<th><g:message code="contact.company.label" default="Company" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${contactInstanceList}" status="i" var="contactInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${contactInstance.id}">${fieldValue(bean: contactInstance, field: "last_name")}</g:link></td>
					
						<td>${fieldValue(bean: contactInstance, field: "first_name")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "email_address")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "company")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">

				<!-- On ajoute le paramètre "filterParams" pour supporter la pagination -->
				<g:paginate total="${contactInstanceCount ?: 0}" params="${filterParams}"/>

				<!-- Ajout d'un bouton pour afficher la zone de recherche -->
				<filterpane:filterButton />
			</div>
		</div>

		<!-- Cette balise permet d'ajouter la zone de recherche sur l'interface -->
		<filterpane:filterPane domain="fr.ippon.demo.grails.Contact"/>
	</body>
</html>
