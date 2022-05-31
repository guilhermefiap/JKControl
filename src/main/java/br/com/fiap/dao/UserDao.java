package br.com.fiap.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.User;

public class UserDao {

	@Inject
	private EntityManager manager;
	
	public List<User> listAll() {
		TypedQuery<User> query = 
				manager.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}

	public void create(User user) {
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.clear();
	}

}
