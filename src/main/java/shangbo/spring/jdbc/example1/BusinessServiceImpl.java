package shangbo.spring.jdbc.example1;

import org.springframework.transaction.annotation.Transactional;

public class BusinessServiceImpl implements BusinessService {
	private JobDao jobDao;

	@Transactional
	public void doWork() {
		// Call Function
		// System.out.println(jobDao.queryJobTitleById("IT"));
		// System.out.println(jobDao.queryJob("IT"));

		// Call Function
		// System.out.println(jobDao.queryJobTitleById2("IT"));
		System.out.println(jobDao.queryJob2("IT"));
	}

	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

}
