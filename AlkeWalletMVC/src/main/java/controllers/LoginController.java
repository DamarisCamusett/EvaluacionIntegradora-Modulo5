package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.ConnectionDB;
import dao.DaoCuenta;
import dao.DaoLogin;

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
        PrintWriter out=response.getWriter();  
        
        //Para establecer la conexion con la base de datos
        ConnectionDB connectionBD = new ConnectionDB();
    	Connection conexion = connectionBD.establecerConexion();
    	
        // Obtiene los parámetros del formulario de inicio de sesión
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        DaoLogin dao = new DaoLogin(conexion);
        
        // Autentica al usuario
    	boolean result = dao.validarLogin(username, password);
    	System.out.println(result);
    	
    	if(result) {
    		DaoCuenta daoCuenta = new DaoCuenta(conexion);
            request.setAttribute("cuenta", daoCuenta.obtenerTodaCuenta());

            // Si las credenciales son correctas, redirige al usuario a home.jsp
            RequestDispatcher rd = request.getRequestDispatcher("vista/home.jsp");
            rd.forward(request, response);
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Usuario y/o clave incorrectos');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }

}

