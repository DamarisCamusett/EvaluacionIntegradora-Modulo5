<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="models.Cuenta"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Visualización de la tabla "cuenta"</title>
</head>
<body>
	<div class="container">
    <h2>Tabla "cuenta"</h2>
    
    				<%
					List<Cuenta> lista = (List) request.getAttribute("cuenta");
					out.print("Hay un total de " + lista.size() + " cuenta");
					%>
    
    <table border="1">
        <tr>
            	<th>ID</th>
				<th>NumeroCta</th>
				<th>Rut_cliente</th>
				<th>Apodo</th>
				<th>Banco</th>
				<th>Saldo</th>
        </tr>
        <tbody>		
       			<%
					for (int i = 0; i < lista.size(); i++) {
						out.print("<tr>" + "" + "<td>" + lista.get(i).getId() + "</td>" + "" + "<td>" + lista.get(i).getRut_cliente() + "</td>" + ""
						+ "<td>" + lista.get(i).getNumeroCta() + "</td>" + "" + "<td>" + lista.get(i).getApodo() + "</td>" + ""
						+ "<td>" + lista.get(i).getBanco() + "</td>" + "" + "<td>" + lista.get(i).getSaldo() + "</td></tr>");
					}
				%>
        </tbody>
    </table>
    <br>
		<hr>
		<h3>Depositar</h3>
		<br>
		<form action="deposito" method="post">
			<div class="form-group">
				<label for="saldo">Saldo</label> <input type="number"
					class="form-control" id="monto" name="monto"
					placeholder="Ingrese Monto" min="1" required="required">
			</div>
			<button type="submit" class="btn btn-primary">Depositar</button>
			<br>
		</form>

		<hr>
		<h3>Retirar</h3>
		<br>
		<form action="retiro" method="post">
			<div class="form-group">
				<label for="montoretiro">Retirar Saldo</label> <input type="number" class="form-control" id="montoretiro" name="montoretiro" placeholder="Ingrese Monto" min="1" required="required">
			</div>
			<button type="submit" class="btn btn-primary">Retirar</button>
		</form>
</body>
</html>