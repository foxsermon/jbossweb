package sermon.parse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.parse4j.Parse;

/**
 *
 *  @autor mserrano
 *  @since Jul 5, 2015 7:49:31 PM
 */
public class ParseTest {
    /*
	private static final String APPLICATION_ID = "";
	private static final String REST_API_KEY = "";
	private static final String PUSH_URL = "https://api.parse.com/1/push";
	*/
    private static final String APPLICATION_ID = "";
    private static final String MASTER_API_KEY = "";
    private static final String PUSH_URL = "http://69.61.93.57:1337/parse/push";
    
	public static void main(String[] args) {
		Parse.initialize(APPLICATION_ID, null);

		//ParseObject tienda = new ParseObject("UltimasNoticias");
		/*
		try {
			tienda.put("titulo", "Own-MailBox: correo 100% confidencial");
			tienda.put("link", "http://www.taringa.net/posts/linux/18766629/Own-MailBox-correo-100-confidencial.html");
			tienda.put("imageLink", "http://t3.kn3.net/taringa/7/2/C/1/1/A/HZ/98x73_6E1.jpg");
			
			tienda.save();
			
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		*/
		String[] channels = new String[]{};
		// android, ios
	    String type = null;
	    Map<String, String> data = new HashMap<String, String>();
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	    data.put("alert", "push data test " + dateFormatter.format(Calendar.getInstance().getTime()));
	    data.put("appName", "MyParse");

	    try {
	        new ParseTest().sendPost(channels, type, data);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }			
		
		System.out.println("Completed");
	}
	
	private void sendPost(String[] channels, String type, Map<String, String> data) throws Exception {
	    JSONObject jo = new JSONObject();
	    jo.put("where", channels);
	    if(type != null) {
	        //??type?????android?ios???
	        jo.put("type", type);
	    }
	    jo.put("data", data);

	    this.pushData(jo.toString());
	}

	private void pushData(String postData) throws Exception {
	    DefaultHttpClient httpclient = new DefaultHttpClient();
	    HttpResponse response = null;
	    HttpEntity entity = null;
	    String responseString = null;
	    HttpPost httpost = new HttpPost(PUSH_URL); 
	    httpost.addHeader("X-Parse-Application-Id", APPLICATION_ID);
	    httpost.addHeader("X-Parse-Master-Key", MASTER_API_KEY);
	    httpost.addHeader("Content-Type", "application/json");
	    StringEntity reqEntity = new StringEntity(postData);
	    httpost.setEntity(reqEntity);
	    response = httpclient.execute(httpost);
	    entity = response.getEntity();
	    if (entity != null) {
	         responseString = EntityUtils.toString(response.getEntity());  
	    }

	    System.out.println(responseString);
	}

}
