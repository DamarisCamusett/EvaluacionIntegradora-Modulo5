package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Define la URL de mapeo del servlet
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Constructor del servlet
    public LoginController() {
        super();
    }

    // Método GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Responde a las solicitudes GET
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    // Método POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configura el tipo de contenido de la respuesta
        response.setContentType("text/html");
        
        // Obtiene los parámetros del formulario de inicio de sesión
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Autentica al usuario
        if (authenticate(username, password)) {
            // Si las credenciales son correctas, redirige al usuario a home.jsp
            RequestDispatcher rd = request.getRequestDispatcher("vista/home.jsp");
            rd.forward(request, response);
        } else {
            // Si las credenciales son incorrectas, muestra un mensaje de alerta y redirige al usuario de vuelta a index.jsp
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Usuario y/o clave incorrectos');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }

    // Método para autenticar al usuario
    private boolean authenticate(String username, String password) {
        // Se verifican las credenciales del usuario.
        return "12345678-9".equals(username) && "11223344".equals(password);
    }
}

