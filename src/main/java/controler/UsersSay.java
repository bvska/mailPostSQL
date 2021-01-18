package controler;

import dao.UsersDao;
import session.Connect;
import sqlEntity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UsersSay implements Say<Users>{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
    private EntityManager manager = factory.createEntityManager();
    private Connect connect = new Connect(manager);
    private UsersDao usersDao = new UsersDao(manager);

    @Override
    public List<Users> saySearch() {
        connect.run();
        List<Users> users = usersDao.getAll();
        connect.stop();
        return users;
    }

    @Override
    public void sayAdd(Users users) {
        try {
            connect.run();
            usersDao.add(users);
            connect.stop();
        } catch (Exception e) {connect.back(); }
    }

    @Override
    public void sayDelete(Integer integer) {
        try {
            connect.run();
            usersDao.deleteByPK(integer);
            connect.stop();
        } catch (Exception e) {connect.back();}
    }

    public void sayUpdate(Users users) {
        try {
            connect.run();
            usersDao.update(users);
            connect.stop();
        } catch (Exception e) {connect.back(); }
    }

    public List<Users> saySearchEmail(String email){
        connect.run();
        List<Users> usersList = usersDao.getEmail(email);
        connect.stop();
        return usersList;
    }

    public List<Users> saySearchDomain(Integer i){
        connect.run();
        List<Users> users = usersDao.getDomain(i);
        connect.stop();
        return users;
    }

    public Users saySearchId(Integer i) {
        connect.run();
        Users users = usersDao.getPK(i);
        connect.stop();
        return users;
    }
}
