package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import expr.Expr;
import expr.ExprParser;
import util.XLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ExprParserStatement {
	ExprParser parser;
	Expr e;
	
	@Before
	public void initialize() {
		parser = new ExprParser();
		e = null;
	}

	@Test
	void testFactor1() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("1+1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		assertEquals("1.00+1.00",e.toString());
	}
	
	@Test
	void testFactor2() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("(1+1");
		} catch (Exception e1) {
			assertThat(e1.getMessage(), is("expecting \")\", found: -1"));
		}
	}
	
	@Test
	void testFactor3() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		assertEquals("1.00",e.toString());
	}
	
	@Test
	void testFactor4() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("XXX*123");
		} catch (Exception e1) {
			assertThat(e1.getMessage(), is("illegal address: XXX"));
		}
	}
	
	@Test
	void testFactor5() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("(C1*123)");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		assertEquals("C1*123.00",e.toString());
	}
	
	@Test
	void testFactor6() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("");
		} catch (Exception e1) {
			assertThat(e1.getMessage(), is("unexpected end of text"));
		}
	}
	//Not entirely sure what the input should be here
	@Test
	void testFactor7() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("*");
		} catch (Exception e1) {
			assertThat(e1.getMessage(), is("unexpected *"));
		}
	}

}
