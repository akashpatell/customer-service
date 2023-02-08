package com.akash.customerservice.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author AKASH PATEL
 *
 */
@Data
public class CustomerServiceException extends RuntimeException {

	private static final long serialVersionUID = -48947107601626820L;
	private final String errorMessage;
	private final HttpStatus httpStatus;

	/**
	 * 
	 * @param errorMessage
	 * @param httpStatus
	 */
	public CustomerServiceException(String errorMessage, HttpStatus httpStatus) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

}
