package com.educandoweb.course.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {//RuntimeException uma exceção que o compilador não te obriga a tratar

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException( Object id) {
        //construtor da super classe
        super("Resource not found. Id "+id);
    }
}
