package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.User;
import dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User find(int id) {
		return (User) super.find(id, "User");
	}

}
