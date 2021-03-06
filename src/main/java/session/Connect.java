package session;


import javax.persistence.EntityManager;


public class Connect {
    private EntityManager manager;

    public Connect(EntityManager manager) {
        this.manager = manager;
    }

    public void run() {
        manager.getTransaction().begin();
    }

    public void stop() {
        manager.getTransaction().commit();
    }

    public void back() {
        manager.getTransaction().rollback();
    }

}
