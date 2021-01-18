package dao;

import sqlEntity.Aliases;
import sqlEntity.Transport;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TransportDao implements Dao<Transport, Integer> {
    private EntityManager manager;

    public TransportDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Transport transport) {
        manager.persist(transport);
    }

    @Override
    public void deleteByPK(Integer integer) {
        Transport transport = getPK(integer);
        if (transport != null) {
            delete(transport);
        }
    }

    @Override
    public void update(Transport transport) {

    }

    @Override
    public void delete(Transport transport) {
        manager.remove(transport);
    }

    @Override
    public Transport getPK(Integer integer) {
        return manager.find(Transport.class, integer);
    }

    public List<Transport> getAll() {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Transport> criteriaQuery = criteriaBuilder.createQuery(Transport.class);
        Root<Transport> root = criteriaQuery.from(Transport.class);
        criteriaQuery.select(root);
        TypedQuery<Transport> query = manager.createQuery(criteriaQuery);
        List<Transport> transports = query.getResultList();
        return transports;
    }
}
