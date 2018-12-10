package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.XLsheet;
import util.XLException;

class XLsheetPredicate {
	XLsheet sheet = new XLsheet();
	XLException e;

	// Add existing address to sheet.
	@Test
	void test1() {
		sheet.add("A1", "1");
		sheet.add("A1", "5");
		assertEquals("5.00", sheet.getInput("A1"));
	}

	// Add element with empty input
	@Test
	void test2() {
		sheet.add("A2", "");
		assertEquals("", sheet.getInput("A1"));
	}

	// Add element with empty input in an address
	// that is referred to from other address.
	@Test()
	void test3() throws XLException {
		sheet.add("A1", "1");
		sheet.add("A3", "A1");

		try {
			sheet.add("A1", " ");
		} catch (XLException ex) {
			e = ex;
			assertEquals("1.00",sheet.getInput("A1"));
		}
		//(e instanceof XLException);
	}

	// Add new input on new address
	@Test()
	void test4() {
		sheet.add("A4", "1");
		assertEquals("1.00", sheet.getInput("A4"));
	}

	// Add bad input
	@Test()
	void test5() throws XLException {
		
		try {
			sheet.add("A1", "1/0");
		} catch (XLException ex) {
			e = ex;
		}
		assertTrue(e instanceof XLException);
	}
	// Add comment 
	@Test()
	void test6() {
		sheet.add("A7", "#comment");
		assertEquals("comment",sheet.getText("A7"));
	}
	// Dumt test 
	@Test()
	void test7() {
		sheet.add("fakeadress", "#comment");
		
	}
}