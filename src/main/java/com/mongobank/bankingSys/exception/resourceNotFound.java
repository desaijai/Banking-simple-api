package com.mongobank.bankingSys.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class resourceNotFound extends RuntimeException{

    private String resourceName;
    private String resourceFieldName;
    private Object resourceId;

    public resourceNotFound(String resourceName, String resourceFieldName, Object resourceId) {
        super(String.format("%s not found with this %s: %s",resourceName,resourceFieldName,resourceId));
        this.resourceName = resourceName;
        this.resourceFieldName = resourceFieldName;
        this.resourceId = resourceId;
    }
}
