package com.maipiande.rubbish;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public RubbishResult handleRuntimeException(RuntimeException e) {

        if (e instanceof HttpMessageConversionException){
            log.error("请求参数异常："+e.getMessage(),e);
            return RubbishResult.fail("参数异常");
        }
        log.error("rubbis exception is ....",e.getMessage(),e);
        return RubbishResult.fail(e.getMessage());
    }
}
