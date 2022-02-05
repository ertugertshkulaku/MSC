package com.shkulaku.RealEstate.exception;

import com.shkulaku.RealEstate.enumeration.ErrorsEnumeration;
import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class BadRequestException extends RuntimeException{

    private HttpStatus httpStatus;
    private ErrorsEnumeration errorsEnumeration;

    public BadRequestException(String msg, Throwable t) {
        super(msg, t);
    }

    public BadRequestException(String msg) {
        super(msg);
    }
}
