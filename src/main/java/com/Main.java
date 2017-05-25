package main.java.com;

import main.java.com.framework.service.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by george on 2017/5/25.
 */
public class Main {
    public static void main(String args[]) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("main.java.com");

        DemoService demoService = applicationContext.getBean(DemoService.class);
        demoService.test("hello world");
    }
}
