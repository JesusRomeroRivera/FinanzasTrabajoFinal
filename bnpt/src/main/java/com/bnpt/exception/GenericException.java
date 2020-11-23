package com.bnpt.exception;

public class GenericException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GenericException(String mensaje) {
        super(mensaje);
	}
}
