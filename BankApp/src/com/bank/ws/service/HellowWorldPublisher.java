package com.bank.ws.service;

import javax.xml.ws.Endpoint;

import com.bank.ws.service.HelloWorldImpl;

public class HellowWorldPublisher {
	public static void main(String args[]){
		Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
	}

}
