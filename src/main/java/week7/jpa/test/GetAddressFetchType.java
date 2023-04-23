package week7.jpa.test;

import week7.jpa.model.Address;
import week7.jpa.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class GetAddressFetchType {
    public static void main(String[] args) {
/*
        Address address = new Address("Kyiv", "Baboo", "1");

        Author author = new Author("Vanya", 1500, new Date());
        author.setAddress(address);*/

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myunit");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Address address = manager.find(Address.class, 18);
        address.getAuthorList();
        System.out.println(address);
    }
}
