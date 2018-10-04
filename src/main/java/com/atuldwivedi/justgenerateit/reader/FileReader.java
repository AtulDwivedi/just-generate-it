package com.atuldwivedi.justgenerateit.reader;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader implements Reader {

    private static final String EMPTY_TEXT = "";

    private String fullyQualifiedFileNameWithExtension;

    @Override
    public String readContentContentAsText() throws IOException {
        StringBuilder result = new StringBuilder(EMPTY_TEXT);
        File file = new ClassPathResource(fullyQualifiedFileNameWithExtension).getFile();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public FileReader(String restControllerTemplate) {
        this.fullyQualifiedFileNameWithExtension = restControllerTemplate;
    }
}
