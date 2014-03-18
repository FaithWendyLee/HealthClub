package action;

import java.util.List;
import java.util.Set;

import service.CardService;
import model.Activity;
import model.Card;

public class UnScheduleActivityAction extends BaseAction {
	private int id;
	
	private CardService cardService;
	

	@Override
	public String execute() throws Exception {
		id = Integer.parseInt(request.getParameter("id"));
		Card p_card = (Card) session.get("p_card");
		Set<Activity> p_card_activities = (Set<Activity>) p_card.getActivities();
		Activity p_activity = null;
		for (Activity activity : p_card_activities) {
			if (activity.getId() == getId()){
				p_activity = activity;
				break;
			}
		}
		cardService.removeAttendance(p_card, p_activity);
		return "change_attendance";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}
	
}
