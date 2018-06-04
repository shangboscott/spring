package shangbo.spring.transaction.jdbc.programmatic;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class DefaultBusinessService implements BusinessService {
	private TransactionTemplate transactionTemplate;
	private JdbcTemplate jdbcTemplate;

	public Job getJob(String jobId) {
		String sql = "SELECT * FROM HR.JOBS WHERE JOB_ID = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Job>(Job.class), jobId);
	}

	public void updateJob(final Job job) {
		final String sql = "UPDATE HR.JOBS SET JOB_TITLE=?, MIN_SALARY = ?, MAX_SALARY = ? WHERE JOB_ID = ?";

		// 手动控制事务，没有返回值使用 TransactionCallbackWithoutResult
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				jdbcTemplate.update(sql, job.getJobTitle(), job.getMinSalary(), job.getMaxSalary(), job.getJobId());
			}
		});
	}

	public void insertJob(final Job job) {
		final String sql = "INSERT INTO HR.JOBS VALUES (?, ?, ?, ?)";

		// 手动控制事务，有返回值使用 TransactionCallback
		transactionTemplate.execute(new TransactionCallback<Integer>() {
			public Integer doInTransaction(TransactionStatus status) {
				return jdbcTemplate.update(sql, job.getJobId(), job.getJobTitle(), job.getMinSalary(), job.getMaxSalary());
			}
		});
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionTemplate = new TransactionTemplate(transactionManager);
	}

}
