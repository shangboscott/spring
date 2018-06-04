package shangbo.spring.aop.example2;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingExample {

	@AfterThrowing("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doRecoveryActions() {
		// ...
	}

//	@AfterThrowing(pointcut = "com.xyz.myapp.SystemArchitecture.dataAccessOperation()", throwing = "ex")
//	public void doRecoveryActions(DataAccessException ex) {
//		// ...
//	}

}