<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel panel-default">
<div class="panel-body">
	${message}
	<form:form action="/admin/role/index" modelAttribute="model">
		
		<div class="form-group">
			<label>roleId</label>
			<form:input path="roleId" cssClass="form-control" readonly="true"/>
		</div>
		<div class="form-group">
			<label>Name</label>
			<form:input path="roleName" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<button class="btn btn-default" formaction="/admin/role/insert">Insert</button>
			<button class="btn btn-default" formaction="/admin/role/update">Update</button>
			<button class="btn btn-default" formaction="/admin/role/delete">Delete</button>
			<button class="btn btn-default" formaction="/admin/role/index">Reset</button>
		</div>
		
		
	</form:form>
	</div>
	
	<table class="table table-hover">
	<thead>
		<tr>
			<th>roleId</th>
			<th>roleName</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${list}">
		<tr>
			<td>${e.roleId}</td>
			<td>${e.roleName}</td>

			<a class="btn btn-sm btn-warning" href="/admin/role/edit/${e.roleId}">Edit</a>
			<a class="btn btn-sm btn-danger" href="/admin/role/delete/${e.roleId}">Delete</a>
			</td>		
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
</div>