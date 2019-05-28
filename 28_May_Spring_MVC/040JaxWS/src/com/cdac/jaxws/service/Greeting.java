package com.cdac.jaxws.service;//soap webservice using JAX-WS
import javax.jws.WebService;
import javax.jws.WebMethod;

import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
//Service Endpoint Interface
//step 1: annotate enpoint service interface as @WebService
@WebService
//step 2: @SOAPBinding and use style attribute (DOCUMENT or RPC)
@SOAPBinding(style = Style.RPC)//document style is Remote Procedure Call
//wsdl document style is of RPC
public interface Greeting{
	//step 3: annotate every service method as @WebMethod 
	@WebMethod 
	String getGreetingAsString(String name);
 
}