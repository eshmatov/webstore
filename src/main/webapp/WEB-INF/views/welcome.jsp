<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; 
charset=ISO-8859-1">

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/
bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting}</h1>
				<p>${tagline}</p>
			</div>
		</div>
	</section>
	<div class="container">
	
	  <c:forEach var="p" items="${products}">
	    <div class="row">
	       <h4>${p.productId}</h4>
	       ${p.name}<br />
	       ${p.category}
	    </div>
	  </c:forEach>
	
	</div>
</body>
</html>