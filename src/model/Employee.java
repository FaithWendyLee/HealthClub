package model;

import java.io.Serializable;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

	private int id;
	private String password;
	private int type;
	private Activity activity;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(nullable=false, length=20)
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
	
	@OneToOne(mappedBy="coach")
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}	
	
	
}
