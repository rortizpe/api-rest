package com.sermaluc.apirestdemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class CustomControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ErrorResponse handleMyException(CustomException ex, HttpServletResponse response) {

        //response.setStatus(ex.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse();
        //errorResponse.setError(ex.getErrorCode());
        //errorResponse.setName(ex.getErrorName());
        errorResponse.setMessage(ex.getErrorMessage());

        return errorResponse;
    }

    @ExceptionHandler(ValidateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessageErrorResponse handleMyValidationException(ValidateException ex) {
        return ex.getErrMsg();
    }
}
