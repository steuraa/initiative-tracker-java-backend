/*
  Helper class that creates a list of objects (RequestBodyError) from Spring validation errors,
  coming in from the frontend.
  Each RequestBodyError contains the validated field that gives an error and the error message.
 */

package com.steuraa.inittrackerjava.entrypoints.error_entities;

import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

public class RequestBodyErrors {
    private List<RequestBodyError> errors = new ArrayList<>();

    public RequestBodyErrors() {
    }

    public RequestBodyErrors(RequestBodyError error) {
        errors.add(error);
    }

    public RequestBodyErrors(Errors errors) {
        errors.getFieldErrors().parallelStream()
            .forEach(error -> this.errors.add(new RequestBodyError(error.getField(), error.getDefaultMessage())));
    }

    public List<RequestBodyError> getErrors() {
        return errors;
    }

    public void setErrors(List<RequestBodyError> errors) {
        this.errors = errors;
    }
}
