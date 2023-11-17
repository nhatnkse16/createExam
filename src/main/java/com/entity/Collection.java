/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author quoct
 */
public class Collection {

    private int id;
    private String name;
    private int examNumber;
    private int accountID;

    public Collection() {
    }

	public Collection(int id, String name, int examNumber, int accountID) {
		super();
		this.id = id;
		this.name = name;
		this.examNumber = examNumber;
		this.accountID = accountID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExamNumber() {
		return examNumber;
	}

	public void setExamNumber(int examNumber) {
		this.examNumber = examNumber;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	@Override
	public String toString() {
		return "Collection [id=" + id + ", name=" + name + ", examNumber=" + examNumber + ", accountID=" + accountID
				+ "]";
	}
}
