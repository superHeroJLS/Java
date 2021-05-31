package com.jiangls.creationalpattern.builder;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * 以Markdown转HTML为例，因为直接编写一个完整的转换器比较困难，但如果针对类似下面的一行文本：
 * <p># this is a heading</p>
 * 转换成html就很简单
 * <p><h1>this is a heading</h1></p>
 *
 * 因此，我们把Markdown转HTML看作一行一行的转换，每一行根据语法，使用不同的转换器：
 * <ol>
 * <li>如果以#开头，使用HeadingBuilder转换；</li>
 * <li>如果以>开头，使用QuoteBuilder转换；</li>
 * <li>如果以---开头，使用HrBuilder转换；</li>
 * <li>其余使用ParagraphBuilder转换。</li>
 * </ol>
 * 这个HtmlBuilder写出来如下：
 */
public class HtmlBuilder {
    private HeadingBuilder headingBuilder = new HeadingBuilder();
    private HrBuilder hrBuilder = new HrBuilder();
    private ParagraphBuilder paragraphBuilder = new ParagraphBuilder();
    private QuoteBuilder quoteBuilder = new QuoteBuilder();

    public String toHtml(String markdown) {
        StringBuilder buffer = new StringBuilder();
        BufferedReader br = new BufferedReader(new StringReader(markdown));
        br.lines().forEach(line -> {
            if (line.startsWith("#")) {
                buffer.append(headingBuilder.buildHeading(line)).append('\n');
            } else if (line.startsWith(">")) {
                buffer.append(quoteBuilder.buildQuote(line)).append('\n');
            } else if (line.startsWith("---")) {
                buffer.append(hrBuilder.buildHr(line)).append('\n');
            } else {
                buffer.append(paragraphBuilder.buildParagraph(line)).append('\n');
            }
        });
        return buffer.toString();
    }
}
