package com.atuldwivedi.justgenerateit;

import com.atuldwivedi.justgenerateit.generator.Generator;
import com.atuldwivedi.justgenerateit.generator.SpringRestControllerGenerator;
import com.atuldwivedi.justgenerateit.reader.FileReader;
import com.atuldwivedi.justgenerateit.reader.Reader;
import com.atuldwivedi.justgenerateit.writer.FileWriter;
import com.atuldwivedi.justgenerateit.writer.Writer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class JustGenerateItApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustGenerateItApplication.class, args);
    }

    @Value("${template.default.rest-controller}")
    private String defaultRestControllerTemplate;

    @Bean
    public Generator restControllerGenerator(Reader reader, Writer writer) throws IOException {
        return new SpringRestControllerGenerator(reader, writer);
    }

    @Bean
    public Reader fileReader() {
        return new FileReader(defaultRestControllerTemplate);
    }

    @Bean
    public Writer fileWriter(){
        return new FileWriter("E:/workspaces/intellij/just-generate-it/","src/main/java/", "com/atuldwivedi/justgenerateit");
    }

}
