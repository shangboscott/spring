package shangbo.spring.spel.example4;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class App {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();

		// 关系操作符
		System.out.println(parser.parseExpression("1 == 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 != 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 > 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 >= 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 < 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 <= 1").getValue(Boolean.class));
		
		// 为了在 XML 中是使用方便，也可以使用如下方式
		System.out.println(parser.parseExpression("1 eq 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 ne 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 gt 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 ge 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 lt 1").getValue(Boolean.class));
		System.out.println(parser.parseExpression("1 le 1").getValue(Boolean.class));
		
		// 逻辑操作符
		System.out.println(parser.parseExpression("true and false").getValue(Boolean.class));
		System.out.println(parser.parseExpression("true or false").getValue(Boolean.class));
		System.out.println(parser.parseExpression("!true").getValue(Boolean.class));
		
		// 数学运算符
		System.out.println(parser.parseExpression("1 + 1").getValue(Integer.class));
		System.out.println(parser.parseExpression("1 - 1").getValue(Integer.class));
		System.out.println(parser.parseExpression("1 * 1").getValue(Integer.class));
		System.out.println(parser.parseExpression("1 / 1").getValue(Integer.class));
		System.out.println(parser.parseExpression("1 % 1").getValue(Integer.class));
		
		// instanceof 操作符
		// T() 表示一个类, 非 java.lang 包下的类需要包名
		System.out.println(parser.parseExpression("'xyz' instanceof T(Integer)").getValue(Boolean.class));
		
		// matches操作符， 匹配正则表达式
		System.out.println(parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class));
		
		// If-Then-Else
		String falseString = parser.parseExpression("false ? 'trueExp' : 'falseExp'").getValue(String.class);
		System.out.println(falseString);
	}

}
