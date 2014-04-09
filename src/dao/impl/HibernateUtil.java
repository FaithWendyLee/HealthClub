package dao.impl;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 封装了Hibernate操作的工具类
* @author 王选易
* @version 1.0
* @since 1.7
*/
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
	
	/**
	 * 得到当前所用的Session，如果没有则创建一个
	 * @return
	 */
	public static Session currentSession() {
		Session currentSession = threadLocal.get();
		if (currentSession == null) {
			currentSession = sessionFactory.openSession();
			threadLocal.set(currentSession);
		}
		return currentSession;
	}

	/**
	 * 关闭当前所用的Session
	 */
	public static void closeSession() {
		Session currentSession = (Session) threadLocal.get();
		if (currentSession != null) {
			currentSession.close();
		}
		threadLocal.set(null);
	}
	
	public static void main(String[] args){
        //装载配置文件  
		Configuration cfg = new Configuration().configure();  
		SchemaExport export = new SchemaExport(cfg);  
		export.create(true, true); 
		System.out.println("haha");
	}
}
