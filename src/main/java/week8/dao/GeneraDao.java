package week8.dao;

import week8.model.MyUser;
import week8.db.ServiceDB;

public class GeneraDao {

    private ServiceDB serviceDB;

    private String name;

    public GeneraDao(){
    }

    public GeneraDao(ServiceDB serviceDB, String name) {
        this.serviceDB = serviceDB;
        this.name = name;
    }

    public MyUser find(String email) {
        return serviceDB.getMyUserMap().get(email);
    }

    public ServiceDB getServiceDB() {
        return serviceDB;
    }

    public void setServiceDB(ServiceDB serviceDB) {
        this.serviceDB = serviceDB;
    }
}
