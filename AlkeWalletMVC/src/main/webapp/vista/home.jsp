<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="models.Cuenta"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>AlkeWallet: Home</title>
</head>
<body>
    <div class="container">
        <h1>Bienvenido a AlkeWallet</h1>
        
        <%
            List<Cuenta> lista = (List<Cuenta>) request.getAttribute("cuenta");
            if (lista != null) {
                out.print("Hay un total de " + lista.size() + " cuentas asociadas al cliente");
        %>
                <table class="table table-striped table-hover">
                    <thead class="table-light">
                        <tr>
                            <th>ID</th>
                            <th>Saldo</th>
                            <th>Banco</th>
                            <th>NumeroCta</th>
                            <th>RutCliente</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Cuenta cuenta : lista) {
                                out.print("<tr>");
                                out.print("<td>" + cuenta.getId() + "</td>");
                                out.print("<td>" + cuenta.getSaldo() + "</td>");
                                out.print("<td>" + cuenta.getBanco() + "</td>");
                                out.print("<td>" + cuenta.getNumeroCta() + "</td>");
                                out.print("<td>" + cuenta.getRutCliente() + "</td>");
                                out.print("</tr>");
                            }
                        %>
                    </tbody>
                </table>
        <%
            } else {
                out.print("No hay cuentas asociadas al cliente.");
            }
        %>
        <hr>
        <h3>Depositar</h3>
        <br>
        <form action="../deposito" method="post">
            <div class="form-group">
                <label for="saldo">Saldo</label>
                <input type="number" class="form-control" id="monto" name="monto" placeholder="Ingrese Monto" min="1" required="required">
            </div>
            <button type="submit" class="btn btn-primary">Depositar</button>
        </form>

        <hr>
        <h3>Retirar</h3>
        <br>
        <form action="../retiro" method="post">
            <div class="form-group">
                <label for="montoretiro">Retirar Saldo</label>
                <input type="number" class="form-control" id="montoretiro" name="montoretiro" placeholder="Ingrese Monto" min="1" required="required">
            </div>
            <button type="submit" class="btn btn-primary">Retirar</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"></script>
</body>
</html>

