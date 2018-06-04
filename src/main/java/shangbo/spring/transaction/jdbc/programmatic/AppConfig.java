package shangbo.spring.transaction.jdbc.programmatic;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // 开启事务管理
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("hr");
		dataSource.setPassword("123456");

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource);

		return txManager;
	}

	@Bean
	public BusinessService businessService(DataSource dataSource, PlatformTransactionManager transactionManager) {
		BusinessService businessService = new DefaultBusinessService();
		businessService.setDataSource(dataSource);
		businessService.setTransactionManager(transactionManager);

		return businessService;
	}

}
