package com.hsilva.restws;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import com.hsilva.restws.model.ChecksList;

@Path("/checkprocessing")
public interface CheckProcessor {

	@POST
	@Path("/checks")
	public void processChecks(@Suspended AsyncResponse response, ChecksList checksList);
	
	
	
}
