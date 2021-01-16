package dao;

import sqlEntity.Transport;
import sqlEntity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class UsersDao implements Dao<Users, Integer>{


    private EntityManager manager;

    public UsersDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Users users) {
        manager.persist(users);
    }

    public void update(Integer integer, String s) {

    }

    @Override
    public void deleteByPK(Integer integer) {
        Users users = getPK(integer);
        if (users != null) {
            delete(users);
        }
    }

    @Override
    public void delete(Users users) {
        manager.remove(users);
    }

    @Override
    public Users getPK(Integer integer) {
        return manager.find(Users.class, integer);
    }

    public List<Users> getAll() {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Users> criteriaQuery = criteriaBuilder.createQuery(Users.class);
        Root<Users> root = criteriaQuery.from(Users.class);
        criteriaQuery.select(root);
        TypedQuery<Users> query = manager.createQuery(criteriaQuery);
        List<Users> users = query.getResultList();
        return users;
    }
}
