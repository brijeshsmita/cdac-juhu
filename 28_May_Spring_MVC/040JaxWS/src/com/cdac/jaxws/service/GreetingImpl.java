package com.cdac.jaxws.service;

import javax.jws.WebService;

//Service Implementation
//Step 4: Service Implementation class will be bind using
//endpointInteface attribute of @WebService annotation
@WebService(endpointInterface = "com.cdac.jaxws.service.Greeting")
public class GreetingImpl implements Greeting{

	@Override
	public String getGreetingAsString(String name) {
		return "Hello From JAX-WS ...." + name;
	}

}