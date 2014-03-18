package service;

import java.util.List;

import model.Activity;
import model.Card;
import model.Employee;
import model.User;

public interface ManagerService {

	public boolean validateManager(Employee employee);
	
	public List<User> getAllUser();
	
	public List<Card> getAllCards();

	public List<Activity> getAllActivities();
}
