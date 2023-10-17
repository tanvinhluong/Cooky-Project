<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel panel-default">
<div class="panel-body">
	${message}
	<form:form action="/admin/foods/index" modelAttribute="model">
		
		
		<div class="form-group">
			<label>FoodName</label>
			<form:input path="foodName" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>prepareTime</label>
			<form:input path="prepareTime" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>cookingTime</label>
			<form:input path="cookingTime" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>difficulty</label>
			<form:input path="difficulty" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>tips</label>
			<form:input path="tips" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>recipe</label>
			<form:input path="recipe" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>details</label>
			<form:input path="details" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<button class="btn btn-default" formaction="/admin/foods/insert">Insert</button>
			<button class="btn btn-default" formaction="/admin/foods/update">Update</button>
			<button class="btn btn-default" formaction="/admin/foods/delete">Delete</button>
			<button class="btn btn-default" formaction="/admin/foods/index">Reset</button>
		</div>
		
		
	</form:form>
	</div>
	
	<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Ten mon an</th>
			<th>Thoi gian chuan bi</th>
			<th>Thoi gian nau</th>
			<th>Do kho</th>
			<th>Meo</th>
			<th>Cong Thuc</th>
			<th>ChiTiet</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${list}">
		<tr>
			<td>${e.id}</td>
			<td>${e.foodName}</td>
			<td>${e.prepareTime}</td>
			<td>${e.cookingTime}</td>
			<td>${e.difficulty}</td>
			<td>${e.tips}</td>
			<td>${e.recipe}</td>
			<td>${e.details}</td>

			<a class="btn btn-sm btn-warning" href="/admin/foods/edit/${e.id}">Edit</a>
			<a class="btn btn-sm btn-danger" href="/admin/foods/delete/${e.id}">Delete</a>
			</td>		
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
</div>