package org.cutecats.rest.json;


import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CatPhotoGenerator {

	private String[] backup = new String[]{
			"https://upload.wikimedia.org/wikipedia/commons/6/69/June_odd-eyed-cat_cropped.jpg",
			"https://upload.wikimedia.org/wikipedia/commons/4/4d/Cat_November_2010-1a.jpg",
			"https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Cat_Sphynx._Kittens._img_11.jpg/640px-Cat_Sphynx._Kittens._img_11.jpg",
			"https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Domestic_cat_felis_catus_stare.jpg/640px-Domestic_cat_felis_catus_stare.jpg"};
	private int backupi = 0;

	public String getCatURLImage() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader((new URL("https://api.thecatapi.com/v1/images/search")).openStream()))) {
			try (JsonReader jsonReader = Json.createReader(in)) {
				JsonArray array = jsonReader.readArray();
				JsonObject object = array.get(0).asJsonObject();
				return object.getString("url");
			}
		} catch (IOException e) {
			if (backupi > backup.length - 1) {
				backupi = 0;
			}
			return backup[backupi++];
		}

	}

}
