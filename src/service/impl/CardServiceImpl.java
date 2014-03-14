package service.impl;

import java.util.List;

import service.CardService;
import dao.CardDao;
import dao.UserDao;
import model.Card;
import model.User;
import model.type.StatusType;

public class CardServiceImpl implements CardService {
	
	private UserDao userDao;
	private CardDao cardDao;

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
			oldCard.setStatus(StatusType.VALID);
			oldCard.activate();
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


}
