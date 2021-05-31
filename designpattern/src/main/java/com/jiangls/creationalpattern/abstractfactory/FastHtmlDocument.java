package com.jiangls.creationalpattern.abstractfactory;

import java.io.IOException;
import java.nio.file.Path;

public class FastHtmlDocument implements HtmlDocument {
    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public void save(Path path) throws IOException {

    }
}
