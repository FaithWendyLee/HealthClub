package dao.impl;

import model.Card;
import model.User;
import dao.CardDao;

public class CardDaoImpl extends BaseDaoImpl implements CardDao {

	@Override
	public Card find(int id) {
		return (Card) super.find(id, "Card");
	}

}
