package dao;

import java.util.List;

/**
 * 提供了对数据库进行操作的通用接口
* @author 王选易
* @version 1.0
* @since 1.7
*/

public interface BaseDao {
	/**
	 * 使用Hibernate在数据库里新建一个对象
	 * @param o
	 * @return
	 */
	public int save(Object o);
	
	/**
	 * 使用Hibernate在数据库里新建多个对象
	 * @param arr
	 */
	public void saveMany(List arr);
	
	/**
	 * 使用Hibernate在数据库里新建一个对象
	 * @param o
	 */
	public void update(Object o);
	
	/**
	 * 使用Hibernate在数据库里新建多个对象
	 * @param arr
	 */
	public void updateMany(List arr);
	
	/**
	 * 使用Hibernate在数据库里删除一个对象
	 * @param o
	 */
	public void delete(Object o);

	/**
	 * 在数据库里根据id寻找一个对象
	 * @param id
	 * @param tablename
	 * @return Object
	 */
	public Object find(int id, String tablename);
	
	/**
	 * 得到数据库中该表的所有对象，以List的形式返回
	 * @param tablename
	 * @return List
	 */
	public List findAll(String tablename);
}
