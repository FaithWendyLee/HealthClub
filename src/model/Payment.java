package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *Payment Model的定义
* @author 王选易
* @version 1.0
* @since 1.7
*/
@Entity
@Table(name = "payments")
public class Payment implements Serializable {

	private int id;
	private Card card;
	private int money;
	private Date date;
	
	public Payment(){
		
	}
	

	
	public Payment(Card card, int money, Date date) {
		super();
		this.card = card;
		this.money = money;
		this.date = date;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="card_id")
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	@Column(nullable = false, length=10)
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
