package shangbo.spring.core.example8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	@Scope(value = "prototype")
	public OutPutService outPutService() {
		return new OutPutService();
	}
}
