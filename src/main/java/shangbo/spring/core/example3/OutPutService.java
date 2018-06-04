package shangbo.spring.core.example3;

import org.springframework.stereotype.Component;

// @Component 标识的类可以被 Spring 自动管理
// @Service 标识的类也可以被 Spring 自动管理
// @Controller 标识的类也可以被 Spring 自动管理
// @Repository 标识的类也可以被 Spring 自动管理
@Component
public class OutPutService {

	public void outPut() {
		System.out.println("Hello World");
	}

}
