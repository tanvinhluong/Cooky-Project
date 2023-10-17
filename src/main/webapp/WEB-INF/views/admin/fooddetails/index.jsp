<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel panel-default">
<div class="panel-body">
	${message}
	<form:form action="/admin/fooddetails/index" modelAttribute="model">
		
		<div class="form-group">
			<label>foodid</label>
			<form:input path="foodId.id" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>ingredientid</label>
			<form:input path="ingredientId.id" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<button class="btn btn-default" formaction="/admin/fooddetails/insert">Insert</button>
			<button class="btn btn-default" formaction="/admin/fooddetails/update">Update</button>
			<button class="btn btn-default" formaction="/admin/fooddetails/delete">Delete</button>
			<button class="btn btn-default" formaction="/admin/fooddetails/index">Reset</button>
		</div>
		
		
	</form:form>
	</div>
	
	<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>IdFood</th>
			<th>IdIngredient</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${list}">
		<tr>
			<td>${e.id}</td>
			<td>${e.foodId.id}</td>
			<td>${e.ingredientId.id}</td>
			

			<a class="btn btn-sm btn-warning" href="/admin/fooddetails/edit/${e.id}">Edit</a>
			<a class="btn btn-sm btn-danger" href="/admin/fooddetails/delete/${e.id}">Delete</a>
			</td>		
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
</div>