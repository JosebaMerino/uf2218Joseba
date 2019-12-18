package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.ArrayLibroDAO;
import com.ipartek.formacion.model.pojo.Libro;

/**
 * Servlet implementation class LibrosController
 */
@WebServlet("/libros")
public class LibrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private final static Logger LOG = Logger.getLogger(LibrosController.class);

	private static ArrayLibroDAO dao = ArrayLibroDAO.getInstance();

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

    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	try {
			dao.create(new Libro(1, "Los juegos de la sed", 20.0f, 1));
			dao.create(new Libro(2, "Los juegos de la sed sin ajo", 22.0f, 1));
		} catch (Exception e) {
			LOG.warn("No se ha podido añadir el libro correctamente");
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.trace("DOGET");

		request.setAttribute("libros", dao.getAll());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("DOPOST");
		// Recoger parametros
		String pId = request.getParameter("id");
		String pNombre = request.getParameter("nombre");

		int id = Integer.parseInt(pId);

		// Crear libro a guardar
		Libro libro = new Libro();
		libro.setId(id);
		libro.setNombre(pNombre);

		// Guardar libro
		try {
			dao.create(libro);
		} catch (Exception e) {
			LOG.warn("No se ha podido guardar el libro correctamente");
		}

		// Pasar atributos
		request.setAttribute("libros", dao.getAll());

		//Ir a la vista
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
