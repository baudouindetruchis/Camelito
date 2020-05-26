<!DOCTYPE html>
<html lang="fr">

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous">
</script>

 

<link rel="stylesheet" type="text/css" href="../public/css/contactStyle.css">
<link rel="stylesheet" type="text/css" href="../public/css/pageStyle.css">

<head>
	<title>Camelito Contact</title>
	
<script src="../public/js/header.js"></script>
</head>

<body onload="includeHeaderAndCheckUser()">
	<div id="includedHeader"></div>
	<div id="corp">
	<input id="checkSession" type="text" name="checkSession" value ="${sessionScope.type}" hidden>
	Pour nous contacter
	</div>
	<div id="includedFooter"></div>
</body>
