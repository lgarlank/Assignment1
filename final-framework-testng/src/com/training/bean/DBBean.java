package com.training.bean;

/**
 * 
 * @author Naveen
 * @see this class shall get the bean data 
 */
public class DBBean {
	private String url; 
	private String driver; 
	private String userName; 
	private String password;
	private String name; 
	private String email; 
	private String subject; 
	private String message;
	
	public DBBean(){}
	
	public DBBean(String url, String driver, String userName, String password,String name, String email, String subject, String message) {
		super();
		this.url = url;
		this.driver = driver;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

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
	
	
	
	
}
