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
import javax.servlet.http.HttpSession;

import connectionDB.ConnectionDB;
import dao.DaoCuenta;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //Constructor
    public HomeController() {
        super();
    }
    
    //Metodo doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        ConnectionDB connectionBD = new ConnectionDB();
    	Connection connection = ConnectionDB.establecerConexion();
                
        HttpSession misession = request.getSession();
        String rutCliente = (String) misession.getAttribute("rutCliente");
        
		DaoCuenta daoCuenta = new DaoCuenta(connection);
		request.setAttribute("saldo",daoCuenta.consultarRut(rutCliente));  
		
		System.out.println(daoCuenta.consultarRut(rutCliente));

		
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
        rd.forward(request, response);  

	}

	//Metodo doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
