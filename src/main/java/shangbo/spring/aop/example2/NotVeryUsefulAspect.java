package shangbo.spring.aop.example2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NotVeryUsefulAspect {

	@Pointcut("execution(* transfer(..))")// the pointcut expression
	private void anyOldTransfer() {}// the pointcut signature
	
	@Pointcut("execution(public * *(..))")
	private void anyPublicOperation() {}

	@Pointcut("within(com.xyz.someapp.trading..*)")
	private void inTrading() {}

	@Pointcut("anyPublicOperation() && inTrading()")
	private void tradingOperation() {}
	
	// execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
	
	// the execution of any public method
	// execution(public * *(..))
	
	// the execution of any method with a name beginning with "set"
	// execution(* set*(..))
	
	// the execution of any method defined by the AccountService interface
	// execution(* com.xyz.service.AccountService.*(..))
	
	// the execution of any method defined in the service package
	// execution(* com.xyz.service.*.*(..))
	
	// the execution of any method defined in the service package or a sub-package:
	// execution(* com.xyz.service..*.*(..))
	
	// any join point (method execution only in Spring AOP) within the service package
	// within(com.xyz.service.*)
	
	// any join point (method execution only in Spring AOP) within the service package or a sub-package:
	// within(com.xyz.service..*)
	
	// any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:
	// this(com.xyz.service.AccountService)
	
	// any join point (method execution only in Spring AOP) where the target object implements the AccountService interface:
	// target(com.xyz.service.AccountService)
	
	// any join point (method execution only in Spring AOP) which takes a single parameter, and where the argument passed at runtime is Serializable:
	// args(java.io.Serializable)
	
	// any join point (method execution only in Spring AOP) where the target object has an @Transactional annotation:
	// @target(org.springframework.transaction.annotation.Transactional)
	
	// any join point (method execution only in Spring AOP) where the declared type of the target object has an @Transactional annotation:
	// @within(org.springframework.transaction.annotation.Transactional)
	
	// any join point (method execution only in Spring AOP) where the executing method has an @Transactional annotation:
	// @annotation(org.springframework.transaction.annotation.Transactional)
	
	// any join point (method execution only in Spring AOP) which takes a single parameter, and where the runtime type of the argument passed has the @Classified annotation:
	// @args(com.xyz.security.Classified)
	
	// any join point (method execution only in Spring AOP) on a Spring bean named tradeService:
	// bean(tradeService)
	
	// any join point (method execution only in Spring AOP) on Spring beans having names that match the wildcard expression *Service:
	// bean(*Service)
}
