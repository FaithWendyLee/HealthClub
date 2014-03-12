package dao;

import model.Card;

public interface CardDao extends BaseDao {

	public Card find(int id);
}
