package shangbo.spring.core.example46;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	// 设置环境变量，通常在 shell 启动脚本中设置
    	System.setProperty("spring.profiles.active", "uat");
    	
		// 实例化 Spring IoC 容器
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// 从容器中获得对象
		SpecialClass specialBean = context.getBean(SpecialClass.class);
				
		// 使用对象
		System.out.println(specialBean.getEnv());
    }
}
