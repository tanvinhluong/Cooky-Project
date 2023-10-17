<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel panel-default">
<div class="panel-body">
	${message}
	<form:form action="/admin/admin/index" modelAttribute="model">
		
		<div class="form-group">
			<label>IdAccount</label>
			<form:input path="accountId.id" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Ho</label>
			<form:input path="ho" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Ten</label>
			<form:input path="ten" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Phai</label>
			<form:input path="phai" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>DiaChi</label>
			<form:input path="diachi" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>SoDT</label>
			<form:input path="sodt" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Email</label>
			<form:input path="email" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<button class="btn btn-default" formaction="/admin/admin/insert">Insert</button>
			<button class="btn btn-default" formaction="/admin/admin/update">Update</button>
			<button class="btn btn-default" formaction="/admin/admin/delete">Delete</button>
			<button class="btn btn-default" formaction="/admin/admin/index">Reset</button>
		</div>
		
		
	</form:form>
	</div>
	
	<table class="table table-hover">
	<thead>
		<tr>
			<th>IdAdmin</th>
			<th>IdAccount</th>
			<th>Ho</th>
			<th>Ten</th>
			<th>Phai</th>
			<th>DiaChi</th>
			<th>SoDienThoai</th>
			<th>Email</th>
			<th>NgayCap</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${list}">
		<tr>
			<td>${e.id}</td>
			<td>${e.accountId.id}</td>
			<td>${e.ho}</td>
			<td>${e.ten}</td>
			<td>${e.phai}</td>
			<td>${e.diachi}</td>
			<td>${e.sodt}</td>
			<td>${e.email}</td>
			<td>${e.ngayCap}</td>
			
			<a class="btn btn-sm btn-warning" href="/admin/admin/edit/${e.id}">Edit</a>
			<a class="btn btn-sm btn-danger" href="/admin/admin/delete/${e.id}">Delete</a>
			</td>		
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
</div>