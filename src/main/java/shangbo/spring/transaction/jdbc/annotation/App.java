package shangbo.spring.transaction.jdbc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) throws Exception {
		// 实例化 Spring IoC 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("example.xml", BusinessService.class);

		// 从容器中获得 BusinessService 的实例
		BusinessService service = context.getBean(BusinessService.class);

		// 使用 BusinessService
		// 插入 job
		Job job = newJob();
		// service.insertJob(job);

		// 更新 job
		service.updateJob(job);

		// 查询 job
		System.out.println(service.getJob("IT"));
	}

	private static Job newJob() {
		Job job = new Job();
		job.setJobId("IT");
		job.setJobTitle("IT Engineer");
		job.setMinSalary(2);
		job.setMaxSalary(100000);

		return job;
	}
}
