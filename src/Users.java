//package entity;

import java.lang.*;

public class Users{
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private int nid;
	private String type;

	public Users(){
		System.out.println("Empty-constructor");
	}
	public Users(int id,String userName,String password,String firstName,String lastName,int nid,String type){
		this.id=id;
		this.userName=userName;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.nid=nid;
		this.type=type;
	}
	public void setID(int id){
		this.id=id;
	}
	public void setName(String userName){
		this.userName=userName;
	}
	public void setPassword(String password){
		this.password=password;
	}

	public void setfirstName(String firstName){
		this.firstName=firstName;
	}

	public void setlastName(String lastName){
		this.lastName=lastName;
	}

	public void setnid(int nid){
		this.nid=nid;
	}

	public void setType(String type){
		this.type=type;
	}

	public int getid(){
		return id;
	}

	public String getuserName(){
		return userName;
	}


	public String getPassword(){
		return password;
	}

	public String getfirstName(){
		return firstName;
	}

	public String getlastName(){
		return lastName;
	}

	public int getnid(){
		return nid;
	}

	public String getType(){
		return type;
	}

}