package service.impl;

import java.util.List;

import dao.ActivityDao;
import dao.EmployeeDao;
import dao.UserDao;
import model.Activity;
import model.Employee;
import model.User;
import model.type.EmployeeType;
import service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

	private EmployeeDao employeeDao;
	
	private UserDao userDao;
	
	private ActivityDao activityDao;

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

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivities() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
