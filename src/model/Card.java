package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card implements Serializable {

	private int id;
	private String password;
	private int type;
	private int status;
	private int bankaccount;
	private Date lastDate;
	private Set<User> users = new HashSet<User>();
	private Set<Activity> activities = new HashSet<Activity>();
	
	@Id
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
	
	@Column(nullable=false, length=2)
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Column(nullable=false, length=2)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(nullable=false)
	public int getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(int bankaccount) {
		this.bankaccount = bankaccount;
	}
	
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	
	@OneToMany(mappedBy="card", 
			cascade=CascadeType.ALL, 
			fetch=FetchType.LAZY )
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
	
	
}
