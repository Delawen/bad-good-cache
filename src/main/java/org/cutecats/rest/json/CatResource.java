package org.cutecats.rest.json;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

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
	public Cat newRandomCat(@QueryParam("test") @DefaultValue("true") Boolean test) {
		String url;
		if(test) {
			url = (new DummyPhotoGenerator()).getURLImage();
		} else {
			url = (new CatPhotoGenerator()).getCatURLImage();
		}
		return new Cat(catNameGenerator.getName(), url);
	}

	@POST
	public Set<Cat> add(Cat cat) {
		cats.add(cat);
		return cats;
	}

}
