package shangbo.spring.jdbc.example1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;

@Repository
public class JobDaoImpl implements JobDao {
	private JdbcTemplate jdbcTemplate;

	//
	// DDL
	//
	public void createTableJobs() {
		String sql = "create table jobs (job_id varchar2(10), job_title varchar2(35), min_salary number(6,0), max_salary number(6,0))";
		jdbcTemplate.execute(sql);
	}

	//
	// Insert
	//
	public int insertJob(Job job) {
		String sql = "insert into jobs values (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, job.getJobId(), job.getJobTitle(), job.getMinSalary(), job.getMaxSalary());
	}

	public int insertJob2(final Job job) {
		final String sql = "insert into jobs values (job_seq.nextval, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder(); // 返回生成的 key
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "job_id" });
				ps.setString(1, job.getJobTitle());
				ps.setInt(2, job.getMinSalary());
				ps.setInt(3, job.getMaxSalary());
				return ps;
			}
		}, keyHolder);
		return jdbcTemplate.update(sql, job.getJobId(), job.getJobTitle(), job.getMinSalary(), job.getMaxSalary());
	}

	public int[] insertJob(final List<Job> jobs) {
		String sql = "insert into jobs values (?, ?, ?, ?)";

		// 批量插入
		return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, jobs.get(i).getJobId());
				ps.setString(2, jobs.get(i).getJobTitle());
				ps.setInt(3, jobs.get(i).getMinSalary());
				ps.setInt(4, jobs.get(i).getMaxSalary());
			}

			public int getBatchSize() {
				return jobs.size();
			}
		});
	}

	public int[][] insertJob2(final List<Job> jobs) {
		String sql = "insert into jobs values (?, ?, ?, ?)";

		// 批量插入,每批次 100
		return jdbcTemplate.batchUpdate(sql, jobs, 100, new ParameterizedPreparedStatementSetter<Job>() {
			public void setValues(PreparedStatement ps, Job argument) throws SQLException {
				ps.setString(1, argument.getJobId());
				ps.setString(2, argument.getJobTitle());
				ps.setInt(3, argument.getMinSalary());
				ps.setInt(4, argument.getMaxSalary());
			}
		});
	}

	//
	// Update
	//
	public int updateJob(Job job) {
		String sql = "update jobs set job_title=?, min_salary=?, max_salary=? where job_id = ?";
		return jdbcTemplate.update(sql, job.getJobTitle(), job.getMinSalary(), job.getMaxSalary(), job.getJobId());
	}

	//
	// Query
	//
	public Job queryJobById(String jobId) {
		String sql = "select * from jobs where job_id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Job>(Job.class), jobId);
	}

	public List<Job> queryAllJob() {
		String sql = "select * from jobs";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Job>(Job.class));
	}

	//
	// Delete
	//
	public int deleteJobById(String jobId) {
		String sql = "delete from jobs where job_id = ?)";
		return jdbcTemplate.update(sql, jobId);
	}

	//
	// Call Stored Procedure
	//
	public String queryJobTitleById2(final String jobId) {
		List<SqlParameter> declaredParameters = new ArrayList<SqlParameter>();
		declaredParameters.add(new SqlParameter("job_id", Types.VARCHAR));
		declaredParameters.add(new SqlOutParameter("job_title", Types.VARCHAR));

		//
		Map<String, Object> r = jdbcTemplate.call(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				String sql = "{call query_job_title_by_id2(?,?)}";
				CallableStatement statement = con.prepareCall(sql);
				statement.setString(1, jobId);
				statement.registerOutParameter(2, Types.VARCHAR);
				return statement;
			}
		}, declaredParameters);

		return r.get("job_title").toString();
	}

	public Job queryJob2(final String jobId) {
		List<SqlParameter> declaredParameters = new ArrayList<SqlParameter>();
		declaredParameters.add(new SqlParameter("job_id", Types.VARCHAR));
		declaredParameters.add(new SqlOutParameter("job", OracleTypes.CURSOR, new BeanPropertyRowMapper<Job>(Job.class)));

		//
		Map<String, Object> r = jdbcTemplate.call(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				String sql = "{call query_job2(?,?)}";
				CallableStatement statement = con.prepareCall(sql);
				statement.setString(1, jobId);
				statement.registerOutParameter(2, OracleTypes.CURSOR);
				return statement;
			}
		}, declaredParameters);

		return ((List<Job>) r.get("job")).get(0);
	}

	//
	// Call Function
	//
	public String queryJobTitleById(final String jobId) {
		List<SqlParameter> declaredParameters = new ArrayList<SqlParameter>();
		declaredParameters.add(new SqlOutParameter("job_title", Types.VARCHAR));

		//
		Map<String, Object> r = jdbcTemplate.call(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				String sql = "{call ? = query_job_title_by_id(?)}";
				CallableStatement statement = con.prepareCall(sql);
				statement.registerOutParameter(1, Types.VARCHAR);
				statement.setString(2, jobId);
				return statement;
			}
		}, declaredParameters);

		return r.get("job_title").toString();
	}

	public Job queryJob(final String jobId) {
		List<SqlParameter> declaredParameters = new ArrayList<SqlParameter>();
		declaredParameters.add(new SqlOutParameter("job", OracleTypes.CURSOR, new BeanPropertyRowMapper<Job>(Job.class)));

		//
		Map<String, Object> r = jdbcTemplate.call(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				String sql = "{call ? = query_job(?)}";
				CallableStatement statement = con.prepareCall(sql);
				statement.registerOutParameter(1, OracleTypes.CURSOR);
				statement.setString(2, jobId);
				return statement;
			}
		}, declaredParameters);

		return ((List<Job>) r.get("job")).get(0);
	}

	//
	// Setter
	//
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
