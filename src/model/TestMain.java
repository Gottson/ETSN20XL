package model;

import util.XLException;

public class TestMain {
	
	public static void main(String[] args) {
		XLsheet sheet = new XLsheet();
		
		
		sheet.add("A1", "#horse");
		sheet.add("A2", "5");
		sheet.add("A3", "7");
		sheet.add("B1", "A2+A3");
		sheet.add("B2", "B1+5");
		try {
			sheet.add("B3", "B1+tamrs");
		} catch (XLException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(sheet.value("A1"));
		} catch (XLException e) {
			e.printStackTrace();
		}
		System.out.println(sheet.value("A2"));
		System.out.println(sheet.value("A3"));
		System.out.println(sheet.value("B1"));
		System.out.println(sheet.value("B2"));
		try {
			System.out.println(sheet.value("A1"));
		} catch (XLException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(sheet.value("B3"));
		} catch (XLException e) {
			e.printStackTrace();
		}
		try {
			sheet.add("A1", "B1+A1");
		}  catch (XLException e) {
			e.printStackTrace();
		}
		System.out.println(sheet.value("A3"));
	}
}
