package dao;

import sqlEntity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UsersDao implements Dao<Users, Integer>{


    private EntityManager manager;

    public UsersDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Users users) {
        manager.getTransaction().begin();
        manager.persist(users);
        manager.getTransaction().commit();

    }

    public void update(Integer integer, String s) {

    }

    @Override
    public void deleteByPK(Integer integer) {

    }

    @Override
    public void delete(Users users) {

    }
}
