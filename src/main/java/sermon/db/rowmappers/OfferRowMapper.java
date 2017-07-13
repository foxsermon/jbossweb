package sermon.db.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sermon.db.pojo.Offer;

/**
 *
 *  @autor mserrano
 *  @since Jan 23, 2015 2:54:14 PM
 */
public class OfferRowMapper implements RowMapper<Offer> {
	
	@Override
	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Offer offer = new Offer();
		offer.setId(rs.getInt("id"));
		offer.setUsername(rs.getString("username"));
		offer.setText(rs.getString("text"));
		return offer;
	}
}
