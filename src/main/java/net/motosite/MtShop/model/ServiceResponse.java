package net.motosite.MtShop.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ServiceResponse<T> extends ResponseEntity<T> {
    private String errorMessage;

    public ServiceResponse() {
        super(HttpStatus.OK);
    }

    public ServiceResponse(HttpStatus status) {
        super(status);
        if (status.equals(HttpStatus.NOT_FOUND)){
            errorMessage = "not found";
        }
    }

    public ServiceResponse(T data) {
        super(data, HttpStatus.OK);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}