package com.zone.enter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.zone.signup.SignupModel;

@Entity
@Table( name = "z_page")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageModel {
	
	private int stu_id;
	private String name;
	private String rollno;
	private String address;
	private String mobileno;
	private String created_date;
	private String updated_date;
	private String created_by;
	private String updated_by;
	private String obsolete;
	private String active;
	
	public PageModel() {
		
	}

	@Id
	@Column(name = "stu_id")
	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	
	public SignupModel signupModel;
	@JoinColumn(name ="client_id")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public SignupModel getSignupModel() {
		return signupModel;
	}

	public void setSignupModel(SignupModel signupModel) {
		this.signupModel = signupModel;
	}

	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "rollno")
	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "mobileno")
	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Column(name = "created_date")
	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	@Column(name = "updated_date")
	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	@Column(name = "created_by")
	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	@Column(name = "updated_by")
	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	@Column(name = "obsolete")
	public String getObsolete() {
		return obsolete;
	}

	public void setObsolete(String obsolete) {
		this.obsolete = obsolete;
	}

	@Column(name = "active")
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	

}
