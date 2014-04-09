package action;

import service.CardService;
import dao.ActivityDao;
import model.Activity;
import model.Attendance;
import model.Card;

/**
 * 实现了对用户预订活动操作请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
public class ScheduleActivityAction extends BaseAction {
	private int id;
	
	private CardService cardService;
	

	@Override
	public String execute() throws Exception {
		id = Integer.parseInt(request.getParameter("id"));
		System.out.print(((Integer)session.get("card_id")) + id);
		cardService.saveAttendance(((Integer)session.get("card_id")), getId());
		return "see_ok_activity";
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
