package shangbo.spring.core.example45;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	// 设置环境变量，通常在 shell 启动脚本中设置
    	System.setProperty("spring.profiles.active", "dev");
    	
		// 实例化 Spring IoC 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("shangbo/spring/example45/example.xml");
		
		// 从容器中获得对象
		SpecialClass specialBean = context.getBean(SpecialClass.class);
				
		// 使用对象
		System.out.println(specialBean.getEnv());
    }
}
