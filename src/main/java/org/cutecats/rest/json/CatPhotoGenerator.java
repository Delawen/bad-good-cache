package org.cutecats.rest.json;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class CatPhotoGenerator {

	private String[] photos = null;

	public String getCatURLImage() {

		String regex = "^(https?|ftps?|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		var pattern = Pattern.compile(regex);

		if (photos == null) {
			ArrayList<String> list = new ArrayList<>();
			try (InputStream in = this.getClass().getResourceAsStream("/photos.json")) {
				try (JsonReader jsonReader = Json.createReader(in)) {
					JsonArray array = jsonReader.readArray();
					for (int i = 0; i < array.size(); i++) {
						JsonObject object = array.get(i).asJsonObject();
						var potentialURL = object.getString("url");
						var matcher = pattern.matcher(potentialURL);
						if (matcher.matches()) {
							list.add(potentialURL);
						}
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			photos = list.toArray(new String[]{});
		}

		Random r = new Random();
		return photos[r.nextInt(0, photos.length - 1)];
	}

}
