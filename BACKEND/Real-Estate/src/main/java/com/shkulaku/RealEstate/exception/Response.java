package com.shkulaku.RealEstate.exception;

import com.shkulaku.RealEstate.enumeration.ErrorsEnumeration;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Response {

    private String message;
    private LocalDateTime timestamp;

    public Response(ErrorsEnumeration errorsEnumeration) {
        setMessage(errorsEnumeration.getMessage());
        setTimestamp(LocalDateTime.now());
    }

    public Response(String message) {
        setMessage(message);
        setTimestamp(LocalDateTime.now());
    }
}