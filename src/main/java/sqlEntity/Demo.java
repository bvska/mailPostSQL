package sqlEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
        EntityManager manager = factory.createEntityManager();
//        Users users = new Users(manager);
//        Aliases aliases = new Aliases(manager);
//        Directories directories = new Directories(manager);
//        Transport transport = new Transport(manager);
//        Client client = new Client(manager);
//        Domain domain = new Domain(manager);

        manager.getTransaction().begin();
        manager.getTransaction().commit();
    }
}
