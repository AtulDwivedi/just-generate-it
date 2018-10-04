package com.atuldwivedi.justgenerateit.writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileWriter implements Writer {

    private String source;

    private String target;

    private String path;

    private String fileName = "EmployeeService.java";

    public FileWriter(String source, String target, String path) {
        this.source = source;
        this.target = target;
        this.path = path;
    }

    @Override
    public void write(String fileTemplate) {


        fileTemplate = fileTemplate.replace("{{mainPackageName}}", path.replace("/", "."));
        fileTemplate = fileTemplate.replace("{{entityName}}", "Employee");
        fileTemplate = fileTemplate.replace("{{serviceName}}", "Employee".toLowerCase());
        fileTemplate = fileTemplate.replace("{{restServicePrefix}}", "/rest");


        PrintWriter writer;

        try {
            writer = new PrintWriter(source + target + "/" + path + "/" + fileName, "UTF-8");
            writer.print(fileTemplate);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
