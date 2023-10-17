<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel panel-default">
<div class="panel-body">
	${message}
	<form:form action="/admin/favorite/index" modelAttribute="model">
		
		<div class="form-group">
			<label>userId</label>
			<form:input path="userId" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>favorited</label>
			<form:input path="favorited" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<button class="btn btn-default" formaction="/admin/favorite/insert">Insert</button>
			<button class="btn btn-default" formaction="/admin/favorite/update">Update</button>
			<button class="btn btn-default" formaction="/admin/favorite/delete">Delete</button>
			<button class="btn btn-default" formaction="/admin/favorite/index">Reset</button>
		</div>
		
		
	</form:form>
	</div>
	
	<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>UserID</th>
			<th>Favorited</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${list}">
		<tr>
			<td>${e.id}</td>
			<td>${e.userId.id}</td>
			<td>${e.favorited}</td>
			

			<a class="btn btn-sm btn-warning" href="/admin/favorite/edit/${e.id}">Edit</a>
			<a class="btn btn-sm btn-danger" href="/admin/favorite/delete/${e.id}">Delete</a>
			</td>		
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
</div>