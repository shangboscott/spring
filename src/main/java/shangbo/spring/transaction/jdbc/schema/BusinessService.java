package shangbo.spring.transaction.jdbc.schema;

import javax.sql.DataSource;

public interface BusinessService {
	Job getJob(String jobId);

	void insertJob(Job job) throws Exception;

	void updateJob(Job job) throws Exception;

	void setDataSource(DataSource dataSource);
}
