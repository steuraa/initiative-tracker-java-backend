/*
  Validation error
 */
package com.steuraa.inittrackerjava.entrypoints.error_entities;

public class RequestBodyError {
    private String field;
    private String message;

    public RequestBodyError() {
    }

    public RequestBodyError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
