package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.ConnectionDB;
import dao.DaoCuenta;
import models.Cuenta;

@WebServlet("/CuentaController")
public class CuentaController extends HttpServlet {
    private static final long serialVersionUID = 5004172393132837109L;

       // Constructor
     // Método doPost de HttpServlet
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = ConnectionDB.establecerConexion();

        DaoCuenta daoCuenta = new DaoCuenta(connection);
        req.setAttribute("cuenta", daoCuenta.obtenerTodaCuenta());
       
            RequestDispatcher rd = req.getRequestDispatcher("vista/home.jsp");
            rd.forward(req, resp);
    }
    
    @Override // Método doGet de HttpServlet
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        
    }   
}


