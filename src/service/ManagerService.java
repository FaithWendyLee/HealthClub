package service;

import java.util.List;

import model.Activity;
import model.Card;
import model.Employee;
import model.User;

/**
 * 提供对经理的业务逻辑操作的封装
* @author 王选易
* @version 1.0
* @since 1.7
*/
public interface ManagerService {

	/**
	 * 验证经历登录是否成功
	 * @param employee
	 * @return
	 */
	public boolean validateManager(Employee employee);
	
	/**
	 * 得到所有的用户
	 * @return
	 */
	public List<User> getAllUser();
	
	/**
	 * 得到所有的卡片
	 * @return
	 */
	public List<Card> getAllCards();

	/**
	 * 得到所有的活动
	 * @return
	 */
	public List<Activity> getAllActivities();
}
