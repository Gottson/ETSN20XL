package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import util.NumberAdjustment;

public class NumberAdjustmentRightPredicate {

	@Test
	public void testRight1() {
		NumberAdjustment na = new NumberAdjustment(1,1,1);
		assertEquals("-1.0E0", na.right(-1.00));
	}
	
	@Test
	public void testRight2() {
		NumberAdjustment na = new NumberAdjustment(1,1,1);
		assertEquals("0.0E0", na.right(0.00));
	}
	
	@Test
	public void testRight3() {
		NumberAdjustment na = new NumberAdjustment(1,1,1);
		assertEquals("1.0E1", na.right(10.00));
	}
	
	@Test
	public void testRight4() {
		NumberAdjustment na = new NumberAdjustment(1,1,0);
		assertEquals("1.0", na.right(1.00));
	}

}
