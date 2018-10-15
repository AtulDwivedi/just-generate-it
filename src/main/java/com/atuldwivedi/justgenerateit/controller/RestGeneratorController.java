package com.atuldwivedi.justgenerateit.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
@RequestMapping(value = "/generator/rest")
public class RestGeneratorController {

    @GetMapping(value = "/spring-rest-controller")
    public String showApringRestGeneratorForm() {
        return "spring-rest-controller";
    }

    @PostMapping(value = "/just-generate-it")
    public void generateSpringRestController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.print("Generating spring rest controller...");
        String modelClasses = request.getParameter("modelClasses");
        String serviceClasses = request.getParameter("serviceClasses");

        response.setHeader("Content-Disposition", "attachment; filename="+modelClasses+".java");
        response.setContentType("application/vnd.ms-excel");
        OutputStream outStream = response.getOutputStream();
        InputStream inStream = new ClassPathResource("templates/code/spring-rest-controller-template.tmpt").getInputStream();

        byte[] buf = new byte[4096];
        int len = -1;

//Write the file contents to the servlet response
//Using a buffer of 4kb (configurable). This can be
//optimized based on web server and app server
//properties
        while ((len = inStream.read(buf)) != -1) {
            outStream.write(buf, 0, len);
        }

        outStream.flush();
        outStream.close();

    }
}
