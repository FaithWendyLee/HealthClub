package action;

import java.util.ArrayList;
import java.util.Set;

import dao.CardDao;
import model.Card;
import model.Payment;
import model.User;
import service.CardService;

public class SeePaymentAction extends BaseAction {
	
	private CardDao cardDao;
	
	private Set<Payment> payments;


	@Override
	public String execute() throws Exception {
		Card p_card = cardDao.find((Integer)session.get("card_id"));
		this.setPayments(p_card.getPayments());
		return "see_payment";
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public CardDao getCardDao() {
		return cardDao;
	}

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}


}
