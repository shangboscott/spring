package shangbo.spring.core.example9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// 实例化 Spring IoC 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("example.xml", OutPutService.class);

		// 从容器中获得 OutPutService 对象
		OutPutService printer = context.getBean(OutPutService.class);

		// 使用对象
		printer.outPut();
	}
}
