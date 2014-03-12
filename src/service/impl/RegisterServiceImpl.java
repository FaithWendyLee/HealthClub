package service.impl;

import model.Card;
import model.User;
import dao.CardDao;
import dao.UserDao;
import service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
	
	private UserDao userDao;
	private CardDao cardDao;
	
	public void saveUser(User user){
		userDao.save(user);
	}
	
	public void saveUsers(User[] users){
		userDao.saveMany(users);
	}
	
	public void saveCard(Card card){
		cardDao.save(card);
	}

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
	
}
