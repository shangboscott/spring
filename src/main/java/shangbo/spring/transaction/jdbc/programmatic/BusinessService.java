package shangbo.spring.transaction.jdbc.programmatic;

import javax.sql.DataSource;

import org.springframework.transaction.PlatformTransactionManager;

public interface BusinessService {
	Job getJob(String jobId);

	void insertJob(Job job);

	void updateJob(Job job);

	void setDataSource(DataSource dataSource);

	void setTransactionManager(PlatformTransactionManager transactionManager);
}
