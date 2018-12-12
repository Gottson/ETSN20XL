package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExprParserFactorPredicate.class, ExprParserTermPredicate.class, NumberAdjustmentFactorPredicate.class,
		NumberAdjustmentFillZeroPredicate.class, NumberAdjustmentRightPredicate.class, XLsheetAddPredicate.class })
public class AllPredicate {

}
