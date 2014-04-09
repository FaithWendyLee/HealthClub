package action;

import java.util.ArrayList;
import java.util.List;

import service.CardService;
import model.Card;
import model.User;
import model.type.SexType;
import model.type.StatusType;

/**
 * 实现了对卡和用户信息的更新操作POST请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
public class ChangeInfoAction extends BaseAction {
	private CardService cardService;
	
	private String[] name, sex, address; 
	private int[] age;
	private Card card;
	private boolean activate = false;

	@Override
	public String execute() throws Exception {
		Card p_card = (Card) session.get("p_card");
		if (activate == true)
			card.setStatus(StatusType.VALID);
		cardService.updateCard(p_card, card);
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < name.length; i++) {
			SexType sexType = sex[i].equals("男") ? SexType.MALE : SexType.FEMALE;
			User user = new User(name[i], p_card, age[i], sexType, address[i]);
			users.add(user);
		}
		@SuppressWarnings("unchecked")
		List<User> oldUsers = (List<User>)session.get("p_users");
		cardService.updateUsers(oldUsers, users);
		if (request.getParameter("source") != null)
			return "show_all";
		else
			return "home";
	}

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
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
	
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}

	public boolean isActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	
	
}
