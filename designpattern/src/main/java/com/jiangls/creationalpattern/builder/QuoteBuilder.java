package com.jiangls.creationalpattern.builder;

public class QuoteBuilder {

	public String buildQuote(String line) {
		return "<blockquote>" + line.substring(1).trim() + "</blockquote>";
	}
}
