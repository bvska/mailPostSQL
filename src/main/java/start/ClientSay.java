package start;

import dao.ClientDao;
import session.Connect;
import sqlEntity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClientSay {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
    private EntityManager manager = factory.createEntityManager();

    private ClientDao clientDao = new ClientDao(manager);
    private Connect connect = new Connect(manager);

    public void say(Integer integer){
        connect.run();
        clientDao.deleteByPK(integer);
        connect.stop();
    }

    public String sayAdd(Client client){
        connect.run();
        clientDao.add(client);
        connect.stop();
        return "Добавлено";
    }

    public List<Client> saySearch(){
        connect.run();
        List<Client> clients = clientDao.getAll();
        connect.stop();
        return clients;
    }
}
