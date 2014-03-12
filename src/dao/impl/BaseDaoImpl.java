package dao.impl;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import model.User;

import org.hibernate.Query;
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

	@Override
	public void saveMany(Object[] arr) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		for (Object o : arr) {
			session.save(o);
		}
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
	
	public void updateMany(Object[] arr) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		for (Object o : arr) {
			session.update(o);
		}
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
	public Object find(int id, String entityname) {
		Session session = HibernateUtil.currentSession();
		String hql = "from " + entityname + " where id = ?";
		Query query = (Query) session.createQuery(hql);
		query.setParameter(0, id);
		User user = (User) query.uniqueResult();
		HibernateUtil.closeSession();
		return user;
	}
	
}
