package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;

import expr.Expr;
import expr.ExprParser;

public class TestExpr {

	ExprParser parser;
	Expr e;
	
	@Before
	public void initialize() {
		parser = new ExprParser();
		e = null;
	}
	@Test
	public void test1() {
		parser= new ExprParser();
		e=null;
		try {
			e=parser.build("1+3");
		}
		 catch (Exception e1) {
				assertThat(e1.getMessage(), is("expecting \")\", found: -1"));
			}
	}
	@Test
	public void test2() {
		parser= new ExprParser();
		e=null;
		try {
			e=parser.build("3-1");
		}
		 catch (Exception e1) {
				assertThat(e1.getMessage(), is("expecting \")\", found: -1"));
			}
	}
	@Test
	public void test3() {
		parser= new ExprParser();
		e=null;
		try {
			e=parser.build("1+3-1");
		}
		 catch (Exception e1) {
				assertThat(e1.getMessage(), is("expecting \")\", found: -1"));
			}
	}

}
