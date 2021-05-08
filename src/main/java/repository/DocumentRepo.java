package repository;

import entity.Document;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DocumentRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewDocument(Document document) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(document);
        em.getTransaction().commit();
        em.close();
    }

    public List<Document> findAllDocument(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u from Document u");
        List<Document> documents =  query.getResultList();
        em.close();
        return documents;
    }

    public void deleteDcoument(Document document){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(document) ? document : em.merge(document));
        em.getTransaction().commit();
        em.close();
    }

    public Document findDocumentById (String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u from Document u WHERE u.iddocument=:id");
        query.setParameter("id",id);
        if(query.getResultList().isEmpty()){
            return null;
        }
        Document document = (Document) query.getResultList().get(0);
        em.close();
        return document;
    }

    public Document findDocumentByName (String name){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u from Document u WHERE u.name=:name");
        query.setParameter("name",name);
        if(query.getResultList().isEmpty()){
            return null;
        }
        Document document = (Document) query.getResultList().get(0);
        em.close();
        return document;
    }
}
