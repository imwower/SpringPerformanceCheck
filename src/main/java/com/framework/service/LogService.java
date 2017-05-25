package main.java.com.framework.service;

/**
 * Created by george on 2017/5/25.
 */
public interface LogService {
    void setType(Class type);

    void debug(Object message);
}
