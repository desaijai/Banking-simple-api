package com.mongobank.bankingSys.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class apiResponse {

    private String msg;
    private Boolean res;

}
