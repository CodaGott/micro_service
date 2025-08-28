package com.dozie.OrderService.web.exception;

import com.dozie.OrderService.web.external.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
        int statusCode = exception.getStatus();
        HttpStatus httpStatus;

        try {
            httpStatus = HttpStatus.valueOf(statusCode);
        } catch (IllegalArgumentException e) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .message(exception.getMessage())
                        .errorCode(exception.getErrorCode())
                        .build(),
                httpStatus
        );
    }
}
