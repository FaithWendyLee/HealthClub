package service.impl;

import dao.EmployeeDao;
import model.Employee;
import model.type.EmployeeType;
import service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

	private EmployeeDao employeeDao;

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

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}



		
}
