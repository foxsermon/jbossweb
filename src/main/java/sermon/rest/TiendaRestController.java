package sermon.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.el.MethodNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sermon.db.pojo.Offer;
import sermon.db.pojo.User;
import sermon.db.service.OfferService;
import sermon.db.service.ParseService;
import sermon.db.service.UserService;
import sermon.response.ResponseStatus;
import sermon.utils.Constantes;
import sermon.utils.PingInfo;
import sermon.utils.Usuarios;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiErrors;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 *
 *  @autor mserrano
 *  @since May 11, 2015 3:52:10 PM
 */
@Controller("app")
@Api(value="Tienda Rest Controller", description="Describe los Restful Services.")
public class TiendaRestController {

	@Autowired
	private UserService userService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private ParseService parseService;
	
	@RequestMapping(value="/ping", method = RequestMethod.GET)
	@ApiOperation(value="Ping server")
	@ApiErrors(value = {@ApiError(code=500, reason = "DB is down for unknown reason.")})
	public @ResponseBody PingInfo ping() {
		PingInfo ping = new PingInfo();
		ping.setDbStatus("db " + (userService.checkDBConnection() ? "active" : "inactive"));
		return ping;
	}
	
	@RequestMapping(value="/usuarios", method = RequestMethod.GET)
	@ApiOperation(value="Lista usuarios.")
	@ApiErrors(value = {@ApiError(code=404, reason = "Service down for unknow reason"),
			@ApiError(code=500, reason = "DB is down for unknown reason.")})
	public @ResponseBody List<Usuarios> usuarios() {
		
		List<Usuarios> usurs = new ArrayList<Usuarios>();
		List<User> users = userService.getUsers();
		for (User user: users) {
			Usuarios usr = new Usuarios(user.getUserName(), user.getAuthority(), user.getName(), user.getEnabled() == 1 ? true : false, user.getEmail());
			List<Offer> offers = offerService.getOffer(user.getUserName());
			List<Usuarios.Offer> usrOffers = new ArrayList<Usuarios.Offer>();
			for (Offer offer: offers) {
				Usuarios.Offer usrOff = new Usuarios().new Offer(offer.getId(), offer.getText());
				usrOffers.add(usrOff);
			}
			usr.setOffers(usrOffers);
			usurs.add(usr);
		}
		return usurs;
	}
	
	@RequestMapping(value="/usuario/{userId}", method = RequestMethod.GET)
	@ApiOperation(value="Obtiene solo un usuario")
	@ApiErrors(value = {@ApiError(code=404, reason = "Service down for unknow reason"),
			@ApiError(code=500, reason = "DB is down for unknown reason.")})
	public @ResponseBody Usuarios usuario(
				@ApiParam(required = true, name = "userId", value = "User ID to look for.")
				@PathVariable("userId") final int userId) {
		Usuarios usr = new Usuarios();
		return usr;
	}
	
	@RequestMapping(value="/lanzaError", method = RequestMethod.GET)
	@ApiOperation(value="Lanza error aleatorio para Takipi.")
	@ApiErrors(value = {@ApiError(code=404, reason = "Service down for unknow reason"),
			@ApiError(code=500, reason = "DB is down for unknown reason.")})
	public @ResponseBody void lanzaError() {
		Random ran = new Random();
		int x = ran.nextInt(13);
		User user = userService.getUserError();
		String email = user.getEmail();
		if (x % 2 == 0) {
			throw new NullPointerException("Error generado para Takipi");
		}else {
			throw new MethodNotFoundException("Error generado para Takipi");
		}
	}
	
	@RequestMapping(value="/mensaje/{msg}", method = RequestMethod.POST)
	@ApiOperation(value="Envia un mensaje por PARSE.com")
	@ApiErrors(value = {@ApiError(code=404, reason = "Service down for unknow reason"),
			@ApiError(code=500, reason = "DB is down for unknown reason.")})
	public @ResponseBody ResponseStatus enviaMensaje(
			@ApiParam(required = true, name = "msg", value = "Mensaje a enviar.")
			@PathVariable("msg") final String msg) {
		ResponseStatus status = new ResponseStatus();
		if (msg.trim().length() == 0 || msg.trim().length() <= 13
				|| ! msg.trim().substring(0, 13).equalsIgnoreCase(Constantes.LLAVE)) {
			status.setCode(-1);
			status.setMessage("Datos invalidos");
		}else {
			boolean result = parseService.enviaMensaje(msg.replaceAll(Constantes.LLAVE, ""));
			if (result) {
				status.setCode(0);
				status.setMessage("Mensaje enviado");
			}else {
				status.setCode(-1);
				status.setMessage("Error al enviar datos");
			}
		}
		return status;
	}
}
