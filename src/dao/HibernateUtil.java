package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSesionFactory() {
		try {
			if(sessionFactory == null) {
				StandardServiceRegistry stantardRegistry = new StandardServiceRegistryBuilder()
						.configure("hibernate.cfg.xml").build();
				Metadata metaData = new MetadataSources(stantardRegistry).getMetadataBuilder().build();
				sessionFactory = metaData.getSessionFactoryBuilder().build();
				
			}
		} catch (HibernateException e) {
			System.out.println("Error en la inicializacion de la sessionFactory " + e);
			throw new ExceptionInInitializerError(e);
		}
		
		return sessionFactory;
	}
}
