package sermon.db.pojo;

import java.io.Serializable;

public class Offer implements Serializable {

	private static final long serialVersionUID = -8453145489937422994L;
	private Integer id;
	private String text;
	private String username;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		String sql = null;
		if (this.id == -1) {
			sql = "insert into offers (text, username) values ('" + text + "', '" + username + "')";
		}else {
			sql = "update offers set text = '" + text + "' where id = " + id;
		}
		return sql;
	}
}
