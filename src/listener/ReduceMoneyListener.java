package listener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Card;
import model.User;
import model.type.CardType;
import model.type.StatusType;
import service.CardService;

public class ReduceMoneyListener implements ServletContextListener {
	@Autowired
	CardService cardService;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				List<Card> cards = cardService.getAllCards();
				boolean sucess= false;
				for (Card card : cards) {
					if (card.getType() == CardType.FAMILY){
						int money = 55;
						Set<User> users = card.getUsers();
						for (User user : users) {
							if (user.getAge() >=10 && user.getAge() <= 18)
								money += 10;
						}
					 	sucess = cardService.addPayment(card, money);
					}else{
						sucess = cardService.addPayment(card, 40);
					}
					if (!sucess)
						card.setStatus(StatusType.PAUSE);
				}
			}
		};
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long day = 1000 * 60 * 60 * 24 ;
			long period = day * 30;
			timer.schedule(task, df.parse("2014-01-01"), period);
		} catch (ParseException e) {
			
		}
	}

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}

}
