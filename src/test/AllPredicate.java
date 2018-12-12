package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExprParserFactorPredicate.class, ExprParserTermPredicate.class, NumberAdjustmentPredicate.class,
		XLsheetPredicate.class })
public class AllPredicate {

}
