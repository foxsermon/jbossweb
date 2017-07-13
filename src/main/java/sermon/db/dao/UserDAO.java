package sermon.db.dao;

import org.springframework.stereotype.Repository;

import sermon.db.generic.dao.impl.GenericDAOImpl;
import sermon.db.pojo.User;

@Repository
public class UserDAO extends GenericDAOImpl<User> {
	@Override
	public String imprime() {
		return "UserDAO Class";
	}
}
