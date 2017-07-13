package sermon.db.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sermon.db.pojo.User;
/**
 * User Row Mapper
 * @author mserrano
 *
 */
public class UserRowMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserName(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setEnabled(rs.getInt("enabled"));
		user.setEmail(rs.getString("email"));
		user.setAuthority(rs.getString("authority"));
		return user;
	}
}
