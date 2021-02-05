package com.java.learning.exceptionhandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleNullPointerException(NullPointerException exception){
		 Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "null pointer exception");
	        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<Object> handleIndexOutOfBoundsException(IndexOutOfBoundsException exception){
		 Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "index out of bound exception");
	        return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
}
