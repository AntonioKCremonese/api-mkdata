package com.br.antonio.apimkdata.handlerExceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestErrorHandler {
	
	 	@ExceptionHandler(CustomException.class)
	 	@ResponseBody
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ErrorResponse handleCustomException(CustomException ex) {
		 	System.out.println("Lançou exception");
		 	ErrorResponse errorResponse = new ErrorResponse(ex.getError(),ex.getMessage());
		 	return errorResponse;
	       
	    }
}
