/**
 * Para poder iniciar sesión
 */
document.addEventListener("DOMContentLoaded", function() {
    const formularioLogin = document.getElementById("formulario_login");

    formularioLogin.addEventListener("submit", function(event) {
        event.preventDefault();

        // Obtener valores de los campos
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        // Se agrega la lógica para validar el usuario y contraseña
        console.log("Username:", username);
        console.log("Password:", password);

        // Modifica estos valores para cambiar el usuario y la contraseña
        const validUsername = "12345678-9";
        const validPassword = "11223344";

        if (username === validUsername && password === validPassword) {
            console.log("Bienvenido");
            window.location.href = "vista/home.jsp";
        } else {
            alert("Usuario y/o clave incorrectos");
        }
    });

    // Para mostrar/ocultar contraseña
    const checkboxVisible = document.getElementById("visible");
    const passwordField = document.getElementById("password");

    checkboxVisible.addEventListener("change", function() {
        if (checkboxVisible.checked) {
            passwordField.type = "text";
        } else {
            passwordField.type = "password";
        }
    });
});
