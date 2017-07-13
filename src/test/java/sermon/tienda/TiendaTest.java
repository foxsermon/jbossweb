package sermon.tienda;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import sermon.config.TiendaConfig;
import sermon.db.pojo.Offer;
import sermon.db.pojo.User;
import sermon.db.service.OfferService;
import sermon.db.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TiendaConfig.class})
@TransactionConfiguration(defaultRollback=false, transactionManager="transactionManager")
@Transactional
public class TiendaTest {

	@Autowired
	private UserService userService;
	@Autowired
	private OfferService offerService;
	
	@Test
	@Rollback(true)
	public void test() {
		List<User> users = userService.getUsers();
		assertNotNull("Objeto null", users);
	}
	@Test
	@Rollback(true)
	public void testOffers() {
		List<Offer> offers = offerService.getOffers();
		assertNotNull("Objeto null", offers);
	}
}
