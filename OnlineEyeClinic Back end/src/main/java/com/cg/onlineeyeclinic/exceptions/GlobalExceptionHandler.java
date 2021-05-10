package com.cg.onlineeyeclinic.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler 
{
	
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) 
		{
			Map<String,String> errors=new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error)->
			{
				String fieldName=((FieldError)error).getField();
				String message=error.getDefaultMessage();
				errors.put(fieldName, message);
			});
		  return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		}
	
	    @ExceptionHandler(IdNotFoundException.class)
	    public ResponseEntity<ErrorDetails> idNotFoundException(IdNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(AppointmentNotFoundException.class)
	    public ResponseEntity<ErrorDetails> appointmentNotFoundException(AppointmentNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(ReportNotFoundException.class)
	    public ResponseEntity<ErrorDetails> reportNotFoundException(ReportNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(TestNotFoundException.class)
	    public ResponseEntity<ErrorDetails> testNotFoundException(TestNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(DoctorNotFoundException.class)
	    public ResponseEntity<ErrorDetails> doctorNotFoundException(DoctorNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    

	    @ExceptionHandler(PatientNotFoundException.class)
	    public ResponseEntity<ErrorDetails> patientNotFoundException(PatientNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(AdminNotFoundException.class)
	    public ResponseEntity<ErrorDetails> adminNotFoundException(AdminNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    
	    @ExceptionHandler(SpectacleNotFoundException.class)
	    public ResponseEntity<ErrorDetails> spectacleNotFoundException(SpectacleNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(NameNotFoundException.class)
	    public ResponseEntity<ErrorDetails> nameNotFoundException(NameNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    
	    @ExceptionHandler(UserNameAlreadyExistException.class)
	    public ResponseEntity<ErrorDetails> userNameAlreadyExistException(UserNameAlreadyExistException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    
	    @ExceptionHandler(Exception.class) 
		  public ResponseEntity<ErrorDetails> globleExcpetionHandler(Exception ex, WebRequest request) { ErrorDetails
		  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
		  return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); 
		  }

}
