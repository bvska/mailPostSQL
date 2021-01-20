package controler;


import dao.DomainDao;
import session.Connect;
import sqlEntity.Aliases;
import sqlEntity.Domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DomainSay implements Say<Domain>{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
    private EntityManager manager = factory.createEntityManager();
    private Connect connect = new Connect(manager);
    private DomainDao domainDao = new DomainDao(manager);

    @Override
    public List<Domain> saySearch() {
        connect.run();
        List<Domain> domains = domainDao.getAll();
        connect.stop();
        return domains;
    }

    @Override
    public void sayAdd(Domain domain) {
        try {
            connect.run();
            domainDao.add(domain);
            connect.stop();
        } catch (Exception e) {connect.back(); }
    }

    @Override
    public void sayDelete(Integer integer) {
        try {
            connect.run();
            domainDao.deleteByPK(integer);
            connect.stop();
        } catch (Exception e) {connect.back();}
    }

    public Domain saySearchId(Integer integer){
        connect.run();
        Domain domain = domainDao.getPK(integer);
        connect.stop();
        return domain;
    }

    public void sayUpdate(Domain domain){
        try {
            connect.run();
            domainDao.update(domain);
            connect.stop();
        } catch (Exception e) {connect.back();}
    }
}
