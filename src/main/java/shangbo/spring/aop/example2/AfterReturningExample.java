package shangbo.spring.aop.example2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
public class AfterReturningExample {

	@AfterReturning("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doAccessCheck() {
		// ...
	}

	@AfterReturning(pointcut = "com.xyz.myapp.SystemArchitecture.dataAccessOperation()", returning = "retVal")
	public void doAccessCheck(Object retVal) {
		// ...
	}

}