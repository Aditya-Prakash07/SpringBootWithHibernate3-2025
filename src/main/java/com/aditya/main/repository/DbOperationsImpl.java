package com.aditya.main.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.aditya.main.config.HibernateConfig;
import com.aditya.main.entities.User;

@Repository
public class DbOperationsImpl implements DbOperations {

	@Override
	public User getUserDetails(Long id) {
		User user = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession();) {
			user = session.get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
