package main.java.com.performance;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by george on 2017/5/25.
 */
@Component
public class PerformanceBean {
    @Bean
    public DefaultAdvisorAutoProxyCreator debugAdvisor() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
//        defaultAdvisorAutoProxyCreator.setAdvisorBeanNamePrefix("package.name");
        return defaultAdvisorAutoProxyCreator;
    }
}
