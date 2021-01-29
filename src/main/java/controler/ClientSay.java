package controler;

import dao.ClientDao;
import session.Connect;
import sqlEntity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClientSay implements Say<Client, Integer> {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
    private EntityManager manager = factory.createEntityManager();

    private ClientDao clientDao = new ClientDao(manager);
    private Connect connect = new Connect(manager);

    @Override
    public void sayDelete(Integer integer){
        try {
            connect.run();
            clientDao.deleteByPK(integer);
            connect.stop();
        } catch (Exception e) {connect.back();}

    }

    @Override
    public void sayAdd(Client client){
        try {
            connect.run();
            clientDao.add(client);
            connect.stop();
        } catch (Exception e) {connect.back();
    }

    @Override
    public List<Client> saySearch(){
        connect.run();
        List<Client> clients = clientDao.getAll();
        connect.stop();
        return clients;
    }

    @Override
    public void sayUpdate(Client client){
        try {
            connect.run();
            clientDao.update(client);
            connect.stop();
        } catch (Exception e) {connect.back();}
    }


    @Override
    public Client saySearchId(Integer integer){
        connect.run();
        Client client = clientDao.getPK(integer);
        connect.stop();
        return client;
    }
}
