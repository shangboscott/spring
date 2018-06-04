package shangbo.spring.core.example17;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

	@Bean
	public OutPutService outPutService() {
		return new OutPutService();
	}
}
