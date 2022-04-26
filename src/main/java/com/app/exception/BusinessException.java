package com.app.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

	 private Object[] params = null;
	 
	 private HttpStatus  httpStatus;

	    public BusinessException(String message) {
	        super(message);
	    }

	    public BusinessException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public BusinessException(String message, Object[] params) {
	        super(message);
	        this.params = params;
	    }
	    
	    
	    
	    

	    public BusinessException(String message,Object[] params, HttpStatus httpStatus) {
	    	 super(message);
			this.params = params;
			this.httpStatus = httpStatus;
		}

		public Object[] getParams() {
	        return params;
	    }

	    public void setParams(Object[] params) {
	        this.params = params;
	    }

		public HttpStatus getHttpStatus() {
			return httpStatus;
		}

		public void setHttpStatus(HttpStatus httpStatus) {
			this.httpStatus = httpStatus;
		}

	
	
}
