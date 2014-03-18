package action;

import service.CardService;

import java.util.Set;

import model.Activity;
import model.Card;

public class SeeActivityAction extends BaseAction {
	CardService cardService;
	
	Set<Activity> activities;

	@Override
	public String execute() throws Exception {
		Card p_card = cardService.getCard((Integer)session.get("card_id"));
		this.setActivities(p_card.getActivities());
		return "see_activity";
	}

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	
}
