package main.java.com.framework.impl;

import main.java.com.framework.service.DemoService;
import main.java.com.framework.service.LogService;
import main.java.com.performance.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by george on 2017/5/25.
 */
@Service
public class DefaultDemoService implements DemoService {
    private LogService logService;

    @Autowired
    public DefaultDemoService(LogService logService) {
        this.logService = logService;
        logService.setType(DefaultDemoService.class);
    }

    @Performance
    public void test(String message) {
        logService.debug(message);
    }
}
