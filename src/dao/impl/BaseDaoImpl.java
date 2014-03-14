package dao.impl;

import java.util.List;

import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.BaseDao;

public class BaseDaoImpl implements BaseDao {

	@Override
	public int save(Object o) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		int result = (Integer) session.save(o);
		try {
			transaction.commit();
		} catch (SecurityException | IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
		return result;
	}

	@Override
	public void update(Object o) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		session.update(o);
		try {
			transaction.commit();
		} catch (SecurityException | IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
	}

	@Override
	public void saveMany(List arr) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		for (Object o : arr) {
			session.save(o);
		}
		try {
			transaction.commit();
		} catch (SecurityException | IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
	}
	
	public void updateMany(List arr) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		for (Object o : arr) {
			session.update(o);
		}
		try {
			transaction.commit();
		} catch (SecurityException | IllegalStateException e) {
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
		Object o = query.uniqueResult();
		HibernateUtil.closeSession();
		return o;
	}
	
}
