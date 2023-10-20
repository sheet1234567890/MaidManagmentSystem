package com.adda.app.CustomException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandllerClass {

	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<CustomMsg> userExistException(UserExistException e)
	{
		return new ResponseEntity<CustomMsg>(new CustomMsg(new Date().toString(),500,"Exception in process",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
