package com.yggdrasil.handler;

import com.yggdrasil.exception.CustomerInternalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;;

@ResponseBody
@ControllerAdvice

public class DefaultExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = CustomerInternalException.class)
    public String handleTechinicException(Exception e) {
        logger.error("IntervalException:", e);
        return e.getMessage();
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = CustomerAuthenticationException.class)
    public String handleLoginaAuthException(Exception e) {
        logger.error("AuthenticationException", e);
        return e.getMessage();
    }*/

   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = UnValidMappingException.class)
    public String handleInvalidMappingException(Exception e) {
        return "fuck";

    }*/
}
