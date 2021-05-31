package com.jiangls.creationalpattern.abstractfactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * HtmlDocument接口
 */
public interface HtmlDocument {
    String toHtml();

    void save(Path path) throws IOException;
}
