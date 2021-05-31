package com.jiangls.creationalpattern.builder;

public class ParagraphBuilder {

	public String buildParagraph(String line) {
		return "<p>" + line + "</p>";
	}
}
