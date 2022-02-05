package com.shkulaku.RealEstate.exception;

import com.shkulaku.RealEstate.enumeration.ErrorsEnumeration;
import com.shkulaku.RealEstate.utilities.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

@ControllerAdvice
public class CustomExceptionController extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(CustomException.class)
    protected final ResponseEntity<String> handleCustomConflict(CustomException ex){
        logger.error("[{}] status: [{}] type: [{}]  error: [{}]", Utilities.getCurrentMethodName(),ex.getHttpStatus(), ex.getErrorsEnumeration(), ex.getErrorMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getErrorMessage());
    }

    /**
     * Exception launched if result with id not found
     * */
    @ExceptionHandler(NoSuchElementException.class)
    protected final ResponseEntity<Response> handleCustomConflict(NoSuchElementException ex){
        logger.error("{}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Response(ErrorsEnumeration.RESULT_NOT_FOUND));
    }

    @ExceptionHandler(TimeoutException.class)
    protected final ResponseEntity<Response> handleCustomConflict(TimeoutException ex){
        logger.error("{}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Response(ErrorsEnumeration.RESULT_NOT_FOUND));
    }

    /*** caso pozzo ***/
    @ExceptionHandler(Exception.class)
    protected final ResponseEntity<Response> handleConflict(Exception ex){
        logger.error("{}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response(ErrorsEnumeration.UNEXPECTED_ERROR));
    }
}
