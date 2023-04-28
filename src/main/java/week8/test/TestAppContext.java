package week8.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week8.exception.MyServiceExcept;
import week8.services.MyService;

public class TestAppContext {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(" app-context.xml");

        MyService myService = (MyService) context.getBean("service");
        try {
            String key = myService.login("123@gmail.com", "1234qwer");
            System.out.println(key);
        } catch (MyServiceExcept e) {
            e.printStackTrace();
        }
    }
}
