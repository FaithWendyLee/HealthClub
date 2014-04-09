package action;

import java.util.ArrayList;
import java.util.List;

import service.RegisterService;
import model.Card;
import model.User;
import model.type.CardType;
import model.type.SexType;
import model.type.StatusType;

/**
 * 实现了注册用户操作POST请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
public class RegisterAction extends BaseAction {
	private String[] name, sex, address; 
	private int[] age;
	private Card card;
	private List<User> users;
	
	private RegisterService registerService;
	
	public String execute() throws Exception {
		card.setStatus(StatusType.CANCEl);
		card.setRemaining(100);
		CardType type = (request.getParameter("type").equals("normal") ? CardType.NORMAL : CardType.FAMILY) ;
		card.setType(type);
		Card p_card = registerService.saveCard(card);
		users = new ArrayList<User>();
		for (int i = 0; i < name.length; i++) {
			SexType sexType = sex[i].equals("男") ? SexType.MALE : SexType.FEMALE;
			User user = new User(name[i], p_card, age[i], sexType, address[i]);
			users.add(user);
		}
		registerService.saveUsers(users);
		return "finish";
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

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String[] getSex() {
		return sex;
	}

	public void setSex(String[] sex) {
		this.sex = sex;
	}

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		this.address = address;
	}

	public int[] getAge() {
		return age;
	}

	public void setAge(int[] age) {
		this.age = age;
	}
	
	
	
	
}
