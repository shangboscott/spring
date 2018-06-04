package shangbo.spring.core.example43;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	// 设置环境变量，通常在 shell 启动脚本中设置
    	// -Denv=dev
    	System.setProperty("env", "dev");
    	
		// 实例化 Spring IoC 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("shangbo/spring/example43/example.xml");
		
		// 从容器中获得对象
		BasicDataSource dataSource = context.getBean(BasicDataSource.class);
				
		// 使用对象
		System.out.println(dataSource.getUrl());
    }
}
