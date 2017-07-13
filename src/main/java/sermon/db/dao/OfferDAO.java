package sermon.db.dao;

import org.springframework.stereotype.Repository;

import sermon.db.generic.dao.impl.GenericDAOImpl;
import sermon.db.pojo.Offer;

@Repository
public class OfferDAO extends GenericDAOImpl<Offer>{
	@Override
	public String imprime() {
		return "OfferDAO Class";
	}
}
