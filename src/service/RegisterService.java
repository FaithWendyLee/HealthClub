package service;

import model.Card;
import model.User;

public interface RegisterService {
	public void saveUser(User user);
	
	public void saveUsers(User[] users);
	
	public void saveCard(Card card);
}
