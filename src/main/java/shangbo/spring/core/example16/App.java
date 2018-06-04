package shangbo.spring.core.example16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// 实例化 Spring IoC 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("example1.xml", InPutService.class);

		// 从容器中获得 Service 对象，传统方式是自己 new 对象
		InPutService input = context.getBean(InPutService.class);
		OutPutService printer = context.getBean(OutPutService.class);

		// 使用对象
		printer.outPut(input.getMessage());
	}
}
