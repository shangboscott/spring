package shangbo.spring.aop.example2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;

@Aspect
public class AfterFinallyExample {

	@After("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doReleaseLock() {
		// ...
	}

}
