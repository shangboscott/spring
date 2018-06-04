package shangbo.spring.core.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration 用来标识该类是一个 Java 配置元数据
@Configuration
public class AppConfig {

	// @Bean 用来标识该对象需要 Spring 帮我们管理
	@Bean
	public OutPutService outPutService() {
		return new OutPutService();
	}
}
