package com.hsilva.ws.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.hsilva.ws.rest.model.Patient;

@Path("/patientservice")
public interface PatientService {

	@GET
	@Path("/patients")
	List<Patient> getPatients();
	
	@GET
	@Path("/patients/{id}")
	Patient getPatient(@PathParam(value="id") Long id);
	
	@POST
	@Path("/patients")
	Response createPatient(Patient patient);
	
	@PUT
	@Path("/patients")
	Response updatePatient(Patient patient);
	
	@DELETE
	@Path("/patients/{id}")
	Response deletePatient(@PathParam(value="id") Long id);
	
}
