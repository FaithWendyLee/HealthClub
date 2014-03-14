package dao.impl;

import model.Employee;
import dao.EmployeeDao;

public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao{

	@Override
	public Employee find(int id) {
		return (Employee) super.find(id, "Employee");
	}

}
