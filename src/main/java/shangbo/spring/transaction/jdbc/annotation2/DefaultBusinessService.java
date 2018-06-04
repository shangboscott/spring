package shangbo.spring.transaction.jdbc.annotation2;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

public class DefaultBusinessService implements BusinessService {
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public Job getJob(String jobId) {
		String sql = "SELECT * FROM HR.JOBS WHERE JOB_ID = ?";
		return jdbcTemplate.queryForObject(sql, new JobRowMapper(), jobId);
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateJob(Job job) throws Exception {
		String sql = "UPDATE HR.JOBS SET JOB_TITLE=?, MIN_SALARY = ?, MAX_SALARY = ? WHERE JOB_ID = ?";
		jdbcTemplate.update(sql, job.getJobTitle(), job.getMinSalary(), job.getMaxSalary(), job.getJobId());

		// 测试回滚
		// throw new Exception("test");
	}

	@Transactional(rollbackFor = Exception.class)
	public void insertJob(Job job) throws Exception {
		String sql = "INSERT INTO HR.JOBS VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, job.getJobId(), job.getJobTitle(), job.getMinSalary(), job.getMaxSalary());

		// 测试回滚
		// throw new Exception("test");
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static class JobRowMapper implements RowMapper<Job> {
		public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
			Job job = new Job();
			job.setJobId(rs.getString(1));
			job.setJobTitle(rs.getString(2));
			job.setMinSalary(rs.getInt(3));
			job.setMaxSalary(rs.getInt(4));

			return job;
		}
	}

}
