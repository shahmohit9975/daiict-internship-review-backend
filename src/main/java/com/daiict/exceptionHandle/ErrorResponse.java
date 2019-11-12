package com.daiict.exceptionHandle;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	public ErrorResponse(String message, List<String> details, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.details = details;
		this.httpStatus = httpStatus;
		this.status = this.httpStatus.value();

	}

	private String message;
	private List<String> details;
	private HttpStatus httpStatus;
	private int status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	// getters and setters

}