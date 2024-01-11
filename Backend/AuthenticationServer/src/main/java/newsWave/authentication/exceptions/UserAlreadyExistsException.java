package newsWave.authentication.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserAlreadyExistsException extends RuntimeException {

	String fieldName ;
	
	public UserAlreadyExistsException() {
		
	}
	
	public UserAlreadyExistsException(String fieldName) {
		super(String.format("User with EmailId : %s Already Exist", fieldName)) ;
		this.fieldName=fieldName ;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
