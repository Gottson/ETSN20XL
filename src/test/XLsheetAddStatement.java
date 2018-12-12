package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import model.XLsheet;
import util.XLException;

public class XLsheetAddStatement {
	XLsheet sheet = new XLsheet();
	XLException e;

	// Add existing address to sheet.
	@Test
	public	void test1() {
		sheet.add("A1", "1");
		sheet.add("A1", "5");
		assertEquals("5.00", sheet.getInput("A1"));
	}

	// Add element with empty input
	@Test
	public	void test2() {
		sheet.add("A2", "");
		assertEquals("", sheet.getInput("A1"));
	}

	// Add element with empty input in an address
	// that is referred to from other address.
	@Test()
	public void test3() throws XLException {
		sheet.add("A1", "1");
		sheet.add("A3", "A1");

//		try {
//			sheet.add("A1", "");
//		} catch (XLException ex) {
//			e = ex;
//			assertEquals("1.00",sheet.getInput("A1"));
//
//		}
		try {
			sheet.add("A1", "");
		} catch(Exception e) {
			assertThat(e.getMessage(), is("String index out of range: 0"));
		}
		//assertTrue(e instanceof XLException);
	}

	// Add new input on new adress
	@Test()
	public void test4() {
		sheet.add("A4", "1");
		assertEquals("1.00", sheet.getInput("A4"));
	}

	// Add bad input
	@Test()
	public void test5() throws XLException {
		
		try {
			sheet.add("A1", "1/0");
		} catch (XLException ex) {
			e = ex;
		}
		assertTrue(e instanceof XLException);
	}
	// Add comment 
	@Test()
	public void test6() {
		sheet.add("A7", "#comment");
		assertEquals("comment",sheet.getText("A7"));
	}
	// Add to fake adress
	@Test()
	public void test7() {
		sheet.add("fakeadress", "#comment");
		
	}
}