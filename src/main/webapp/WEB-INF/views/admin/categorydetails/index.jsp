<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel panel-default">
<div class="panel-body">
	${message}
	<form:form action="/admin/categorydetails/index" modelAttribute="model">
		
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" cssClass="form-control" readonly="true"/>
		</div>
		<div class="form-group">
			<label>Name</label>
			<form:input path="id" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<button class="btn btn-default" formaction="/admin/categorydetails/insert">Insert</button>
			<button class="btn btn-default" formaction="/admin/categorydetails/update">Update</button>
			<button class="btn btn-default" formaction="/admin/categorydetails/delete">Delete</button>
			<button class="btn btn-default" formaction="/admin/categorydetails/index">Reset</button>
		</div>
		
		
	</form:form>
	</div>
	
	<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Names</th>
			<th>Names</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${list}">
		<tr>
			<td>${e.id}</td>
			<td>${e.categoryId.id}</td>
			<td>${e.foodId.id}</td>
			

			<a class="btn btn-sm btn-warning" href="/admin/categorydetails/edit/${e.id}">Edit</a>
			<a class="btn btn-sm btn-danger" href="/admin/categorydetails/delete/${e.id}">Delete</a>
			</td>		
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
</div>