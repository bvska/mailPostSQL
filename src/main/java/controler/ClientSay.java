package controler;

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

    public void sayDelete(Integer integer){
        try {
            connect.run();
            clientDao.deleteByPK(integer);
            connect.stop();
        } catch (Exception e) {connect.back();}

    }

    public String sayAdd(Client client){
        try {
            connect.run();
            clientDao.add(client);
            connect.stop();
            return "Добавлено";
        } catch (Exception e) {connect.back();
            return " Не Добавлено";}
    }

    public List<Client> saySearch(){
        connect.run();
        List<Client> clients = clientDao.getAll();
        connect.stop();
        return clients;
    }

    public void sayUpdate(Integer integer, String s){
        try {
            connect.run();
            clientDao.update(integer, s);
            connect.stop();
        } catch (Exception e) {connect.back();}
    }

    public Client saySearchId(Integer integer){
        connect.run();
        Client client = clientDao.getPK(integer);
        connect.stop();
        return client;
    }
}
