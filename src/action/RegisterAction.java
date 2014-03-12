package action;

import java.util.List;

import service.RegisterService;
import model.Card;
import model.User;

public class RegisterAction extends BaseAction {
	private List<User> users;
	private Card card;
	
	private RegisterService registerService;
	
	public String execute() throws Exception {
		System.out.println(request.getParameter("name_1"));
		return null;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(User user) {
		users.add(user);
	}



	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}

	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}
	
	
	
	
}
