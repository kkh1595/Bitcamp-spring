package sample04_Advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Around -> 입실체크");
		long start = System.currentTimeMillis();
		Object ob = invocation.proceed();
		long end = System.currentTimeMillis(); 
		System.out.println("소요시간 : " + (end-start)/1000+"초");
		System.out.println("Around -> 퇴실체크");
		return ob;
	}
		
}
