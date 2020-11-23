package com.bnpt.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

	T registrar(T t);

	T modificar(T t);

	void eliminar(ID id);

	Optional<T> listId(ID id);

	List<T> listar();

}
