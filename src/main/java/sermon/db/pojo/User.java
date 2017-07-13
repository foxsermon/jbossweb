package sermon.db.pojo;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -1424849743694966939L;
	
	private String userName;
	private String password;
	private String authority;
	private String name;
	private int enabled;
	private String email;
	
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "insert into users (username, authority, name, enabled, email) values ('" + userName + "', '" + authority
				+ "', '" + name + "', " + enabled + ", '"
				+ email + "')";
	}
}
