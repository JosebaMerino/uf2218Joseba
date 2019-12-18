package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("DOGET");

		request.setAttribute("libros", dao.getAll());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("DOPOST");

		// Declara e inicializa el ArrayList que contendrá todos los mensajes de error.
		ArrayList<String> mensajes = new ArrayList<String>();
		boolean valido = true;

		// Recoger parametros
		String pNombre = request.getParameter("nombre");
		String pPrecio = request.getParameter("precio");
		String pDescuento = request.getParameter("descuento");

		// Validar parametros

		//// Validar nombre
		if (pNombre == null || pNombre.length() < 2 || pNombre.length() > 100) {
			valido = false;
			mensajes.add("El nombre debe tener de 2 a 100 caracteres");

		}

		//// Validar precio
		float precio = 0.0f;

		if(pPrecio != null && pPrecio.matches("^\\d+([\\.,]\\d+)?$")) {
			pPrecio = pPrecio.replace(',', '.');
			precio = Float.parseFloat(pPrecio);
		} else if (pPrecio.matches("^-\\d+(\\d+)?$")) {
			valido = false;
			mensajes.add("El precio no puede ser menor que 0.");
		} else {
			valido = false;
			mensajes.add("El precio no es un numero valido, debe ser un número decimal mayor que 0 y con un maximo de 2 decimales.");
		}

		//// Validar descuento
		int descuento = 0;

		if(pDescuento != null && pDescuento.matches("^\\d+$")) {
			descuento = Integer.parseInt(pDescuento);
			if(descuento < 0 || descuento > 100) {
				valido = false;
				mensajes.add("El descuento debe ser mayor o igual a 0 y menor o igual a 100.");
			}
		} else if(pDescuento != null && pDescuento.matches("^-\\d+$")) {
			valido = false;
			mensajes.add("El descuento no puede ser un número negativo");
		}
		else {
			valido = false;
			mensajes.add("El descuento no es un numero");
		}

		if(valido == true) {
			// Crear libro a guardar
			Libro libro = new Libro();

			libro.setNombre(pNombre);
			libro.setPrecio(precio);
			libro.setDescuento(descuento);

			// Guardar libro
			try {
				dao.create(libro);
				// Pasar atributos
				request.setAttribute("libros", dao.getAll());
				request.setAttribute("alerta", new Alerta(Alerta.TIPO_SUCCESS, "Añadido correctamente", "El libro \""+ libro.getNombre() +"\" se ha añadido correctamente al DAO"));

				//Ir a la vista
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (Exception e) {
				
				// Si falla al agregar libro
				LOG.warn("No se ha podido guardar el libro correctamente");
				mensajes.add("No se ha podido guardar correctamente. Si el problema persiste, acuda al administrador del sistema.");
				request.setAttribute("mensajes", mensajes);

				request.setAttribute("nombre", pNombre);
				request.setAttribute("precio", pPrecio);
				request.setAttribute("descuento", pDescuento);

				request.getRequestDispatcher("formulario.jsp").forward(request, response);
			}

		} else {
			// Como no ha pasado la validación vuelve al formulario y no pierde el contenido del formulario.
			request.setAttribute("mensajes", mensajes);

			request.setAttribute("nombre", pNombre);
			request.setAttribute("precio", pPrecio);
			request.setAttribute("descuento", pDescuento);

			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}

	}

}
