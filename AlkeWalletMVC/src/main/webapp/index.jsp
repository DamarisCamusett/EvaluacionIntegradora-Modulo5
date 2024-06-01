<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" > <!-- Bootstrap -->
<link rel="stylesheet" href="css/index.css"> <!-- index.css -->
<title>AlkeWallet: Inicio Sesi�n</title>
</head>
<body>
    <div class="login-container">
        <h1>Inicie Sesi�n</h1>
        <form id="formulario_login" action="login" method="post">
            <div class="mb-3">
                <label for="username">Rut:</label>
                <input type="text" id="username" name="username" required><br><br>
            </div>
            <div class="mb-3">
                <label for="password">Contrase�a:</label>
                <input type="password" id="password" name="password" required><br><br>
                <input type="checkbox" id="visible"> Mostrar Contrase�a<br><br>
                <input type="submit" value="Iniciar Sesi�n">
            </div>
        </form>
    </div>
    <!-- Utilizaci�n de JS para inicio de sesi�n -->
    <script src="js/login.js"></script>
</body>
</html>
