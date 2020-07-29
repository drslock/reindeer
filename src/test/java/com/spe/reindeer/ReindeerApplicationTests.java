package com.spe.reindeer;

import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReindeerApplicationTests {

	@Autowired
	ReindeerApplication app;

	@Test
	void contextLoads() {
		assertTrue(app.isValidName("Donner"), "Check 'Donner' is valid");
		//		assertTrue(app.isValidName("Rudolph"), "Check 'Rudolph' is valid");
		try {
			URL url = new URL("https://nominatim.openstreetmap.org/search?postalcode=BS8+1UB&format=geocodejson");
			HttpURLConnection connection =(HttpURLConnection)url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
			JSONParser parser = new JSONParser();
			JSONObject document = (JSONObject)parser.parse(reader);
			System.out.print(document);

			// Check that the geocoding actually finds the right location
			JSONArray features = (JSONArray)document.get("features");
			JSONObject geometry = (JSONObject)((JSONObject)features.get(0)).get("geometry");
			JSONArray coordinates = (JSONArray)geometry.get("coordinates");
			assertEquals(Math.round((double)coordinates.get(0)), 3, "Check lat is approx -3");
			assertEquals(Math.round((double)coordinates.get(1)), 51, "Check lon is approx 51");
		} catch(MalformedURLException mue) {
		} catch(ParseException mue) {
		} catch(IOException ioe) {
		}
	}

}
