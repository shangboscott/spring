package shangbo.spring.spel.example3;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import shangbo.spring.spel.Inventor;
import shangbo.spring.spel.StringUtils;

public class App {

	public static void main(String[] args) throws Exception {
		ExpressionParser parser = new SpelExpressionParser();
		
		// 通过构造函数初始化对象
		String helloWorld = parser.parseExpression("new String('hello world')").getValue(String.class);
		System.out.println(helloWorld);

		// 调用方法
		String c = parser.parseExpression("substring(2, 3)").getValue(helloWorld, String.class);
		System.out.println(c);
		
		// 调用静态方法
		double r = parser.parseExpression("T(java.lang.Math).random()").getValue(Double.class);
		System.out.println(r);
		
		// 定义对象
		Inventor inventor = parser.parseExpression("new shangbo.spring.spel.Inventor()").getValue(Inventor.class);
		
		// 赋值方式 1
		parser.parseExpression("name").setValue(inventor, "Shangbo");
		System.out.println(inventor.getName());
		
		// 注册变量
		StandardEvaluationContext context = new StandardEvaluationContext(inventor);
		context.setVariable("newName", "Scott");
		
		// 赋值方式 2, #newName 引用新变量
		parser.parseExpression("Name = #newName").getValue(context);
		System.out.println(inventor.getName());
		
		// 注册方法
		context.registerFunction("reverseString", StringUtils.class.getDeclaredMethod("reverseString", new Class[] { String.class }));

		// 调用注册方法
		String helloWorldReversed = parser.parseExpression("#reverseString('hello')").getValue(context, String.class);
		System.out.println(helloWorldReversed);
	}

}
