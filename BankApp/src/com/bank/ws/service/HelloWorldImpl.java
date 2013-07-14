package com.bank.ws.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.bank.ws.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHellowWorldAsString(String name) {
		
		return "Hello World from JAX-WS" + name;
	}

}
