package expr;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Slot;
import util.XLException;


public class TestEnvironment implements Environment {

	Map<String, String> map;

	public TestEnvironment() {

		map = new HashMap<String, String>();

		map.put("A1", "4");
		map.put("A2", "9");
		map.put("B1", "A1+A2");
		map.put("B2", "#hejhej");

	}

	public double value(String name) {
		
		
		String input = map.get(name);
			
			ExprParser parser = new ExprParser();
			try {
				Expr expr = parser.build(input);
				return expr.value(this);
			} catch (IOException e) {
			//	System.err.println(e.getMessage());
			}
		throw new XLException("Not an exprection");

	}
}
