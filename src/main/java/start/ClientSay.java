package start;

import dao.ClientDao;
import session.Connect;
import sqlEntity.Client;

public class ClientSay {
    private ClientDao clientDao = new ClientDao();
    private Connect connect = new Connect();

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
