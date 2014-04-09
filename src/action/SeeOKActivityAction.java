package action;

import java.util.List;
import java.util.Set;

import model.Activity;
import model.Card;
import service.CardService;

/**
 * 实现了用户查看可以预定的活动操作请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
public class SeeOKActivityAction extends BaseAction {
	CardService cardService;
	
	List<Activity> activities;

	@Override
	public String execute() throws Exception {
		Card p_card = cardService.getCard((Integer)session.get("card_id"));
		Set<Activity> p_activities = p_card.getActivities();
		List<Activity> all_activities = cardService.getAllActivities();
		all_activities.removeAll(p_activities);
		activities = all_activities;
		return "see_ok_activity";
	}

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
}
