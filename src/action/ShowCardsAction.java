package action;

import java.util.List;

import model.Card;
import service.StaffService;

/**
 * 实现了服务员查看所有会员卡操作请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
public class ShowCardsAction extends BaseAction {
	StaffService staffService;
	
	List<Card> cards;
	
	@Override
	public String execute() throws Exception {
		this.setCards(staffService.getAllCards());
		session.put("cards", cards);
		return "show_all";
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
