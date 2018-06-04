package shangbo.spring.spel.example1;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class App {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		
		// 使用单引号定义字符串
		String strObj = parser.parseExpression("'Hello World'").getValue(String.class);
		System.out.println(strObj);
		
		// 定义整数
		int intObj = parser.parseExpression("1").getValue(Integer.class);
		System.out.println(intObj);
		
		// 定义浮点数
		double doubleObj = parser.parseExpression("1.0").getValue(Double.class);
		System.out.println(doubleObj);
		
		// 定义布尔型
		boolean booleanObj = parser.parseExpression("true").getValue(Boolean.class);
		System.out.println(booleanObj);
		
		// 定义 null
		Object nullValue = parser.parseExpression("null").getValue();
		System.out.println(nullValue);
	}

}
