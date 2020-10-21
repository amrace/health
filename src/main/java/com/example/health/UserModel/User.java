package com.example.health.UserModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userName;
	
	private String address;
	
	private String phone;

	private String email;
	
	private String password;
	
	private String role;
	
	//it helps to enable and disbale user sometimes
    @Column(name="enabled",columnDefinition = "tinyint(1)")
	private boolean enabled;
	
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable( name= "users_roles", joinColumns = @JoinColumn(name="user_id"),
	 * inverseJoinColumns = @JoinColumn(name="role_id")
	 * 
	 * ) private Set<Role> roles =new HashSet<>();
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", address=" + address + ", phone=" + phone + ", email="
				+ email + ", password=" + password + ", role=" + role + ", enabled=" + enabled + "]";
	}
	
	

	/*
	 * public Set<Role> getRoles() { return roles; }
	 * 
	 * public void setRoles(Set<Role> roles) { this.roles = roles; }
	 */
	
	
}
