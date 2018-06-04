package shangbo.spring.core.example11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Bean
	public OutPutService outPutService() {
		return new OutPutService();
	}
}
