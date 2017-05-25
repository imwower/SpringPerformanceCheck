package main.java.com.framework.impl;

import main.java.com.framework.service.LogService;
import org.springframework.stereotype.Service;

/**
 * Created by george on 2017/5/25.
 */
@Service
public class DefaultLogService implements LogService {
    private Class type;

    public void setType(Class type) {
        this.type = type;
    }

    public void debug(Object message) {
        System.out.println(type.getName() + " " + message);
    }
}
