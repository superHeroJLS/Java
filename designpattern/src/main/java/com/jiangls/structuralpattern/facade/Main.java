package com.jiangls.structuralpattern.facade;

import com.jiangls.structuralpattern.facade.organization.Company;

import java.io.IOException;


/**
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Facade facade = new Facade();
		Company c = facade.openCompany("Facade Software Ltd.");
		System.out.println(c);
	}
}
