package com.atuldwivedi.justgenerateit.generator;

import com.atuldwivedi.justgenerateit.reader.Reader;
import com.atuldwivedi.justgenerateit.writer.Writer;

import java.io.IOException;

public class SpringRestControllerGenerator implements Generator {

    private Reader reader;

    private Writer writer;


    public SpringRestControllerGenerator(Reader reader, Writer writer) throws IOException {
        this.reader = reader;
        this.writer = writer;
        generate();
    }

    @Override
    public void generate() throws IOException {
        String content = reader.readContentContentAsText();
        writer.write(content);
    }

}
