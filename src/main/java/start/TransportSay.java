package start;

import dao.TransportDao;
import session.Connect;
import sqlEntity.Aliases;
import sqlEntity.Domain;
import sqlEntity.Transport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TransportSay implements Say<Transport>{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
    private EntityManager manager = factory.createEntityManager();
    private Connect connect = new Connect(manager);
    TransportDao transportDao = new TransportDao(manager);

    @Override
    public List<Transport> saySearch() {
        connect.run();
        List<Transport> transports = transportDao.getAll();
        connect.stop();
        return transports;
    }

    @Override
    public void sayAdd(Transport transport) {
        try {
            connect.run();
            transportDao.add(transport);
            connect.stop();
        } catch (Exception e) {connect.back(); }
    }

    @Override
    public void sayDelete(Integer integer) {
        try {
            connect.run();
            transportDao.deleteByPK(integer);
            connect.stop();
        } catch (Exception e) {connect.back();}
    }
}
