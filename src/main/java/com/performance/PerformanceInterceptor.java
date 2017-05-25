package main.java.com.performance;

import main.java.com.framework.service.LogService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by george on 2017/5/25.
 */
@Component
public class PerformanceInterceptor implements MethodInterceptor {
    private LogService logService;

    @Autowired
    public PerformanceInterceptor(LogService logService) {
        this.logService = logService;
        logService.setType(PerformanceInterceptor.class);
    }

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        final StopWatch stopWatch = new StopWatch(methodInvocation.getMethod().toGenericString());
        stopWatch.start("invocation.proceed()");
        Object result;
        try {
            result = methodInvocation.proceed();
            return result;
        } finally {
            stopWatch.stop();
            logService.debug(stopWatch.prettyPrint());
        }
    }
}
