<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" > <!-- Bootstrap -->
<title>AlkeWallet: Home</title>
</head>
<body>
<h1>Bienvenido/a </h1>


	<div>
		<h2 style="padding-top: 10px;" class="text-center">Menú Principal</h2>
	</div>
	
	<div class="">
		<label for="" style="float: left; padding-right: 20px;" class="">Dinero en cuenta: <%out.print(request.getAttribute("saldo"));%> ( CLP )</label>
		<h4 style="float: left;" id="saldo" class=" fw-bold"></h4>
	</div>

	<div class="menu">
    <div class="menu-header">
    </div>
    <ul class="menu-list">
        <li><a href="#">Inicio</a></li>
        <li><a href="#">Cuenta</a></li>
        <li><a href="#">Transferencias</a></li>
        <li><a href="#">Pagos</a></li>
        <li><a href="/index.jsp">Cerrar Sesión</a></li>
    </ul>
	</div>

</body>
</html>