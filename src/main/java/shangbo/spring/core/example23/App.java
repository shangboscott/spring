package shangbo.spring.core.example23;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// 实例化 Spring IoC 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("example.xml", DataService.class);

		// 从容器中获得 Service 对象
		DataService p = context.getBean(DataService.class);

		// 使用对象
		System.out.println(p);
	}
}
