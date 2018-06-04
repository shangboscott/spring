package shangbo.spring.core.example18;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

	@Bean
	public InPutService inPutService() {
		return new InPutService();
	}
}
