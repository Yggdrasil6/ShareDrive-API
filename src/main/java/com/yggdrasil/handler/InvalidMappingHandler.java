/*
package com.yggdrasil.handler;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class InvalidMappingHandler implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public String handlerError(HttpServletResponse response) {
        */
/*String requestUri = RequestContextHolder.getRequestAttributes().getAttribute("javax.servlet.error.request_uri", RequestAttributes.SCOPE_REQUEST).toString();
        if (requestUri.split("/")[0].equals("api")) {

            try {
                PrintWriter writer = response.getWriter();
                writer.write("瞎几把发送");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*//*

        return "瞎几把发送请求";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
*/
