package repository;

import entity.User;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserRepo {
	
	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");
	
	public void insertNewUser(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public User findByEmail(String email){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u from User u WHERE u.email= :email");
		query.setParameter("email",email);
		if(query.getResultList().isEmpty()){
			return null;
		}
		User user = (User) query.getResultList().get(0);
		em.close();
		return user;
	}

	public User findByIdUser(String idUser){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u from User u WHERE u.iduser=:idUser");
		query.setParameter("idUser",idUser);
		if(query.getResultList().isEmpty()){
			return null;
		}
		User user = (User) query.getResultList().get(0);
		em.close();
		return user;
	}

	public List<User> getAllUsers(){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u from User u");
		List<User> users =  query.getResultList();
		em.close();
		return users;
	}
}
