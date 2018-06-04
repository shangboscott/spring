package shangbo.spring.jdbc.example1;

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

	List<Job> queryAllJob();

	//
	// Delete
	//
	int deleteJobById(String jobId);

	//
	// Call Stored Procedure
	//
	String queryJobTitleById2(String jobId);

	Job queryJob2(String jobId);

	//
	// Call Function
	//
	String queryJobTitleById(String jobId);

	Job queryJob(String jobId);

	//
	// Setter
	//
	void setDataSource(DataSource dataSource);
}
