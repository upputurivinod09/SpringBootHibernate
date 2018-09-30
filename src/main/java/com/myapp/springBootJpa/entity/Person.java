package com.myapp.springBootJpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	private Date date;
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Person(String name, String location, Date date) {
		super();
		this.name = name;
		this.location = location;
		this.date = date;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", date=" + date + "]";
	}
	
}
