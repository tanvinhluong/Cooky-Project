<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel panel-default">
<div class="panel-body">
	${message}
	<form:form action="/admin/account/index" modelAttribute="model">
		
		<div class="form-group">
			<label>username</label>
			<form:input path="username" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>password</label>
			<form:input path="password" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>role</label>
			<form:input path="roleId.roleId" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<button class="btn btn-default" formaction="/admin/account/insert">Insert</button>
			<button class="btn btn-default" formaction="/admin/account/update">Update</button>
			<button class="btn btn-default" formaction="/admin/account/delete">Delete</button>
			<button class="btn btn-default" formaction="/admin/account/index">Reset</button>
		</div>
		
		
	</form:form>
	</div>
	
	<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Names</th>
			<th>Password</th>
			<th>Role</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${list}">
		<tr>
			<td>${e.id}</td>
			<td>${e.username}</td>
			<td>${e.password}</td>
			<td>${e.roleId.roleId}</td>
			<a class="btn btn-sm btn-warning" href="/admin/account/edit/${e.id}">Edit</a>
			<a class="btn btn-sm btn-danger" href="/admin/account/delete/${e.id}">Delete</a>
			</td>		
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
</div>