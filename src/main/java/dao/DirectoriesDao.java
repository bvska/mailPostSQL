package dao;

import sqlEntity.Directories;
import sqlEntity.Transport;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DirectoriesDao implements Dao<Directories, Integer>{

    private EntityManager manager;

    public DirectoriesDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Directories directories) {
        manager.persist(directories);
    }

    @Override
    public void deleteByPK(Integer integer) {
        Directories directories = getPK(integer);
        if (directories != null) {
            delete(directories);
        }
    }

    @Override
    public void delete(Directories directories) {
        manager.remove(directories);
    }

    @Override
    public Directories getPK(Integer integer) {
        return manager.find(Directories.class, integer);
    }

    public List<Directories> getAll(){
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Directories> criteriaQuery = criteriaBuilder.createQuery(Directories.class);
        Root<Directories> root = criteriaQuery.from(Directories.class);
        criteriaQuery.select(root);
        TypedQuery<Directories> query = manager.createQuery(criteriaQuery);
        List<Directories> directories = query.getResultList();
        return directories;
    }
}
