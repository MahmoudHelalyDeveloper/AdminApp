package com.app.exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.model.exception.ErrorDetails;
@ControllerAdvice
public class GeneralException extends ResponseEntityExceptionHandler  {
	
	
    private final MessageSource messageSource;

    @Autowired
    public GeneralException(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    
    
    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<ErrorDetails> handleBusinessException(BusinessException ex, WebRequest request) {
//        LOGGER.warn(ex.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
//        if (ex.getParams() != null) {
//            errorDetails.setParamObjects(ex.getParams());
//        }
        return new ResponseEntity<>(errorDetails, ex.getHttpStatus());
    }
	   
}
