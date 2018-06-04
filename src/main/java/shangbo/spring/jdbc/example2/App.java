package shangbo.spring.jdbc.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) throws Exception {
		// 实例化 Spring IoC 容器
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// 从容器中获得 BusinessService 的实例
		BusinessService service = context.getBean(BusinessService.class);

		// 业务逻辑
		service.doWork();
	}

}
