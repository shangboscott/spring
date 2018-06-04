package shangbo.spring.core.example40;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// 实例化 Spring IoC 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("example.xml", Person.class);

		// 从容器中获得 Person 对象
		Person p = context.getBean(Person.class);

		// 使用对象
		System.out.println(p);
	}
}
