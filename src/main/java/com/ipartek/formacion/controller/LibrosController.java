package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Libro;

/**
 * Servlet implementation class LibrosController
 */
@WebServlet("/libros")
public class LibrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private final static Logger LOG = Logger.getLogger(LibrosController.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibrosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.trace("DOGET");
		request.setAttribute("libro", new Libro());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("DOPOST");
		// Recoger parametros
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");

		// Pasar atributos
		request.setAttribute("id", id);
		request.setAttribute("nombre", nombre);


		//Ir a la vista
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
