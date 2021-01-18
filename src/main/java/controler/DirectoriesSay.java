package controler;

import dao.DirectoriesDao;
import session.Connect;
import sqlEntity.Directories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DirectoriesSay implements Say<Directories>{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
    private EntityManager manager = factory.createEntityManager();
    private Connect connect = new Connect(manager);
    private DirectoriesDao directoriesDao = new DirectoriesDao(manager);

    @Override
    public List<Directories> saySearch() {
        connect.run();
        List<Directories> directories = directoriesDao.getAll();
        connect.stop();
        return directories;
    }

    @Override
    public void sayAdd(Directories directories) {
        try {
            connect.run();
            directoriesDao.add(directories);
            connect.stop();
        } catch (Exception e) {connect.back(); }
    }

    @Override
    public void sayDelete(Integer integer) {
        try {
            connect.run();
            directoriesDao.deleteByPK(integer);
            connect.stop();
        } catch (Exception e) {connect.back();}
    }
    public Directories saySearchId(Integer integer){
        connect.run();
        Directories directories = directoriesDao.getPK(integer);
        connect.stop();
        return directories;
    }
}
