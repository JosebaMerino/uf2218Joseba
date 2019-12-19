package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.pojo.Libro;

public class ArrayLibroDAO implements IDAO<Libro> {

	private static ArrayLibroDAO INSTANCE;
	private ArrayList<Libro> registros;
	private int indice = 1;

	private ArrayLibroDAO() {
		super();
		registros = new ArrayList<Libro>();

		registros.add(new Libro(indice++, "El libro que necesitas para aprobar este examen", 1.0f));
		registros.add(new Libro(indice++, "El libro que necesitas para aprobar este examen, bueno quizas necesites otro pero este tampoco esta nada mal la verdad", 2.0f));
		registros.add(new Libro(indice++, "Este es mas nuevo que el anterior", 9.0f));

	}

	public static synchronized ArrayLibroDAO getInstance() {
		// Aqui es donde se comprueba si existe la instancia.
		// Si existe la devuelve y sino la crea. Pero solo habra una instancia de esa clase.
		if(INSTANCE == null) {
			INSTANCE = new ArrayLibroDAO();
		}

		return INSTANCE;
	}

	@Override
	public List<Libro> getAll() {
		return registros;
	}

	@Override
	public Libro getById(int id) {
		Libro resul = null;

		for (Libro Libro : registros) {
			if (Libro.getId() == id) {
				resul = Libro;
				break;
			}
		}

		return resul;
	}

	@Override
	public Libro delete(int id) throws Exception {
		Libro resul = null;

		for (int i = 0; i < registros.size(); i++) {
			Libro Libro = registros.get(i);
			if(Libro.getId() == id) {
				registros.remove(i);
				resul = Libro;
			}
		}

		if(resul == null) {
			throw new Exception("Libro a eliminar no encontrado");
		}

		return resul;
	}

	@Override
	public Libro update(int id, Libro pojo) throws Exception {
		Libro resul = null;

		for(int i = 0; i < registros.size(); i++) {
			Libro Libro = registros.get(i);
			if(Libro.getId() == id) {
				pojo.setId(id);
				registros.set(i, pojo);
				resul = pojo;
			}

		}

		if( resul == null) {
			throw new Exception("Libro a actualizar no encontrado");
		}

		return resul;
	}

	@Override
	public Libro create(Libro pojo) throws Exception {
		Libro resul = null;

		if(pojo != null) {
			pojo.setId(indice);
			indice++;

			registros.add(pojo);

			resul = pojo;
		} else {
			throw new Exception("Libro null");
		}

		return resul;
	}



}
