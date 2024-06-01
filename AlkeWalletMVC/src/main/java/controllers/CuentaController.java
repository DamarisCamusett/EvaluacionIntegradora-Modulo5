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

@WebServlet("/CuentaController")
public class CuentaController extends HttpServlet {
    private static final long serialVersionUID = 5004172393132837109L;

    // Constructor
    public CuentaController() {
        super();
    }

    @Override // Método doGet de HttpServlet
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override // Método doPost de HttpServlet
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = ConnectionDB.establecerConexion();

        DaoCuenta daoCuenta = new DaoCuenta(connection);

        String action = req.getParameter("action");
        if (action != null && action.equals("retiro")) {
            // Procesar la solicitud de retiro
            String idCuentaStr = req.getParameter("idCuenta");
            String montoStr = req.getParameter("montoRetiro");

            if (idCuentaStr != null && montoStr != null) {
                int idCuenta = Integer.parseInt(idCuentaStr);
                double montoRetiro = Double.parseDouble(montoStr);

                // Lógica para realizar el retiro de dinero
                boolean retiroExitoso = daoCuenta.retirarSaldo(idCuenta, montoRetiro);

                if (retiroExitoso) {
                    out.println("Retiro exitoso.");
                } else {
                    out.println("Error al realizar el retiro.");
                }
            } else {
                out.println("Parámetros incompletos para el retiro.");
            }
        } else {
            req.setAttribute("cuenta", daoCuenta.obtenerTodaCuenta());
            RequestDispatcher rd = req.getRequestDispatcher("vista/home.jsp");
            rd.forward(req, resp);
        }
    }
}

