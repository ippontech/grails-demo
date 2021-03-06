
<%@ page import="fr.ippon.demo.grails.Company" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>

		<!-- Cette balise permet d'inclure le Javascript et les css concernant filterpane. -->
		<r:require module="filterpane" />
	</head>
	<body>
		<a href="#list-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-company" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="company_name" title="${message(code: 'company.company_name.label', default: 'Companyname')}" />
					
						<g:sortableColumn property="activityType" title="${message(code: 'company.activityType.label', default: 'Activity Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${companyInstanceList}" status="i" var="companyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${companyInstance.id}">${fieldValue(bean: companyInstance, field: "company_name")}</g:link></td>
					
						<td>${fieldValue(bean: companyInstance, field: "activityType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">

				<!-- On ajoute le paramètre "filterParams" pour supporter la pagination -->
				<g:paginate total="${companyInstanceCount ?: 0}" params="${filterParams}"/>

				<!-- Ajout d'un bouton pour afficher la zone de recherche -->
				<filterpane:filterButton />
			</div>
		</div>

		<!-- Cette balise permet d'ajouter la zone de recherche sur l'interface -->
		<filterpane:filterPane domain="fr.ippon.demo.grails.Company"/>
	</body>
</html>
