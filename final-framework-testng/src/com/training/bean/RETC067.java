package com.training.bean;

public class RETC067 {

	private String name;
	private String email;
	private String subject;
	private String message;

	public RETC067() {
	}

	public RETC067(String name, String email, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getsubject() {
		return subject;
	}

	public void setsubject(String subject) {
		this.subject = subject;
	}

	public String getmessage() {
		return message;
	}

	public void setmessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "RETC067 [name=" + name + ", email=" + email + ",subject=" + subject + ", message=" + message + "]";
	}

}
