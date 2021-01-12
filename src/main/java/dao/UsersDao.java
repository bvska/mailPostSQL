package dao;

import sqlEntity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UsersDao implements Dao<Users, Integer>{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
    private EntityManager manager = factory.createEntityManager();

    public UsersDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Users users) {
        manager.getTransaction().begin();
        manager.persist(users);
        manager.getTransaction().commit();

    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void deleteByPK(Integer integer) {

    }

    @Override
    public void delete(Users users) {

    }
}
