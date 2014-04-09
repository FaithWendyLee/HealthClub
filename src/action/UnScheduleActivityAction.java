package action;

import java.util.List;
import java.util.Set;

import service.CardService;
import model.Activity;
import model.Card;

/**
 * 实现了服务员取消活动预定操作请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
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
