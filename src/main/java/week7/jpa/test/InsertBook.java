package week7.jpa.test;

import week7.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class InsertBook {

    public static void main(String[] args) {

        Book book = new Book("Java", Book.BookType.IT, "Kyiv", new Date(), 800);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = factory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        factory.close();
    }
}
