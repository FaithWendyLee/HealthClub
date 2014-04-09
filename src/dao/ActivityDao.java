package dao;

/**
 * 提供了对活动进行数据库操作的接口
* @author 王选易
* @version 1.0
* @since 1.7
*/
public interface ActivityDao extends BaseDao {
	public void removeCard(int activity_id, int card_id);
}
