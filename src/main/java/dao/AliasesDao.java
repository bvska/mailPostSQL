package dao;

import sqlEntity.Aliases;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AliasesDao implements Dao<Aliases, Integer> {
    private EntityManager manager;

    public AliasesDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Aliases aliases) {
        manager.persist(aliases);

    }

    public void update(Integer integer, String s) {
        Aliases aliases = getPK(integer);
        if (aliases != null) {
       //     aliases.setDescription(s);
            manager.merge(aliases);
        }
    }


    @Override
    public void deleteByPK(Integer integer) {
    }

    @Override
    public void delete(Aliases aliases) {
    }

    public Aliases getPK(Integer integer) {
        return manager.find(Aliases.class, integer);
    }

    public List<Aliases> getAll(){
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Aliases> criteriaQuery = criteriaBuilder.createQuery(Aliases.class);
        Root<Aliases> root = criteriaQuery.from(Aliases.class);
        criteriaQuery.select(root);
        TypedQuery<Aliases> query = manager.createQuery(criteriaQuery);
        List<Aliases> aliases = query.getResultList();
        return aliases;
    }
}
