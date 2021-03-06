package controler;

import dao.AliasesDao;
import session.Connect;
import sqlEntity.Aliases;
import sqlEntity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AliasSay implements Say<Aliases, Integer>{
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
    private EntityManager manager = factory.createEntityManager();

    private AliasesDao aliasesDao = new AliasesDao(manager);
    private Connect connect = new Connect(manager);

    @Override
    public void sayDelete(Integer integer){
        try {
            connect.run();
            aliasesDao.deleteByPK(integer);
            connect.stop();
        } catch (Exception e) {connect.back();}

    }

    @Override
    public void sayAdd(Aliases aliases){
        try {
            connect.run();
            aliasesDao.add(aliases);
            connect.stop();
        } catch (Exception e) {connect.back(); }
    }

    @Override
    public List<Aliases> saySearch(){
        connect.run();
        List<Aliases> aliases = aliasesDao.getAll();
        connect.stop();
        return aliases;
    }

    @Override
    public void sayUpdate(Aliases aliases){
        try {
            connect.run();
            aliasesDao.update(aliases);
            connect.stop();
        } catch (Exception e) {connect.back();}
    }

    public List<Aliases> saySearchAliases(String alias){
        connect.run();
        List<Aliases> aliases = aliasesDao.getAliases(alias);
        connect.stop();
        return aliases;
    }

    public List<Aliases> saySearchRcpt(String rcpt){
        connect.run();
        List<Aliases> aliases = aliasesDao.saySearchRcpt(rcpt);
        connect.stop();
       return aliases;
    }

    @Override
    public Aliases saySearchId(Integer i) {
        connect.run();
        Aliases aliases = aliasesDao.getPK(i);
        connect.stop();
        return aliases;
    }


    public void addAliases(String email, String domain){
        String address = email + "@" + domain;
        sayAdd(new Aliases(address, address));
    }

}
