<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Add product</title>
</head>
<body>

	<section>
	<div class="jumbotron">
		<div class="container">
			<a href="<c:url value="j_spring_security_logout" />"
				class="btn btn-danger btn-mini pull-right">Logout</a>
			<h1>Products</h1>
			<p>Add products</p>
		</div>
	</div>
	</section>

	<section class="container"> <form:form
		modelAttribute="newProduct" class="form-horizontal">
		<fieldset>
			<legend>Add new product</legend>

			<div class="form-group">
				<label class="control-label col-lg-2" for="productId"> <spring:message
						code="addProduct.form.productId.label" />
				</label>
				<div class="col-lg-10">
					<form:input path="productId" id="productId" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="name">Name</label>
				<div class="col-lg-10">
					<form:input path="name" id="name" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="category">Category</label>
				<div class="col-lg-10">
					<form:input path="category" id="category" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="unitPrice">Unit
					price</label>
				<div class="col-lg-10">
					<form:input path="unitPrice" id="unitPrice" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="manufacturer">Manufacturer</label>
				<div class="col-lg-10">
					<form:input path="manufacturer" id="manufacturer" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="unitsInStock">Units
					in stock</label>
				<div class="col-lg-10">
					<form:input path="unitsInStock" id="unitsInStock" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="description">Description</label>
				<div class="col-lg-10">
					<form:textarea path="description" id="description" type="text"
						class="form:input-large" rows="2" />
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-lg-2" for="condition">Condition</label>
				<div class="col-lg-10">
					<form:radiobutton path="condition" value="New" />
					New
					<form:radiobutton path="condition" value="Old" />
					Old
					<form:radiobutton path="condition" value="Refurbished" />
					Refurbished
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<input type="submit" class="btn btn-primary" value="Add" />
				</div>
			</div>

		</fieldset>
	</form:form> </section>


</body>
</html>