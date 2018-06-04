package shangbo.spring.core.example18;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// @Import 导入一个配置类
@Configuration
@Import(value = AppConfig2.class)
public class AppConfig1 {

	@Bean
	public OutPutService outPutService() {
		return new OutPutService();
	}
}
