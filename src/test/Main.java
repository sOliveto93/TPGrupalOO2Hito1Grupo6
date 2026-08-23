package test;

import org.hibernate.Session;

import dao.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSesionFactory().openSession();
		session.beginTransaction();
		session.clear();
		System.out.println("OK");
	}

}
