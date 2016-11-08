package com.zjh.po;

/**
 * Multipk entity. @author MyEclipse Persistence Tools
 */

public class Multipk implements java.io.Serializable {

	// Fields

	private MultipkId id;
	private String password;

	// Constructors

	/** default constructor */
	public Multipk() {
	}

	/** minimal constructor */
	public Multipk(MultipkId id) {
		this.id = id;
	}

	/** full constructor */
	public Multipk(MultipkId id, String password) {
		this.id = id;
		this.password = password;
	}

	// Property accessors

	public MultipkId getId() {
		return this.id;
	}

	public void setId(MultipkId id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}