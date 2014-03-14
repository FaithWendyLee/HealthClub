package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.type.CardType;
import model.type.StatusType;

@Entity
@Table(name = "cards")
public class Card implements Serializable {

	private int id;
	private String password;
	private CardType type;
	private StatusType status;
	private int bankaccount;
	private int Remaining;
	private Set<User> users = new HashSet<User>();
	private Set<Activity> activities = new HashSet<Activity>();
	private Set<Payment> payments = new HashSet<Payment>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false, length=7)
	public int getId() {
		return id;	
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(nullable=false, length=50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(nullable=false)
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
	@Column(nullable=false)
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	@Column(nullable=false)
	public int getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(int bankaccount) {
		this.bankaccount = bankaccount;
	}
	
	@OneToMany(mappedBy="card", 
			cascade=CascadeType.ALL, 
			fetch=FetchType.EAGER )
	@OrderBy(value="id ASC")
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void addUser(User u){
		if (! this.users.contains(u)){
			this.users.add(u);
			u.setCard(this);
		}
	}
	
	public void removeUser(User u){
		u.setCard(null);
		this.users.remove(u);
	}
	
	@ManyToMany(mappedBy="cards")
	public Set<Activity> getActivities() {
		return activities;
	}
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	
	@OneToMany(mappedBy="card", 
			cascade=CascadeType.ALL, 
			fetch=FetchType.EAGER )
	@OrderBy(value="id ASC")
	public Set<Payment> getPayments() {
		return payments;
	}
	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	
	public void addPayment(Payment p){
		if (! this.payments.contains(p)){
			this.payments.add(p);
			p.setCard(this);
		}
	}
	
	@Column(nullable=false, length=10)
	public void removePayment(Payment p){
		p.setCard(null);
		this.payments.remove(p);
	}
	public int getRemaining() {
		return Remaining;
	}
	public void setRemaining(int remaining) {
		Remaining = remaining;
	}
	
	public void activate(){
		if (this.type == CardType.NORMAL)
			this.setRemaining(this.getRemaining() - 75);
		else
			this.setRemaining(this.getRemaining() - 100);
	}
}
