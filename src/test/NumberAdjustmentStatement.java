package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import util.NumberAdjustment;

public class NumberAdjustmentStatement {

	//Case 1 
	@Test
	public void testNumberAdjustmentFormat() {
		NumberAdjustment na = new NumberAdjustment(2, 10);
		StringBuilder actualBuilder = na.formatPublic(14);
		assertEquals("14.0000000000", actualBuilder.toString());
	}

}
