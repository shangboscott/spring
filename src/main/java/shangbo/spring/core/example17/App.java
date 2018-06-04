package shangbo.spring.core.example17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		// 实例化 Spring IoC 容器，一次读取多个Java配置文件
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class, AppConfig2.class);

		// 从容器中获得 Service 对象，传统方式是自己 new 对象
		InPutService input = context.getBean(InPutService.class);
		OutPutService printer = context.getBean(OutPutService.class);

		// 使用对象
		printer.outPut(input.getMessage());
	}
}
