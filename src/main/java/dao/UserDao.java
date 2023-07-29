package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.catalina.Manager;

import dto.Task;
import dto.User;

public class UserDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save(User user) {

		et.begin();
		em.persist(user);
		et.commit();

	}

	public User fetchBytEmail(String email)

	{
		List<User> list = em.createQuery("select x from User x where email=?1").setParameter(1, email).getResultList();

		if (list.isEmpty())
			return null;

		else
			return list.get(0);
	}

	public void save(Task task) {

		et.begin();
		em.persist(task);
		et.commit();

	}

	public List<Task> fetchAllTasks() { //to fetch all the data from batabase we aretaking createquery
		return em.createQuery("select x from Task x").getResultList();

	}
}
