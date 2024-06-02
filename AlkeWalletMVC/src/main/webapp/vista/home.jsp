<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>

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
    <table border="1">
        <tr>
            		<th>ID</th>
					<th>NumeroCta</th>
					<th>Rut_cliente</th>
					<th>Apodo</th>
					<th>Banco</th>
					<th>Saldo</th>
        </tr>
        <% 
            try {
                // Establecer la conexión con la base de datos
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alkewallet_db", "root", "");
                
                // Consulta SQL para obtener los datos de la tabla "cuenta"
                String query = "SELECT * FROM cuenta";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                // Iterar sobre los resultados y mostrarlos en la tabla
                while(rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getInt("numeroCta") %></td>
            <td><%= rs.getString("rut_cliente") %></td>
            <td><%= rs.getString("apodo") %></td>
            <td><%= rs.getString("banco") %></td>
            <td><%= rs.getDouble("saldo") %></td>
        </tr>
        <%
                }
                
                // Cerrar la conexión y liberar recursos
                rs.close();
                stmt.close();
                con.close();
                
            } catch(Exception e) {
                out.println("Error: " + e);
            }
        %>
    </table>
    <br>
		<hr>
		<h3>Depositar</h3>
		<br>
		<form action="../deposito" method="post">
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
		<form action="../retiro" method="post">
			<div class="form-group">
				<label for="montoretiro">Retirar Saldo</label> <input type="number"
					class="form-control" id="montoretiro" name="montoretiro"
					placeholder="Ingrese Monto" min="1" required="required">
			</div>
			<button type="submit" class="btn btn-primary">Retirar</button>
		</form>
</body>
</html>