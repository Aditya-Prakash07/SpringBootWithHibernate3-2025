package com.aditya.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aditya.main.entities.User;
import com.aditya.main.repository.DbOperations;

@SpringBootApplication
public class SpringBootWithHibernate3Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringBootWithHibernate3Application.class, args);
		DbOperations dbop = context.getBean(DbOperations.class);
		long id = 1L;
		User user = dbop.getUserDetails(id);
		if (user != null) {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
		} else {
			System.out.println("No Records Found With User Id : " + id);
		}
	}

}
