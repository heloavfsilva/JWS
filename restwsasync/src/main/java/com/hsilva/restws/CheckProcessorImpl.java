package com.hsilva.restws;


import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import com.hsilva.restws.model.ChecksList;

@Service
public class CheckProcessorImpl implements CheckProcessor {

	@Override
	public void processChecks(AsyncResponse response, ChecksList checksList) {
		//logic
		new Thread() {
			public void run() {
				response.resume(true);
			}
		}.start();
		
	}


}
