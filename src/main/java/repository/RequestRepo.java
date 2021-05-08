package repository;

import dto.RequestAdminDto;
import dto.RequestUserDto;
import entity.Request;
import entity.Residence;
import entity.User;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RequestRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewRequest(Request request) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(request);
        em.getTransaction().commit();
        em.close();
    }

    public List<Request> findAllRequests(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u from Request u");
        List<Request> requests =query.getResultList();
        em.close();
        return requests;

    }

    public List<Request> findRequestsOfUser(String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u from Request u WHERE u.owner=:id");
        query.setParameter("id",id);
        List<Request> requests =query.getResultList();
        em.close();
        return requests;
    }

    public List<Request> findRequestsOfUserResidence(String id, String idDoc, String idResidence){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u from Request u WHERE u.owner=:id AND u.document=: idDoc AND u.residence =: idr");
        query.setParameter("id",id);
        query.setParameter("idDoc",idDoc);
        query.setParameter("idr",idResidence);
        List<Request> requests =query.getResultList();
        em.close();
        return requests;
    }

    public void updateRequest(RequestAdminDto request){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Request request1 = em.find(Request.class, request.getIdRequest());
        request1.setStatus(request.getStatus());

        em.unwrap(Session.class).update(request1);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public void updateRequestDescription(RequestUserDto request){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Request request1 = em.find(Request.class, request.getIdRequest());
        request1.setDescription(request.getDescription());

        em.unwrap(Session.class).update(request1);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public void removeRequest(RequestUserDto requestUserDto){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Request request = em.find(Request.class,requestUserDto.getIdRequest());
        em.remove(em.contains(request) ? request : em.merge(request));
        em.getTransaction().commit();
        em.close();
    }

}
