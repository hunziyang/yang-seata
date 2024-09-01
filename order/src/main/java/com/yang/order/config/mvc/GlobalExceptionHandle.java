package com.yang.order.config.mvc;


import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.yang.order.config.exception.BaseException;
import com.yang.order.config.exception.InternalServerErrorException;
import com.yang.order.config.result.Result;
import com.yang.order.config.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    private static final String ERR_MESSAGE = "service err,err message:{}";
    private static final String ERROR = "error";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletResponse response) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : exception.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return baseException(new BaseException(ResultCode.BAD_REQUEST, errors), response);
    }

    @ExceptionHandler(BindException.class)
    public Result bindException(BindException exception, HttpServletResponse response) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : exception.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return baseException(new BaseException(ResultCode.BAD_REQUEST, errors), response);
    }

    @ExceptionHandler(Exception.class)
    public Result exception(Exception exception, HttpServletResponse response) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ERROR, exception.getMessage());
        return baseException(new BaseException(ResultCode.INTERNAL_SERVER_ERROR, errors), response);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public Result internalServerErrorException(InternalServerErrorException internalServerErrorException, HttpServletResponse response) {
        return baseException(internalServerErrorException, response);
    }

    @ExceptionHandler(BaseException.class)
    public Result baseException(BaseException baseException, HttpServletResponse response) {
        log.warn(ERR_MESSAGE,
                ObjectUtils.isNotEmpty(baseException.getErrors()) ? baseException.getErrors() : baseException.getMessage(),
                baseException);
        response.setStatus(baseException.getResultCodeBase().getCode());
        return Result.error(baseException.getResultCodeBase(), baseException.getErrors());
    }

}
