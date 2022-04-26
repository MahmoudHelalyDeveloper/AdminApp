package com.app.model.exception;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @author rehab.abd-elhamid
 */
//https://stackoverflow.com/questions/37841373/java-lang-illegalargumentexception-no-converter-found-for-return-value-of-type
public class ErrorDetails implements Serializable {
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")

    private Date timestamp;
    private String message;
    private String details;
    private Object[] paramObjects;

    public ErrorDetails(Date timestamp, String message, String details, Object[] paramObjects) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.paramObjects = paramObjects;
    }

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Object[] getParamObjects() {
        return paramObjects;
    }

    public void setParamObjects(Object[] paramObjects) {
        this.paramObjects = paramObjects;
    }

}
