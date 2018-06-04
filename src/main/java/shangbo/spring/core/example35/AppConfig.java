package shangbo.spring.core.example35;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	@Bean
	public MessageService dbMessageService() {
		return new MessageServiceDBImpl();
	}
	
	// 申明 bean 为 primary
	@Bean
	@Primary
	public MessageService fileMessageService() {
		return new MessageServiceDBImpl();
	}
	
	@Bean
	public MessagePrinter messagePrinter() {
		return new MessagePrinter();
	}
}
