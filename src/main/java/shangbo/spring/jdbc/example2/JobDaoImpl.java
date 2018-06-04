package shangbo.spring.jdbc.example2;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JobDaoImpl implements JobDao {
	private NamedParameterJdbcTemplate jdbcTemplate;

	//
	// DDL
	//
	@Transactional
	public void createTableJobs() {
		String sql = "create table jobs (job_id varchar2(10), job_title varchar2(35), min_salary number(6,0), max_salary number(6,0))";
		jdbcTemplate.getJdbcOperations().execute(sql);
	}

	//
	// Insert
	//
	@Transactional
	public int insertJob(Job job) {
		String sql = "insert into jobs values (:jobId, :jobTitle, :minSalary, :maxSalary)";
		return jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(job));
	}
	
	@Transactional
	public int[] insertJob(List<Job> jobs) {
		String sql = "insert into jobs values (:jobId, :jobTitle, :minSalary, :maxSalary)";
		
		// 批量插入
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(jobs.toArray());
		return jdbcTemplate.batchUpdate(sql, batch);
	}

	//
	// Update
	//
	@Transactional
	public int updateJob(Job job) {
		String sql = "update jobs set job_title=:jobTitle, min_salary=:minSalary, max_salary=:maxSalary where job_id = :jobId";
		return jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(job));
	}

	//
	// Query
	//
	@Transactional(readOnly = true)
	public Job queryJobById(String jobId) {
		String sql = "select * from jobs where job_id = :jobId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("jobId", jobId);
		return jdbcTemplate.queryForObject(sql, namedParameters, new BeanPropertyRowMapper<Job>(Job.class));
	}
	
	@Transactional(readOnly = true)
	public List<Job> queryJobByIds(List<String> jobIds) {
		String sql = "select * from jobs where job_id in (:jobIds)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("jobIds", jobIds);
		return jdbcTemplate.query(sql, namedParameters, new BeanPropertyRowMapper<Job>(Job.class));
	}

	@Transactional(readOnly = true)
	public List<Job> queryAllJob() {
		String sql = "select * from jobs";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Job>(Job.class));
	}

	//
	// Delete
	//
	@Transactional
	public int deleteJobById(String jobId) {
		String sql = "delete from jobs where job_id = :jobId";
		Map<String, String> namedParameters = Collections.singletonMap("jobId", jobId);
		return jdbcTemplate.update(sql, namedParameters);
	}

	//
	// Setter
	//
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
}
