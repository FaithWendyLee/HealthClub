package dao;

import java.util.List;


public interface BaseDao {
	public void save(Object o);
	
	public void saveMany(Object[] arr);
	
	public void update(Object o);
	
	public void updateMany(Object[] arr);

	public Object find(int id, String tablename);
}
