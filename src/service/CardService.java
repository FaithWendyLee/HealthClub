package service;

import java.util.List;


import model.Activity;
import model.Card;
import model.User;

/**
 * 提供对会员卡的业务逻辑操作的封装
* @author 王选易
* @version 1.0
* @since 1.7
*/
public interface CardService {
	/**
	 * 验证登录是否成功
	 * @param card
	 * @return
	 */
	public boolean validateCard(Card card);

	/**
	 * 根据id得到会员卡
	 * @param id
	 * @return
	 */
	public Card getCard(int id);
	
	/**
	 * 将数据库中的老卡更新成新卡
	 * @param oldCard
	 * @param newCard
	 */
	public void updateCard(Card oldCard ,Card newCard);
	
	/**
	 * 将数据库老卡对应的Users更新
	 * @param oldUsers
	 * @param newUsers
	 */
	public void updateUsers(List<User> oldUsers, List<User> newUsers);
	
	/**
	 * 新建一个预定
	 * @param card_id
	 * @param activity_id
	 */
	public void saveAttendance(int card_id, int activity_id);

<<<<<<< HEAD
	/**
	 * 得到所有的活动
	 * @return
	 */
	public List<Activity> getAllActivities();
=======
	List<Activity> getAllActivities();
>>>>>>> parent of 1376179... last commit

	/**
	 * 删除一个预定
	 * @param card
	 * @param activity
	 */
	public void removeAttendance(Card card, Activity activity);
<<<<<<< HEAD

	/**
	 * 得到所有的卡
	 * @return List
	 */
	public List<Card> getAllCards();
	
	/**
	 * 为一个卡添加一个缴费记录
	 * @param card
	 * @param money
	 * @return
	 */
	public boolean addPayment(Card card, int money);
=======
>>>>>>> parent of 1376179... last commit
}
