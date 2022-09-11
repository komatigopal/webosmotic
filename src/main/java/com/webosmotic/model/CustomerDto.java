package com.webosmotic.model;

import java.util.HashSet;
import java.util.Set;

public class CustomerDto {

	private String userName;
	private String password;
	private String email;
	private long mobile;
	private String name;
	private Account account;
	private Set<Role> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		Set<Role> set = new HashSet<Role>();
		Role role = new Role();
		role.setName("USER_ROLE");
		role.setDescription("user operations");
		set.add(role);
		this.roles = set;
	}

	public Customer getUserFromDto() {
		Customer customer = new Customer(name, mobile, email, userName, password, roles, account);
		return customer;
	}

}