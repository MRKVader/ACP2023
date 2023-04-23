package week7.jpa.test;

import week7.jpa.model.Address;
import week7.jpa.model.Author;
import week7.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class TestRelations {
    public static void main(String[] args) {

        Address address = new Address("Kyiv", "Baboo", "1");

        Author author = new Author("Vanya", 1500, new Date());
        author.setAddress(address);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = factory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(author);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        factory.close();
    }

}
