package SearchAPI;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
import javax.net.ssl.HttpsURLConnection;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ITunesSearchAPITest5 {

	@Test
	public void searchValidTerm()
	{
		sendSearchRequest("term=all&25");
		//TODO - Implement JSON response validation.
				
	}
	
	//TODO Ideally we should return a JSON Object for proper validation.
	public String sendSearchRequest(String searchkeys)
	{
		try
		{
		String url = "https://itunes.apple.com/search?"+searchkeys;
		 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		return(response.toString());
		//TODO Ideally we should return a JSON Object for proper validation.
 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}

}
