package service;

import model.Activity;
import model.Employee;

public interface StaffService {
	public boolean validateStaff(Employee employee);
	
	public Activity save(Activity activity);
}
