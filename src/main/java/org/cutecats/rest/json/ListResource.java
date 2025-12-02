package org.cutecats.rest.json;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.Set;

@Path("/list")
public class ListResource {
	@Inject
	CatStorage cats;

	public ListResource() {
	}

	@GET
	public Set<Cat> list() {
		return cats;
	}

}
