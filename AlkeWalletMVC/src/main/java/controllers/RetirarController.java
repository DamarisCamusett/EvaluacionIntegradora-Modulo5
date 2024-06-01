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
import models.Cuenta;


@WebServlet("/RetirarController")
public class RetirarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //Constructor
    public RetirarController() {
        super();
    }
	
	//Metodo doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	     PrintWriter out=response.getWriter(); 
		
		new ConnectionDB();
    	Connection connection = ConnectionDB.establecerConexion();
    	
    	Cuenta cuenta = new Cuenta();
    	
    	
    	cuenta.setSaldo((Double.parseDouble(request.getParameter("montoretiro"))));
    	System.out.println("monto: "+cuenta.getSaldo());
    	
		DaoCuenta dao = new DaoCuenta(connection);
		double saldoActual = dao.consultarCuentaId(1);
		saldoActual = saldoActual - cuenta.getSaldo();
		
		dao.actualizarSaldoCuenta(1, saldoActual);
		
        request.setAttribute("cuenta",dao.obtenerTodaCuenta());  
		
		
		RequestDispatcher rd=request.getRequestDispatcher("vista/home.jsp");  
        rd.forward(request, response); 	
	}
	
	//Metodo doGet
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

}
