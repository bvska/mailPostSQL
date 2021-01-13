package dao;



import sqlEntity.Client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.List;

public class ClientDao implements Dao<Client, Integer>{

    private EntityManager manager;

    public ClientDao(EntityManager manager){
        this.manager = manager;
    }

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
        System.out.println(client);
        manager.remove(client);
    }

    @Override
    public void deleteByPK(Integer integer) {
        Client client = getPK(integer);
        if (client != null) {
            delete(client);
            System.out.println(client);
    }}

    public Client getPK(Integer integer){
        return manager.find(Client.class, integer);
    }

    public List<Client> getAll(){
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        criteriaQuery.select(root);
        TypedQuery<Client> query = manager.createQuery(criteriaQuery);
        List<Client> clients = query.getResultList();
        return clients;
    }
}
