package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String USUARIO= "admin";
	private static final String PASSWORD = "123456";

	private static final String VIEW_PRINCIPAL_PRIVADO = "privado/index.jsp";
	private static final String VIEW_LOGIN = "login.jsp";



    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		if(USUARIO.equals(usuario) && PASSWORD.equals(password)) {
			session.setAttribute("usuarioLogeado", usuario);
			request.setAttribute("alerta", new Alerta(Alerta.TIPO_INFORMATIVO, "Bienvenido", "Le damos la bienvenida " + usuario));
			request.getRequestDispatcher(VIEW_PRINCIPAL_PRIVADO).forward(request, response);

		} else {
			request.setAttribute("alerta", new Alerta(Alerta.TIPO_ALERTA, "Usuario o contraseña incorrecto", "El usuario o la contraseña son incorrectos"));
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
		}


	}
}
