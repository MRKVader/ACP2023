package week7.jpa.dao;

public interface Dao<T> {

    T create(T book);

    boolean delete(T book);

    T update(T book);

    T findById(Object id);
}
