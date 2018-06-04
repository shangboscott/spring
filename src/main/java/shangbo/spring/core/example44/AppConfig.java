package shangbo.spring.core.example44;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:shangbo/spring/example44/system.${env}.properties")
public class AppConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource(
			@Value("${jdbc.driverClassName}") String driverClassName,
			@Value("${jdbc.url}") String url,
			@Value("${jdbc.username}") String username,
			@Value("${jdbc.password}") String password) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
}
