package dao;

import model.Card;

/**
 * 提供了对卡进行数据库操作的接口
* @author 王选易
* @version 1.0
* @since 1.7
*/
public interface CardDao extends BaseDao {

	public Card find(int id);
}
