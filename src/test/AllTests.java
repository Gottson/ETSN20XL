package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExprParserFactorPredicate.class, ExprParserFactorStatement.class, ExprParserTermPredicate.class,
		ExprParserTermStatement.class, NumberAdjustmentPredicate.class, NumberAdjustmentStatement.class,
		XLsheetPredicate.class })
public class AllTests {

}
