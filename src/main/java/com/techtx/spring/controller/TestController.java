package com.techtx.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping(value = "/post", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String postData(@RequestHeader(HttpHeaders.CONTENT_TYPE) MediaType contentType, HttpServletRequest request) throws IOException {
        if (MediaType.APPLICATION_JSON.equals(contentType)) {
            StringBuilder requestBodyStringBuilder = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBodyStringBuilder.append(line);
            }
            String requestBody = requestBodyStringBuilder.toString();
            System.out.println(requestBody);
        }
        else if (MediaType.APPLICATION_FORM_URLENCODED.equals(contentType)) {
            String queryString = request.getParameter("data");
            System.out.println(queryString);
        }
        return "Hello, stranger!";
    }

    @GetMapping("/get")
    public String postData()
    {
        System.out.println("HI");
        return "Hi";
    }

}
