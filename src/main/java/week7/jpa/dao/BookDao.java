package week7.jpa.dao;

import org.apache.log4j.Logger;
import week7.jpa.model.Book;

import javax.persistence.*;
import java.util.List;

public class BookDao implements Dao<Book> {

    private static final Logger LOGGER = Logger.getLogger(BookDao.class);

    private EntityManagerFactory factory;

    public BookDao(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Book create(Book book) {
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
        return book;
    }

    @Override
    public boolean delete(Book book) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        book = manager.find(book.getClass(), book.getId());

        try {
            transaction.begin();
            manager.remove(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }
        return true;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book findById(Object id) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            Book book = manager.find(Book.class, id);
            return book;
        } finally {
            manager.close();
        }
    }

    public List<Book> getByType(Book.BookType type) {
        EntityManager manager = factory.createEntityManager();
        //java persistence query lenguage(oop+sql)
        TypedQuery<Book> query = manager.createQuery("SELECT b FROM Book b WHERE b.bookType = :typeName", Book.class);

        query.setParameter("typeName", type);
        query.setMaxResults(100);
        query.setFirstResult(0);

        return  query.getResultList();
    }

}
