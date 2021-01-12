package dao;



import sqlEntity.Client;

import javax.persistence.EntityManager;

public class ClientDao implements Dao<Client, Integer>{

    private EntityManager manager;

//    public ClientDao(EntityManager manager){
//        this.manager = manager;
//    }

    @Override
    public void add(Client client) {
        manager.persist(client);
    }

    @Override
    public void update(Client client) {
        manager.merge(client);
    }

    @Override
    public void delete(Client client) {
        manager.remove(client);
    }

    @Override
    public void deleteByPK(Integer integer) {
        Client client = getPK(integer);
        if (client != null) {
            delete(client);
    }}

    public Client getPK(Integer integer){
        return manager.find(Client.class, integer);
    }
}
