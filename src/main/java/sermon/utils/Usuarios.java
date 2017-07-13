package sermon.utils;

import java.util.List;

/**
 *
 *  @autor mserrano
 *  @since May 12, 2015 3:47:41 PM
 */
public class Usuarios {
	private String username;
	private String authority;
	private String name;
	private boolean enabled;
	private String email;
	private List<Offer> offers;
	
	public Usuarios(final String username, final String authority, final String name, final boolean enabled, final String email) {
		this.username = username;
		this.authority = authority;
		this.name = name;
		this.enabled = enabled;
		this.email = email;
	}
	
	public Usuarios() {
		// TODO Auto-generated constructor stub
	}

	public class Offer {
		private Integer offerId;
		private String text;
		
		public Offer(final Integer id, final String txt) {
			this.offerId = id;
			this.text = txt;
		}
		
		public Integer getOfferId() {
			return offerId;
		}
		public void setOfferId(Integer offerId) {
			this.offerId = offerId;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
}
