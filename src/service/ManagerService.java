package service;

import java.util.List;

import model.Activity;
import model.Employee;
import model.User;

public interface ManagerService {

	public boolean validateManager(Employee employee);
	
	public List<User> getAllUser();

	public List<Activity> getAllActivities();
}
