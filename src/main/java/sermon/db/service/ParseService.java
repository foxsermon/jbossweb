package sermon.db.service;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sermon.utils.Constantes;

/**
 *
 *  @autor mserrano
 *  @since Jul 20, 2015 12:18:42 AM
 */
@Transactional
@Service
public class ParseService {
	
	public boolean enviaMensaje(final String msg){
		Parse.initialize(Constantes.APPLICATION_ID, null);

		//ParseObject tienda = new ParseObject("UltimasNoticias");
		String[] channels = new String[]{};
		// android, ios
	    String type = null;
	    Map<String, String> data = new HashMap<String, String>();
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	    data.put("alert", msg + "\n" + dateFormatter.format(Calendar.getInstance().getTime()));
	    data.put("appName", "MyParse");

	    try {
	        sendPost(channels, type, data);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }			
		return true;
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
	    HttpPost httpost = new HttpPost(Constantes.PUSH_URL); 
	    httpost.addHeader("X-Parse-Application-Id", Constantes.APPLICATION_ID);
	    httpost.addHeader("X-Parse-Master-Key", Constantes.MASTER_API_KEY);
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
