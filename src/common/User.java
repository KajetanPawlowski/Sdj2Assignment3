package common;

import java.io.Serializable;

public class User implements Serializable {
	String username;
	String ip;
	public User(String username, String ip) {
		this.username = username;
		this.ip = ip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
