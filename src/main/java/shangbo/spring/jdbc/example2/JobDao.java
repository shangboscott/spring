package shangbo.spring.jdbc.example2;

import java.util.List;

import javax.sql.DataSource;

public interface JobDao {
	//
	// DDL
	//
	void createTableJobs();

	//
	// Insert
	//
	int insertJob(Job job);
	int[] insertJob(List<Job> jobs);

	//
	// Update
	//
	int updateJob(Job job);

	//
	// Query
	//
	Job queryJobById(String jobId);
	List<Job> queryJobByIds(List<String> jobIds);
	List<Job> queryAllJob();

	//
	// Delete
	//
	int deleteJobById(String jobId);

	//
	// Call Stored Procedure
	//
	// this.jdbcTemplate.update("call SUPPORT.REFRESH_ACTORS_SUMMARY(?)", Long.valueOf(unionId));

	//
	// Call Function
	//

	//
	// Setter
	//
	void setDataSource(DataSource dataSource);
}
