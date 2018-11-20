/*
  Helper class to send an error message to the frondend.
 */

package com.steuraa.inittrackerjava.entrypoints.error_entities;

public class ErrorResponse {
    private String error;

    public ErrorResponse() {
    }

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
