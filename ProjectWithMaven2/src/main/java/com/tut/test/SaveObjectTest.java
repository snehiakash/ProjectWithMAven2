package com.tut.test;

import org.hibernate.cfg.Configuration;

import com.tut.entity.Product;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SaveObjectTest {
public static void main(String[] args) {
	Configuration cfg=null;
	SessionFactory sessionFactory=null;
	Session session=null;
	Transaction tx=null;
	
	//Configuration
	cfg = new Configuration();
	sessionFactory=cfg.buildSessionFactory();
	session=sessionFactory.openSession();
	//Entity
	Product product=new Product();
	product.setPid(1);
	product.setPname("MotherBoard");
	product.setPrice(6000.00f);
	product.setQty(1.00f);
	
	try {
		 tx=session.beginTransaction();
		//Saving the Object..
			session.save(product);
		//all non select operation should be committed
			tx.commit();
			System.out.println("Object is Saved");
			
	}catch(HibernateException e) {
		e.printStackTrace();
	}
	finally {
		session.close();
		sessionFactory.close();
	}
}
}
