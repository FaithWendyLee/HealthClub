package service.impl;

import dao.ActivityDao;
import dao.CardDao;
import dao.EmployeeDao;
import dao.UserDao;
import model.Activity;
import model.Card;
import model.Employee;
import model.type.EmployeeType;
import service.StaffService;

public class StaffServiceImpl implements StaffService {

	EmployeeDao employeeDao;
	UserDao userDao;
	CardDao cardDao;
	ActivityDao activityDao;
	
	@Override
	public boolean validateStaff(Employee employee) {
		Employee p_employee = employeeDao.find(employee.getId());
		if (p_employee != null 
				&& p_employee.getType() == EmployeeType.STAFF 
				&& p_employee.getPassword().equals(employee.getPassword())){
			return true;
		}
		return false;
	}

	@Override
	public Activity save(Activity activity) {
		// TODO Auto-generated method stub
		return null;
	}

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

	public CardDao getCardDao() {
		return cardDao;
	}

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}

	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}
	
	

}
