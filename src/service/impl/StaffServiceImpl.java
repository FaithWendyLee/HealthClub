package service.impl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
	public void save(Activity activity, String time) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date date = null;
		try {
			date =  df.parse(time) ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		activity.setTime(date);
		activityDao.save(activity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getAllActivities() {
		
		return (List<Activity>) activityDao.findAll("Activity");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> getAllCards() {
		
		return (List<Card>) cardDao.findAll("Card");
	}
}
