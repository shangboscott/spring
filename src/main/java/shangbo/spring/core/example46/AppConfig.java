package shangbo.spring.core.example46;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
	
	@Bean
	@Profile("dev")
	public SpecialClass specialBean1() {
		SpecialClass s = new SpecialClass();
		s.setEnv("dev");
		
		return s;
	}
	
	@Bean
	@Profile("uat")
	public SpecialClass specialBean2() {
		SpecialClass s = new SpecialClass();
		s.setEnv("uat");
		
		return s;
	}
	
	@Bean
	@Profile("prod")
	public SpecialClass specialBean3() {
		SpecialClass s = new SpecialClass();
		s.setEnv("prod");
		
		return s;
	}
	
}
