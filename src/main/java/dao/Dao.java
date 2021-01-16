package dao;

public interface Dao<T, PK> {

    void add(T t);
    void deleteByPK(PK pk);
    void delete(T t);
    T getPK(PK pk);
}
