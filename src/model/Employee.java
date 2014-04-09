package model;

import java.io.Serializable;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.type.EmployeeType;

/**
 * Employee Model的定义
* @author 王选易
* @version 1.0
* @since 1.7
*/
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

	private int id;
	private String password;
	private EmployeeType type;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	

}
