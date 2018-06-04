package shangbo.spring.jdbc.example2;

import java.util.ArrayList;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {
	private JobDao jobDao;

	public void doWork() {
		List<String> jobIds = new ArrayList<String>();
		jobIds.add("IT");
		jobIds.add("AD_PRES");
		
		List<Job> jobs = jobDao.queryJobByIds(jobIds);
		for(Job job: jobs) {
			System.out.println(job);
		}
	}

	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

}
