package action;

import java.util.List;

import model.Card;
import service.StaffService;

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
