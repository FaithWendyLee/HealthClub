package service.impl;

import java.util.List;

import dao.ActivityDao;
import dao.CardDao;
import dao.EmployeeDao;
import dao.UserDao;
import model.Activity;
import model.Employee;
import model.User;
import model.Card;
import model.type.EmployeeType;
import service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

	private EmployeeDao employeeDao;
	
	private UserDao userDao;
	
	private ActivityDao activityDao;
	
	private CardDao cardDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}
	
	public CardDao getCardDao() {
		return cardDao;
	}

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}

	@Override
	public boolean validateManager(Employee employee) {
		Employee p_employee = employeeDao.find(employee.getId());
		if (p_employee != null 
				&& p_employee.getType() == EmployeeType.MANAGER
				&& p_employee.getPassword().equals(employee.getPassword())){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) userDao.findAll("User");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getAllActivities() {
		// TODO Auto-generated method stub
		return (List<Activity>) activityDao.findAll("Activity");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> getAllCards() {
		// TODO Auto-generated method stub
		return (List<Card>) cardDao.findAll("Card");
	}
		
}
