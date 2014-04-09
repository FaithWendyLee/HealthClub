package service.impl;

import java.util.Date;
import java.util.List;

import service.CardService;
import dao.ActivityDao;
import dao.AttendanceDao;
import dao.CardDao;
import dao.PaymentDao;
import dao.UserDao;
import model.Activity;
import model.Attendance;
import model.Card;
import model.Payment;
import model.User;
import model.type.StatusType;

public class CardServiceImpl implements CardService {
	
	private UserDao userDao;
	private CardDao cardDao;
	private PaymentDao paymentDao;
	private AttendanceDao attendanceDao;
	private ActivityDao activityDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public CardDao getCardDao() {
		return cardDao;
	}

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}

	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	public AttendanceDao getAttendanceDao() {
		return attendanceDao;
	}

	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}

	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	@Override
	public boolean validateCard(Card card) {
		Card p_card = cardDao.find(card.getId());
		if (p_card != null && p_card.getPassword().equals(card.getPassword())){
			return true;
		}
		return false;
	}
	
	@Override
	public Card getCard(int id) {
		return cardDao.find(id);
	}

	@Override
	public void updateCard(Card oldCard, Card newCard) {
		oldCard.setBankaccount(newCard.getBankaccount());
		oldCard.setPassword(newCard.getPassword());
		if (oldCard.getStatus() == StatusType.CANCEl &&
				newCard.getStatus() == StatusType.VALID){
			int money = oldCard.activate();
			paymentDao.save(new Payment(oldCard, money, new Date()));
		}
		cardDao.update(oldCard);
	}

	@Override
	public void updateUsers(List<User> oldUsers, List<User> newUsers) {
		for (int i = 0; i < oldUsers.size(); i++) {
			oldUsers.get(i).setName(newUsers.get(i).getName());
			oldUsers.get(i).setSex(newUsers.get(i).getSex());
			oldUsers.get(i).setAge(newUsers.get(i).getAge());
			oldUsers.get(i).setAddress(newUsers.get(i).getAddress());
		}
		userDao.updateMany(oldUsers);
	}

	@Override
	public void saveAttendance(int card_id, int activity_id) {
		attendanceDao.save(new Attendance( (Activity) activityDao.find(activity_id, "Activity"),
				cardDao.find(card_id)));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getAllActivities() {
		
		return (List<Activity>) activityDao.findAll("Activity");
	}

	@Override
	public void removeAttendance(Card card, Activity activity) {
		activityDao.removeCard(card.getId(), activity.getId());
	}


}
