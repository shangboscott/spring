package shangbo.spring.core.example30;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import shangbo.spring.core.example29.MessagePrinter;

public class App {

	public static void main(String[] args) {
		// 实例化 Spring IoC 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("example.xml", MessagePrinter.class);
		
		// 从容器中获得 MessagePrinter 的实例
		MessagePrinter printer1 = context.getBean(MessagePrinter.class);
		printer1.printMessage();
		
		// 再次在容器中获得 MessagePrinter 的实例
		MessagePrinter printer2 = context.getBean(MessagePrinter.class);
		printer2.printMessage();
	}
}
