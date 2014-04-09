package service;

import java.util.List;

import model.Activity;
import model.Card;
import model.Employee;

/**
 * 提供对服务员的业务逻辑操作的封装
* @author 王选易
* @version 1.0
* @since 1.7
*/
public interface StaffService {
	public boolean validateStaff(Employee employee);
	
	public void save(Activity activity, String time);
	
	public List<Activity> getAllActivities();
	
	public List<Card> getAllCards();
}
