package service;

import java.util.List;

import model.Activity;
import model.Card;
import model.Employee;

public interface StaffService {
	public boolean validateStaff(Employee employee);
	
	public void save(Activity activity, String time);
	
	public List<Activity> getAllActivities();
	
	public List<Card> getAllCards();
}
