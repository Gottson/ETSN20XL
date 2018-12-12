package test;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.IOException;

import org.junit.Before;
//import org.junit.jupiter.api.Test;

import expr.Expr;
import expr.ExprParser;
import util.XLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExprParserTermStatement {
	ExprParser parser;
	Expr e;
	
	@Before
	public void initialize() {
		parser = new ExprParser();
		e = null;
	}

	@Test
	public void testTerm1() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("1*1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		assertEquals("1.00*1.00",e.toString());
	}
	
	@Test
	public void testTerm2() {
	parser = new ExprParser();
		e = null;
		try {
			e = parser.build("1+1");
		} catch (Exception e1) {
			//assertThat(e1.getMessage(), is("expecting \")\", found: -1"));
		}
		assertEquals("1.00+1.00",e.toString());
	}
	
	@Test
	public void testFactor3() {
		parser = new ExprParser();
		e = null;
		try {
			e = parser.build("1/1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		assertEquals("1.00/1.00",e.toString());
	}
	
	

}
