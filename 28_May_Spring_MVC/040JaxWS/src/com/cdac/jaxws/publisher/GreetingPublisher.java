package com.cdac.jaxws.publisher;
import javax.xml.ws.Endpoint;

import com.cdac.jaxws.service.Greeting;
import com.cdac.jaxws.service.GreetingImpl;
//Endpoint com.cdac.jaxws.publisher
public class GreetingPublisher{
 
	public static void main(String[] args) {
		Greeting g1 = new GreetingImpl();
	   Endpoint.publish("http://localhost:5555/ws/greet", g1);
	   System.out.println("Greeting Service Published. and Running now..."
	   		+ "waiting for the consumers......");
    }
 
}//http://localhost:5555/ws/greet?wsdl
//GreetingImplService