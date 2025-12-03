package org.cutecats.rest.json;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.Set;

@Path("/cats")
public class CatResource {

	@Inject
	CatStorage cats;

	@Inject
	CatNameGenerator catNameGenerator;

	public CatResource() {
	}

	@GET
	public Cat newRandomCat() {
		return new Cat(catNameGenerator.getName(), (new CatPhotoGenerator()).getCatURLImage());
	}

	@POST
	public Set<Cat> add(Cat cat) {
		cats.add(cat);
		return cats;
	}

}
