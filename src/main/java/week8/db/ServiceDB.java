package week8.db;

import week8.model.MyUser;

import java.util.HashMap;
import java.util.Map;

public class ServiceDB {

    private Map<String, MyUser> myUserMap;
/*
    public ServiceDB() {
    }*/

    public ServiceDB() {
        myUserMap = new HashMap<>();
        myUserMap.put("123@gmail.com", new MyUser("123@gmail.com", "1234qwer"));
        myUserMap.put("456@gmail.com", new MyUser("456@gmail.com", "qwer1234"));
        myUserMap.put("789@gmail.com", new MyUser("789@gmail.com", "4321qwer"));
    }

    public Map<String, MyUser> getMyUserMap() {
        return myUserMap;
    }

    public void setMyUserMap(Map<String, MyUser> myUserMap) {
        this.myUserMap = myUserMap;
    }

}
