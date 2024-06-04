/*
Para poder visualizar la constraseña en login 
*/
document.addEventListener("DOMContentLoaded", function() {
    const formularioLogin = document.getElementById("formulario_login");

    // Para mostrar u ocultar contraseña
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
