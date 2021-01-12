package session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connect {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
       EntityManager manager = factory.createEntityManager();

     public void run(){
         manager.getTransaction().begin();

     }

     public void stop(){
         manager.getTransaction().commit();
     }

}
