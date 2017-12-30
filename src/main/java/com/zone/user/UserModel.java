package com.zone.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.zone.role.RoleModel;

@Entity
@Table(name = "tbl_user")
public class UserModel {

		private int client_id;
		private int user_id;
		private int role_id;
		private String name;
		private String username;
		private String password;
		private String email;
		private String mobileno;
		private String created_date;
		private String updated_date;
		private int created_user;
		private int updated_user;
		private String obsolete;
		private String active;
		
		public UserModel(){
			
		}
		
		@Column(name = "client_id")
		public int getClient_id() {
			return client_id;
		}

		public void setClient_id(int client_id) {
			this.client_id = client_id;
		}

		@Id
		@Column(name = "user_id")
		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		
		public RoleModel role;
		@JoinColumn(name = "role_id")
		@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE )
		public RoleModel getRole_id() {
			return role;
		}

		public void setRole_id(RoleModel role) {
			this.role = role;
		}

		@Column(name = "name")
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Column(name = "username")
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
		
		
		@Column(name ="email")
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
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
		
		@Column(name="updated_date")
		public String getUpdated_date() {
			return updated_date;
		}

		public void setUpdated_date(String updated_date) {
			this.updated_date = updated_date;
		}
		
		@Column(name = "created_user")
		public int getCreated_user() {
			return created_user;
		}

		public void setCreated_user(int created_user) {
			this.created_user = created_user;
		}
		
		@Column(name ="updated_user")
		public int getUpdated_user() {
			return updated_user;
		}

		public void setUpdated_user(int updated_user) {
			this.updated_user = updated_user;
		}

		@Column(name = "password")
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Column(name="obsolete")
		public String getObsolete() {
			return obsolete;
		}

		public void setObsolete(String obsolete) {
			this.obsolete = obsolete;
		}

		@Column(name="active")
		public String getActive() {
			return active;
		}

		public void setActive(String active) {
			this.active = active;
		}
		
		
}
