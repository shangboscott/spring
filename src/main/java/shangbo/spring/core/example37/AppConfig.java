package shangbo.spring.core.example37;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	@Qualifier("DB")
	public MessageService dbMessageService() {
		return new MessageServiceDBImpl();
	}
	
	@Bean
	@Qualifier("FILE")
	public MessageService fileMessageService() {
		return new MessageServiceDBImpl();
	}
	
	@Bean
	public MessagePrinter messagePrinter() {
		return new MessagePrinter();
	}
}
