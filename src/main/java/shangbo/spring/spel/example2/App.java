package shangbo.spring.spel.example2;

import java.util.List;
import java.util.Map;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class App {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		
		// 定义数组
		Integer[] intArray = (Integer[]) parser.parseExpression("new Integer[] {1, 2, 3, 4}").getValue();
		System.out.println(intArray);
		
		// 定义 List
		List listObj = parser.parseExpression("{1,2,3,4}").getValue(List.class);
		System.out.println(listObj);
		
		// 定义 Map
		Map mapObj = parser.parseExpression("{'zhangsan':28,'lsi':30}").getValue(Map.class);
		System.out.println(mapObj);
		
		// 访问对象属性, #this 代表当前对象, #root 代表根对象
		Integer arrayLen = parser.parseExpression("#this.length").getValue(intArray, Integer.class);
		System.out.println(arrayLen);
		
		// 根据 index 访问 list 元素
		int num = parser.parseExpression("#this[3]").getValue(listObj, Integer.class);
		System.out.println(num);
		
		// .?[selectionExpression] 过滤 list
		List subListObj = (List) parser.parseExpression("#this.?[#this < 3]").getValue(listObj);
		System.out.println(subListObj);
		
		// 根据 key 访问 map
		int age = parser.parseExpression("#this['zhangsan']").getValue(mapObj, Integer.class);
		System.out.println(age);
	}

}
