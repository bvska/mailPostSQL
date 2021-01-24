package dao;

import sqlEntity.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
    public void update(Users users) {
        manager.merge(users);
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
    public List<Users> getEmail(String name){
        List<Users> usersList = new ArrayList<>();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Users> criteriaQuery = builder.createQuery(Users.class);
        Root<Users> root = criteriaQuery.from(Users.class);
        String s = '%' + name + '%';
        criteriaQuery.select(root).where(builder.like(root.get(Users_.EMAIL), s));
        TypedQuery<Users> query = manager.createQuery(criteriaQuery);
        usersList = query.getResultList();
        return usersList;
    }
    public List<Users> getDomain(Domain domain){
        List<Users> usersList = new ArrayList<>();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Users> criteriaQuery = builder.createQuery(Users.class);
        Root<Users> root = criteriaQuery.from(Users.class);
        Predicate condition = builder.equal(root.get(Users_.fk_tb_domain), domain);
        criteriaQuery.select(root).where(condition);
        TypedQuery<Users> query = manager.createQuery(criteriaQuery);
         usersList = query.getResultList();
        return usersList;
    }
}
