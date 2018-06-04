package shangbo.spring.core.example11;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OutPutService {

	// 初始化方法
//	@PostConstruct
	public void init() {
		System.out.println("Enter init");
	}

	// 销毁方法
//	@PreDestroy
	public void destroy() {
		System.out.println("Enter destroy");
	}

	public void outPut() {
		System.out.println("Hello World");
	}

}
