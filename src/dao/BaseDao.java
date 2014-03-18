package dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDao {
	public int save(Object o);
	
	public void saveMany(List arr);
	
	public void update(Object o);
	
	public void updateMany(List arr);
	
	public void delete(Object o);

	public Object find(int id, String tablename);
	
	public List findAll(String tablename);
}
