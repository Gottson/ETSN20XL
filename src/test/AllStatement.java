package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExprParserFactorStatement.class, ExprParserTermStatement.class, NumberAdjustmentStatement.class })
public class AllStatement {

}
