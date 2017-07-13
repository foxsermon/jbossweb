package sermon.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sermon.db.generic.dao.GenericDAO;
import sermon.db.pojo.Offer;
import sermon.db.rowmappers.OfferRowMapper;

/**
 *
 *  @autor mserrano
 *  @since Jan 23, 2015 2:56:09 PM
 */
@Transactional
@Service
@SuppressWarnings({"rawtypes", "unchecked"})
public class OfferService {
	
	@Autowired	
	@Qualifier("offerDAO")
	private GenericDAO offerDAO;
	/**Ø
	 * Returns Offers
	 * @return
	 */
	@Cacheable(value="offers")
	public List<Offer> getOffers() {
		return offerDAO.getAll("offers", new OfferRowMapper());
	}
	@Cacheable(value="offerByUser", key="#username")
	public List<Offer> getOffer(String username) {
		return offerDAO.getByField("offers", "username", "'" + username + "'", new OfferRowMapper());
	}
	@Cacheable(value="offerById", key="#id")
	public Offer getOffer(Integer id) {
		return (Offer) offerDAO.find("offers", "id", id, new OfferRowMapper());
	}
	
	public boolean saveOffer(Offer offer) throws Exception {
		return offerDAO.save(offer);
	}
}
