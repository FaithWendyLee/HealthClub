package service;

import java.util.List;

import model.Activity;
import model.Card;
import model.User;

public interface CardService {
	public boolean validateCard(Card card);

	public Card getCard(int id);
	
	public void updateCard(Card oldCard ,Card newCard);
	
	public void updateUsers(List<User> oldUsers, List<User> newUsers);
	
	public void saveAttendance(int card_id, int activity_id);

	List<Activity> getAllActivities();

	public void removeAttendance(Card card, Activity activity);
}
