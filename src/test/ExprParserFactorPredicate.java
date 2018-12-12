package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;


import expr.Expr;
import expr.ExprParser;

class ExprParserPredicate {
	ExprParser parser;
	Expr e;
	
	//Decision 2,  True
	@Test
	void testFactor1() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("(1+1)");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		assertEquals("1.00+1.00",e.toString());
	}
	
	//Decision 2,  False. Decision 4, False
	@Test
	void testFactor2() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("1+1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		assertEquals("1.00+1.00",e.toString());
	}
	
	//Decision 4,  True
	@Test
	void testFactor3() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("(1+1");
		} catch (Exception e1) {
			assertThat(e1.getMessage(), is("expecting \")\", found: -1"));		}
	}
	
	//Decision 7,  True
	@Test
	void testFactor4() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		assertEquals("1.00",e.toString());
	}
	
	//Decision 7, False. D9, True. D11, True.
	@Test
	void testFactor5() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("A");
		} catch (Exception e1) {
			assertThat(e1.getMessage(), is("illegal address: A"));	
		}
	}
	
	//D9, False. D14, False. D16, True
	@Test
	void testFactor6() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("+");
		} catch (Exception e1) {
			assertThat(e1.getMessage(), is("unexpected +"));	
		}
	}
	
	//D11, False
	@Test
	void testFactor7() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("A1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		assertEquals("A1",e.toString());
	}
	
	//D14, True
	@Test
	void testFactor8() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("");
		} catch (Exception e1) {
			assertThat(e1.getMessage(), is("unexpected end of text"));	
		}
	}
	
	
}
