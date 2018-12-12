package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import util.NumberAdjustment;

public class NumberAdjustmentPredicate {

	// Case 1
	@Test
	public void testNumberAdjustmentFormat() {
		NumberAdjustment na = new NumberAdjustment(2, 10); // 10 zeros!
		StringBuilder actualBuilder = na.formatPublic(14);
		assertEquals("14.0000000000", actualBuilder.toString());
	}

	// Case 2
	@Test
	public void testNumberAdjustmentFormat2() {
		NumberAdjustment na = new NumberAdjustment(2, -2); //0 zeros! 
		StringBuilder actualBuilder = na.formatPublic(14);
		assertEquals("14", actualBuilder.toString());
	}
}
