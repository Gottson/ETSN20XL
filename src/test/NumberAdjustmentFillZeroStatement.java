package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import util.NumberAdjustment;

public class NumberAdjustmentFillZeroStatement {

	@Test
	public void testFillZero1() {
		NumberAdjustment na = new NumberAdjustment(1,1,5);
		assertEquals("-0001", na.publicFillZero(-1).toString());
	}

}
