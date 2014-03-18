package action;

import service.CardService;
import dao.ActivityDao;
import model.Activity;
import model.Attendance;
import model.Card;

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
