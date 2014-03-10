package dao.impl;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import dao.BaseDao;

public class BaseDaoImpl implements BaseDao {

	@Override
	public void save(Object o) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		session.save(o);
		try {
			transaction.commit();
		} catch (SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException
				| SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
	}

	@Override
	public void update(Object o) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		session.update(o);
		try {
			transaction.commit();
		} catch (SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException
				| SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
	}
	
}
