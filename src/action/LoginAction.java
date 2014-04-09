package action;

import java.util.ArrayList;

import service.CardService;
import model.Card;
import model.Payment;
import model.User;

/**
 * 实现了持有家庭卡或普通卡的会员登录操作POST请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
public class LoginAction extends BaseAction {
	private Card card;
	
	private CardService cardService;

	@Override
	public String execute() throws Exception {
		
		if (cardService.validateCard(card))
		{
			Card p_card = cardService.getCard(card.getId());
			session.put("card_id", p_card.getId());
			session.put("p_card", p_card);
			session.put("p_users", new ArrayList<User>(p_card.getUsers()));
			return "home";
		}
		session.put("error", "您输入的用户名或者密码有误");
		return "error";
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}
	
	
}
