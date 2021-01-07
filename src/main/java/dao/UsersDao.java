package dao;

import sqlEntity.Users;

import javax.persistence.EntityManager;


public class UsersDao implements Dao<Users, Integer>{

    private EntityManager manager;

    public UsersDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Users users) {
        manager.persist(users);

    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
