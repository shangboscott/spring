package shangbo.spring.core.example33;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
		// 实例化 Spring IoC 容器，也可以一次读取多个Java配置文件
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// 从容器中获得 MessagePrinter 的实例
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		
		// 使用对象
		printer.printMessage();
    }
}
