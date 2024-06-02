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

@WebServlet("/DepositController")
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Metodo doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ConnectionDB connectionDB = new ConnectionDB();
		Connection connection = connectionDB.establecerConexion();

		Cuenta cuenta = new Cuenta();

		cuenta.setSaldo((Double.parseDouble(request.getParameter("monto"))));
		System.out.println("Monto: " + cuenta.getSaldo());

		// public void actualizarSaldo(int id, double saldo)
		DaoCuenta dao = new DaoCuenta(connection);
		double saldoActual = dao.consultarCuentaId(1);
		saldoActual = saldoActual + cuenta.getSaldo();

		dao.actualizarSaldoCuenta(1, saldoActual);

		request.setAttribute("cuenta", dao.obtenerTodaCuenta());

		RequestDispatcher rd = request.getRequestDispatcher("vista/home.jsp");
		rd.forward(request, response);
	}

	// Metodo doGet
	@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
