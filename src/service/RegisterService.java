package service;

import java.util.List;

import model.Card;
import model.User;

public interface RegisterService {
	public void saveUser(User user);
	
	public void saveUsers(List<User> users);
	
	public Card saveCard(Card card);
	
	public Card getCard(int id);
}
