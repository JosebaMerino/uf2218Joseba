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
@WebServlet("/privado/libros")
public class LibrosController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private final static Logger LOG = Logger.getLogger(LibrosController.class);


    public final static String ACCION_LISTAR = "listar";
    public final static String ACCION_AGREGAR = "agregar";
    public final static String ACCION_ELIMINAR = "eliminar";
    public final static String ACCION_FORMULARIO = "formulario";


    private final static String VIEW_LISTADO = "privado/libros/index.jsp";
    private final static String VIEW_FORMULARIO = "privado/libros/formulario.jsp";

    private static String BASE;

    private String vista;


    private static ArrayLibroDAO dao = ArrayLibroDAO.getInstance();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.trace("DOGET");

//		request.setAttribute("libros", dao.getAll());
//		request.getRequestDispatcher(VIEW_LISTADO).forward(request, response);

        doAction(request, response);
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");

        BASE = "/";


        switch (accion) {
        case ACCION_LISTAR:
            request.setAttribute("libros", dao.getAll());
            vista = VIEW_LISTADO;
            break;
        case ACCION_AGREGAR:
            agregar(request, response);
            break;
        case ACCION_ELIMINAR:
        	eliminar(request, response);
            break;
        case ACCION_FORMULARIO:
        	formulario(request, response);
        	break;

        default:
            break;
        }

        request.setAttribute("libros", dao.getAll());
        request.getRequestDispatcher(BASE + vista).forward(request, response);

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");

		int id = Integer.parseInt(pId);

		try {
			Libro libro = dao.delete(id);
    		request.setAttribute("alerta", new Alerta(Alerta.TIPO_INFORMATIVO, "Borrado correctamente", "El libro \""+ libro.getNombre() +"\" se ha borrado correctamente del DAO"));
    		vista = VIEW_LISTADO;
		} catch (Exception e) {
    		request.setAttribute("alerta", new Alerta(Alerta.TIPO_ERROR,"Problema al borrar", "No se ha podido borrar el libro correctamente del dao"));
    		vista = VIEW_FORMULARIO;
		}
	}

	private void formulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");

		int id = Integer.parseInt(pId);

		Libro libro = dao.getById(id);

		if(libro != null) {
		request.setAttribute("id", pId);
		request.setAttribute("nombre", libro.getNombre());
		request.setAttribute("autor", libro.getAutor());
		request.setAttribute("imagen", libro.getImagen());
		request.setAttribute("precio", libro.getPrecio());
		request.setAttribute("descuento", libro.getDescuento());
		vista = VIEW_FORMULARIO;
		} else {
			vista = VIEW_LISTADO;
			request.setAttribute("alerta", new Alerta(Alerta.TIPO_ERROR, "No se puede ir al formulario", "Es null o algo"));
		}
	}

	private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.trace("DOPOST");

        // Declara e inicializa el ArrayList que contendrá todos los mensajes de error.
        ArrayList<String> mensajes = new ArrayList<String>();
        boolean valido = true;

        // Recoger parametros
        String pId = request.getParameter("id");
        String pNombre = request.getParameter("nombre");
        String pAutor = request.getParameter("autor");
        String pImagen = request.getParameter("imagen");
        String pPrecio = request.getParameter("precio");
        String pDescuento = request.getParameter("descuento");

        // Validar parametros

        int id = 0;

        //// Validar id
        if(pId != null && pId.matches("^\\d+$")) {
        	id = Integer.parseInt(pId);
        }

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
        } else if (pPrecio.matches("^-\\d+([\\.,]\\d+)?$")) {
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

            libro.setId(id);
            libro.setNombre(pNombre);
            libro.setPrecio(precio);
            libro.setDescuento(descuento);
            if(pImagen !=null && !"".equals(pImagen)) {
            	libro.setImagen(pImagen);
            }
            if(pAutor !=null && !"".equals(pAutor)) {
            	libro.setAutor(pAutor);
            }


            // Guardar libro
            try {
            	if(id > 0) {
            		dao.update(id, libro);
            		request.setAttribute("alerta", new Alerta(Alerta.TIPO_INFORMATIVO, "Actualizado correctamente", "El libro \""+ libro.getNombre() +"\" se ha actualizado correctamente en el DAO"));
            	} else {
            		dao.create(libro);
            		request.setAttribute("alerta", new Alerta(Alerta.TIPO_INFORMATIVO, "Añadido correctamente", "El libro \""+ libro.getNombre() +"\" se ha añadido correctamente al DAO"));
            	}


                // Pasar atributos
                request.setAttribute("libros", dao.getAll());

                //Ir a la vista
//                request.getRequestDispatcher(VIEW_LISTADO).forward(request, response);
                vista = VIEW_LISTADO;
            } catch (Exception e) {

                // Si falla al agregar libro
                LOG.warn("No se ha podido guardar el libro correctamente");
                mensajes.add("No se ha podido guardar correctamente. Si el problema persiste, acuda al administrador del sistema.");
                request.setAttribute("mensajes", mensajes);

                request.setAttribute("nombre", pNombre);
                request.setAttribute("precio", pPrecio);
                request.setAttribute("descuento", pDescuento);

//                request.getRequestDispatcher(VIEW_FORMULARIO).forward(request, response);
                vista = VIEW_FORMULARIO;
            }

        } else {
            // Como no ha pasado la validación vuelve al formulario y no pierde el contenido del formulario.
            request.setAttribute("mensajes", mensajes);

            request.setAttribute("nombre", pNombre);
            request.setAttribute("precio", pPrecio);
            request.setAttribute("descuento", pDescuento);

//            request.getRequestDispatcher(VIEW_FORMULARIO).forward(request, response);
            vista = VIEW_FORMULARIO;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doAction(request, response);
    }
}
