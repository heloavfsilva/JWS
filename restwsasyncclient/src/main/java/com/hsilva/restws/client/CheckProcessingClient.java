package com.hsilva.restws.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.hsilva.restws.model.ChecksList;

public class CheckProcessingClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/restwsasync/services/checkprocessing/checks");
		AsyncInvoker invoker = target.request().async();

		ChecksList checksList = new ChecksList();
		Future<Boolean> response = invoker.post(Entity.entity(checksList, MediaType.APPLICATION_XML), Boolean.class);
		try {
			System.out.println(response.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}
