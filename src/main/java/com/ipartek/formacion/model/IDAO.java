package com.ipartek.formacion.model;

import java.util.List;

public interface IDAO<P> {
	/**
	 * Obtiene todos los datos
	 * @return lista de pojos
	 */
	List<P> getAll();

	/**
	 * recupera un pojo por su identificador
	 * @param id identificador
	 * @return pojo si lo encuentra, sino null
	 */
	P getById(int id);

	/**
	 * borra un pojo por su identificador
	 * @param id identificador
	 * @return pojo pojo borrado
	 * @throws Exception si no lo ha encontrado o no se ha podido eliminar
	 */
	P delete(int id) throws Exception;

	/**
	 * Moodifica un pojo por su identificador
	 * @param id identificador
	 * @param pojo pojo con campos cambiados
	 * @return pojo pojo actualizado
	 * @throws Exception si no lo ha encontrado o no lo puede modificar
	 */
	P update(int id, P pojo) throws Exception;

	/**
	 * crea un nuevo pojo
	 * @param pojo a crear
	 * @return pojo creado con el id nuevo
	 * @throws Exception si no puede crear.
	 */
	P create(P pojo) throws Exception;
}
