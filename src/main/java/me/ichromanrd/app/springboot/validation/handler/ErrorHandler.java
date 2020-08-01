package me.ichromanrd.app.springboot.validation.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import me.ichromanrd.app.springboot.validation.data.ErrorResponse;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse invalidArgumentHandler(MethodArgumentNotValidException exception) {
        return new ErrorResponse(exception.getMessage());
    }

}
