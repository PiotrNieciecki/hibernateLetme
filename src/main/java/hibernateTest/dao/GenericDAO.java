package hibernateTest.dao;

public interface GenericDAO<T,K> {
    void save(T t);
    void delete(K id);
    void update(T t);
    T findById(K id);
}
