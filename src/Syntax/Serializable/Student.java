package Syntax.Serializable;

import java.io.*;

public class Student implements Serializable{
    String name;
	int id;
    String address;
    transient int age;
	
	public Student(int id, String name, String add) {
		this.id = id;
		this.name = name;
		this.address = add;
	}
	public int getID() {return id;}
	public String getName() {return name;}
    public String getAddress() {return address;}
}