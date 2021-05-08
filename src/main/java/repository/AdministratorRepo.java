package repository;

import entity.Administrator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AdministratorRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewAdmin(Administrator admin) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
        em.close();
    }

    public Administrator findByEmail(String email){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u from Administrator u WHERE u.email= :email");
        query.setParameter("email",email);
        if(query.getResultList().isEmpty()){
            return null;
        }
        Administrator admin = (Administrator) query.getResultList().get(0);
        em.close();
        return admin;
    }
}
