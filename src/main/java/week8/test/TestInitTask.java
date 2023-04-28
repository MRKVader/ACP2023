package week8.test;

import week8.ioc.ServiceLocator;
import week8.services.MyService;

public class TestInitTask {
    public static void main(String[] args) {

        MyService myService = ServiceLocator.get("myService");

    }
}
