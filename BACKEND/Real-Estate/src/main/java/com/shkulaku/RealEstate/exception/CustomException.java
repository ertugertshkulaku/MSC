package com.shkulaku.RealEstate.exception;

import com.shkulaku.RealEstate.enumeration.ErrorsEnumeration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException {

    private HttpStatus httpStatus;
    private ErrorsEnumeration errorsEnumeration;
    private String errorMessage;
}
