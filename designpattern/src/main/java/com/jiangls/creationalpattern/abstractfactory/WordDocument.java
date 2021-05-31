package com.jiangls.creationalpattern.abstractfactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * WordDocument接口
 */
public interface WordDocument {
    void save(Path path) throws IOException;
}
