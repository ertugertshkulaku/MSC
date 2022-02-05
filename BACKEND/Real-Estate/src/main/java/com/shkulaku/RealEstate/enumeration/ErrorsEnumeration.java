package com.shkulaku.RealEstate.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorsEnumeration {

    UNEXPECTED_ERROR(0, "Unexpected error"),
    BAD_REQUEST(1, "Bad request"),
    RESULT_NOT_FOUND(2, "No result found"),
    UNAUTHORIZED(3, "Unauthorized"),
    INTERNAL_SERVER_ERROR(4, "Internal server error"),
    BAD_GATEWAY(5, "Bad gateway"),
    NOT_FOUND(6, "Resource not found");

    public final int code;
    public final String message;

    @Override
    public String toString() {
        return code + " : " + message;
    }
}
