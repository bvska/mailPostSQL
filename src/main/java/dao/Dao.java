package dao;

public interface Dao<T, PK> {

    void add(T t);
    void update(T t);
    void deleteByPK(PK pk);
    void delete(T t);

}
