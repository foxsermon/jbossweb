package sermon.utils;


import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 *
 *  @autor mserrano
 *  @since May 11, 2015 3:53:23 PM
 */
public class PingInfo {

	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss a");


	private Date time = Calendar.getInstance().getTime();
	
	private String dbStatus = "";

	public String getTime() {
		return formatter.format(time);
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDbStatus() {
		return dbStatus;
	}

	public void setDbStatus(String dbStatus) {
		this.dbStatus = dbStatus;
	}
	
}
