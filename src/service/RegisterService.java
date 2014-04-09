package service;

import java.util.List;

import model.Card;
import model.User;

/**
 * 提供对注册的业务逻辑操作的封装
* @author 王选易
* @version 1.0
* @since 1.7
*/
public interface RegisterService {
	public void saveUser(User user);
	
	public void saveUsers(List<User> users);
	
	public Card saveCard(Card card);
	
	public Card getCard(int id);
}
