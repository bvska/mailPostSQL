package start;

import dao.AliasesDao;
import session.Connect;
import sqlEntity.Aliases;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AliasSay implements Say<Aliases>{
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

    public void sayUpdate(Integer integer, String s){
        try {
            connect.run();
            aliasesDao.update(integer, s);
            connect.stop();
        } catch (Exception e) {connect.back();}
    }
}
