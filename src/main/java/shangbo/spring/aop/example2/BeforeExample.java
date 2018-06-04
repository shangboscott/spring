package shangbo.spring.aop.example2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BeforeExample {

	@Before("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doAccessCheck() {
		// ...
	}

	@Before("execution(* com.xyz.myapp.dao.*.*(..))")
	public void doAccessCheck2() {
		// ...
	}
	
//	@Before("com.xyz.myapp.SystemArchitecture.dataAccessOperation() && args(account,..)")
//	public void validateAccount(Account account) {
//	    // ...
//	}
//	
//	@Pointcut("com.xyz.myapp.SystemArchitecture.dataAccessOperation() && args(account,..)")
//	private void accountDataAccessOperation(Account account) {}
//
//	@Before("accountDataAccessOperation(account)")
//	public void validateAccount(Account account) {
//	    // ...
//	}

}