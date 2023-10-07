<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="panel panel-default">
<div class="panel-body">
	${message}
	<form:form action="/admin/category/index" modelAttribute="model">
		
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" cssClass="form-control" readonly="true"/>
		</div>
		<div class="form-group">
			<label>Name</label>
			<form:input path="name" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<button class="btn btn-default" formaction="/category/insert">Insert</button>
			<button class="btn btn-default" formaction="/admin/category/update">Update</button>
			<button class="btn btn-default" formaction="/admin/category/delete">Delete</button>
			<button class="btn btn-default" formaction="/admin/category/index">Reset</button>
		</div>
	</form:form>
	</div>
</div>