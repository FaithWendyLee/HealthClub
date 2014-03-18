package dao.impl;

import model.Activity;
import model.Card;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ActivityDao;

public class ActivityDaoImpl extends BaseDaoImpl implements ActivityDao {
	@Override
	public void removeCard(int activity_id, int card_id) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		Activity activity = (Activity) session.load(Activity.class, activity_id);
		Card card = (Card) session.load(Card.class, card_id);
		activity.getCards().remove(card);
		session.update(activity);
		try {
			transaction.commit();
		} catch (SecurityException | IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
	}
}
