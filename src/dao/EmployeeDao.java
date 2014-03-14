package dao;

import model.Employee;

public interface EmployeeDao extends BaseDao {

	Employee find(int id);

}
