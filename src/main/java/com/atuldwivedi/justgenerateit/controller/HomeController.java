package com.atuldwivedi.justgenerateit.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class HomeController {

    @GetMapping("/spring-rest-controller")
    public String springRestController() {
        return "spring-rest-controller";
    }

    @GetMapping("/file")
    public void getFile(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=datafile.txt");
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
