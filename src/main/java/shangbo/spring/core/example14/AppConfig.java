package shangbo.spring.core.example14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

	@Bean
	@Lazy(value = true)
	public OutPutService outPutService() {
		return new OutPutService();
	}
}
