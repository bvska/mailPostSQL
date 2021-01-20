package dao;

import sqlEntity.Aliases;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    @Override
    public void update(Aliases aliases) {
    }



    @Override
    public void deleteByPK(Integer integer) {
        Aliases aliases = getPK(integer);
        if (aliases != null) {
            delete(aliases);
        }
    }

    @Override
    public void delete(Aliases aliases) {
        manager.remove(aliases);
    }

    @Override
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



    public List<Aliases> getAliases(String name){
        List<Aliases> aliasesList = new ArrayList<>();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Aliases> criteriaQuery = builder.createQuery(Aliases.class);
        Root<Aliases> root = criteriaQuery.from(Aliases.class);
        String s = '%' + name + '%';
        criteriaQuery.select(root).where(builder.like(root.get(Aliases_.ALIAS), s));
        TypedQuery<Aliases> query = manager.createQuery(criteriaQuery);
        aliasesList = query.getResultList();
        return aliasesList;
    }
    public List<Aliases> saySearchRcpt(String name){
        List<Aliases> aliasesList = new ArrayList<>();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Aliases> criteriaQuery = builder.createQuery(Aliases.class);
        Root<Aliases> root = criteriaQuery.from(Aliases.class);
        String s = '%' + name + '%';
        criteriaQuery.select(root).where(builder.like(root.get(Aliases_.RCPT), s));
        TypedQuery<Aliases> query = manager.createQuery(criteriaQuery);
        aliasesList = query.getResultList();
        return aliasesList;
    }

}
