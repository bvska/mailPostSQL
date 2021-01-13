package start;

import dao.ClientDao;
import session.Connect;
import session.CreateManager;
import sqlEntity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientSay {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
    EntityManager manager = factory.createEntityManager();

    private ClientDao clientDao = new ClientDao(manager);
    private Connect connect = new Connect(manager);

    public void say(Integer integer){
        connect.run();
        clientDao.deleteByPK(integer);
        connect.stop();
    }

    public void sayAdd(Client client){
        connect.run();
        clientDao.add(client);
        connect.stop();
    }
}
