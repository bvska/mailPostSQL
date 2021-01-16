package dao;


import sqlEntity.Directories;
import sqlEntity.Domain;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DomainDao implements Dao<Domain, Integer>{

    private EntityManager manager;

    public DomainDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Domain domain) {
        manager.persist(domain);

    }

    @Override
    public void deleteByPK(Integer integer) {
        Domain domain = getPK(integer);
        if (domain != null) {
            delete(domain);
        }
    }

    @Override
    public void delete(Domain domain) {
        manager.remove(domain);
    }

    @Override
    public Domain getPK(Integer integer) {
        return manager.find(Domain.class, integer);
    }

    public List<Domain> getAll(){
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Domain> criteriaQuery = criteriaBuilder.createQuery(Domain.class);
        Root<Domain> root = criteriaQuery.from(Domain.class);
        criteriaQuery.select(root);
        TypedQuery<Domain> query = manager.createQuery(criteriaQuery);
        List<Domain> domains = query.getResultList();
        return domains;
    }
}
