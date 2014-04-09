package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Attendance Model的定义
* @author 王选易
* @version 1.0
* @since 1.7
*/
@Entity
@Table(name = "attendances")
public class Attendance implements Serializable {

	private int id;
	private Activity activity;
	private Card card;
	
	public Attendance(){
		
	}
	
	public Attendance(Activity activity, Card card) {
		super();
		this.activity = activity;
		this.card = card;
	}

	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="activity_id")
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="card_id")
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
}
