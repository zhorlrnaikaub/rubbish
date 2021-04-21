package com.maipiande.rubbish;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public RubbishResult handleRuntimeException(RuntimeException e) {
        log.error("rubbis exception is ....",e.getMessage(),e);
        return RubbishResult.fail(e.getMessage());
    }
}
