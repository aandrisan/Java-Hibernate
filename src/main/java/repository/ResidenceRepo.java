package repository;

import entity.Residence;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ResidenceRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewResidnce(Residence residence) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(residence);
        em.getTransaction().commit();
        em.close();
    }

    public List<Residence> findAllResidenceOfUser (String idUser){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u from Residence u WHERE u.owner= :idUser");
        query.setParameter("idUser",idUser);
        List<Residence> residences =query.getResultList();
        em.close();
        return residences;
    }

    public Residence findResidenceById(String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u FROM Residence u WHERE u.idresidence=:id");
        query.setParameter("id",id);
        if(query.getResultList().isEmpty()){
            return null;
        }
        Residence residence = (Residence) query.getResultList().get(0);
        em.close();
        return residence;
    }

    public Residence findResidenceByLocation(String location, String idUser){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u FROM Residence u WHERE u.location=:loc AND u.owner=:iduser");
        query.setParameter("loc",location);
        query.setParameter("iduser",idUser);
        if(query.getResultList().isEmpty()){
            return null;
        }
        Residence residence = (Residence) query.getResultList().get(0);
        em.close();
        return residence;
    }

    public void deleteResidence(Residence residence){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(residence) ? residence : em.merge(residence));
        em.getTransaction().commit();
        em.close();
    }
}
