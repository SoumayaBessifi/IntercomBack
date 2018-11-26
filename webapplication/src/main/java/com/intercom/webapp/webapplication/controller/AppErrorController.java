package com.intercom.webapp.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class AppErrorController implements ErrorController {

    private static final String PATH = "/error";
    private final ErrorAttributes errorAttributes;

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = PATH)
    public Map<String, Object> error(HttpServletRequest request, WebRequest webRequest, HttpServletResponse response) {
        return this.errorAttributes.getErrorAttributes(webRequest, true);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}