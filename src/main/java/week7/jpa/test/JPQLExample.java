package week7.jpa.test;

import week7.jpa.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JPQLExample {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT s FROM authors s WHERE s.a_name = :inName");

        List list = query.setParameter("inName", "Vanya").setMaxResults(2).getResultList();

        list.stream().forEach(System.out::println);

    }
}
