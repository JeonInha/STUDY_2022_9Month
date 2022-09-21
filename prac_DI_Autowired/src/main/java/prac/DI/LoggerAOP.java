package prac.DI;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAOP {

	@Pointcut("execution(boolean prac.DI.*.*(..))")
	public void publicTarget() {
	}

	Object result;
	private static final Logger LOG = LoggerFactory.getLogger(LoggerAOP.class);

	@Around("publicTarget()")
	public Object loginWithLog(ProceedingJoinPoint joinPoint) throws Throwable {

		String name = joinPoint.getSignature().getName();
		LOG.info("logLog: " + name + " 동작 시도");

		try {

			result = joinPoint.proceed();
			System.out.println("결과: " + result);
			return result;

		} finally {
			if (result instanceof Boolean) {
				LOG.info("logLog: 동작 성공");
			} else {
				LOG.info("logLog: 동작 실패");
			}
		}
	}
}
