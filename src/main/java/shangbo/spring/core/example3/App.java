package shangbo.spring.core.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// 实例化 Spring IoC 容器，也可以一次读取多个配置文件
		// ApplicationContext 有很多子类，可以根据你的需求选择
		ApplicationContext context = new ClassPathXmlApplicationContext("example.xml", OutPutService.class);

		// 从容器中获得 Service 对象，传统方式是自己 new 对象
		OutPutService printer = context.getBean(OutPutService.class);

		// 使用对象
		printer.outPut();
	}
}
