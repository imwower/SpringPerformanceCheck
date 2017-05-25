package main.java.com.performance;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by george on 2017/5/25.
 */
@Component
public class PerformanceAdvisor extends AbstractPointcutAdvisor {

    @Autowired
    private PerformanceInterceptor interceptor;

    public PerformanceAdvisor() {
    }

    private final StaticMethodMatcherPointcut pointcut = new
            StaticMethodMatcherPointcut() {

                public boolean matches(Method method, Class<?> targetClass) {
                    boolean isAnnotationPresent = method.isAnnotationPresent(Performance.class);
                    return isAnnotationPresent;
                }
            };

    public Pointcut getPointcut() {
        return this.pointcut;
    }

    public Advice getAdvice() {
        return this.interceptor;
    }
}
