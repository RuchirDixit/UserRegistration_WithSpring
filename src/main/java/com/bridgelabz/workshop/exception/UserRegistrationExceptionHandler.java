package com.bridgelabz.workshop.exception;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bridgelabz.workshop.dto.ResponseDTO;

@ControllerAdvice
public class UserRegistrationExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodNotValidArgumentException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMsg = errorList.stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO response = new ResponseDTO("Exception For Invalid Arguments", errorMsg);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.BAD_REQUEST); 
	}

}
