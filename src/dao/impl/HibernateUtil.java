package dao.impl;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static HibernateUtil util = new HibernateUtil();
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static SessionFactory sessionFactory;
	
	private HibernateUtil(){
		
		try {
			InitialContext jndiContext = new InitialContext();
			DataSource dataSource = (DataSource) jndiContext
					.lookup("java:comp/env/jdbc/HealthClub");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		Configuration cfg = new Configuration();
		cfg.configure();		
		ServiceRegistry  sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();         
		sessionFactory = cfg.buildSessionFactory(sr);
	}
	
	public static Session currentSession() {
		Session currentSession = threadLocal.get();
		if (currentSession == null) {
			currentSession = sessionFactory.openSession();
			threadLocal.set(currentSession);
		}
		return currentSession;
	}

	public static void closeSession() {
		Session currentSession = (Session) threadLocal.get();
		if (currentSession != null) {
			currentSession.close();
		}
		threadLocal.set(null);
	}
}
