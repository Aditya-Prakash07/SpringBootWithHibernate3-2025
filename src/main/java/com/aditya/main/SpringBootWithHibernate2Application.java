package com.aditya.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aditya.main.entities.User;

@SpringBootApplication
public class SpringBootWithHibernate2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithHibernate2Application.class, args);

		Configuration cfg = new Configuration();
		cfg.configure("com/aditya/main/config/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			User user = session.get(User.class, 33L);
			if (user != null) {
				System.out.println(user.getName());
				System.out.println(user.getEmail());
			} else {
				System.out.println("Cannot find User Details..#..#");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
