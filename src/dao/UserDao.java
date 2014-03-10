package dao;

import java.util.List;

import model.User;

public interface UserDao extends BaseDao {
	
	public User find(int id);

}
