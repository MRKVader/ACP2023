package week7.jpa.test;

import week7.jpa.dao.BookDao;
import week7.jpa.dao.Dao;
import week7.jpa.model.Book;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestDao {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myunit");

        BookDao bookDao = new BookDao(factory);

/*        Book book = new Book();
        book.setId(2);
        bookDao.delete(book);*/

        List<Book> list = bookDao.getByType(Book.BookType.IT);

        list.stream().forEach(System.out::println);
    }
}
