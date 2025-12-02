package org.cutecats.rest.json;

import jakarta.enterprise.context.Dependent;

import java.util.Random;

@Dependent
public class CatNameGenerator {

	public CatNameGenerator() {
	}

	private String[] title = new String[]{
			"Miss",
			"Lady",
			"Princess",
			"Magnanimous"
	};

	private String[] name = new String[]{
			"Cookie",
			"Bubble",
			"Bagel",
			"Catticus",
			"Meatball",
			"Meowtini",
			"Pistacho",
			"Kit-Kat",
			"Flufferton"
	};

	private String[] adjective = new String[]{
			"",
			"",
			"",
			"",
			"",
			"Furrbilly",
			"Spotted",
			"Sparkly",
			"Dotty",
			"Glamoury",
			"Giant",
			"Tiny",
			"Smol"
	};
	private Random index = new Random();

	public String getName() {

		return title[index.nextInt(0, title.length)] + " "
				+ adjective[index.nextInt(0, adjective.length)] + " "
				+ name[index.nextInt(0, name.length)];


	}

}
