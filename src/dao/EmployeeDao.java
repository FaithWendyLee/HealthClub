package dao;

import model.Employee;

/**
 * 提供了对雇员进行数据库操作的接口
* @author 王选易
* @version 1.0
* @since 1.7
*/
public interface EmployeeDao extends BaseDao {

	Employee find(int id);

}
