package sermon.db.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sermon.db.generic.dao.GenericDAO;
import sermon.db.pojo.User;
import sermon.db.rowmappers.UserRowMapper;
/**
 * User Service
 * @author mserrano
 *
 */
@Transactional
@Service
@SuppressWarnings({"rawtypes", "unchecked"})
public class UserService {
	
	@Autowired
	@Qualifier("userDAO")
	private GenericDAO userDAO;
	/**
	 * Returns Users
	 * @return List<User>
	 */
	@Cacheable(value="usuarios")
	public List<User> getUsers() {
		return userDAO.getAll("users", new UserRowMapper());
	}
	/**
	 * Return User Object
	 * @param username
	 * @return User
	 */
	public User getUser(String username) {
		return (User) userDAO.find("users", "username", "'" + username + "'", new UserRowMapper());
	}
	/**
	 * Check DB Connection
	 * @return boolean
	 */
	public boolean checkDBConnection() {
		return userDAO.checkDBConnection();
	}
	
	public User getUserError() {
		Random ran = new Random();
		int x = ran.nextInt(13);
		if (x % 2 == 0) {
			throw new NullPointerException("Error generado para Takipi - User Error");
		}
		return null;
	}
}
