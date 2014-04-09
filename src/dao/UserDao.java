package dao;

import java.util.List;

import model.User;

/**
 * 提供了对用户进行数据库操作的接口
* @author 王选易
* @version 1.0
* @since 1.7
*/
public interface UserDao extends BaseDao {
	
	public User find(int id);
	

}
