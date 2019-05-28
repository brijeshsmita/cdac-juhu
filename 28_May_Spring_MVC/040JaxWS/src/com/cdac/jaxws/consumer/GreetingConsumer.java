/**
 * 
 */
package com.cdac.jaxws.consumer;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.cdac.jaxws.service.Greeting;
/**
 * @author Smita
 *service name in wsdl = GreetingImplService
 *soap:address location="http://localhost:5555/ws/greet?wsdl"
 *namespace or fully qualified path of publised service 
 *	- http://service.jaxws.syntel.com/
 */
public class GreetingConsumer {
	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		// service name = GreetingImplService
		//uri http://service.jaxws.cdac.com/		
		//url = published name of service and 
		//wsdlUrl http://localhost:5555/ws/greet?wsdl
		URL wsdlUrl = new URL("http://localhost:5555/ws/greet?wsdl");
//1st argument service URI, refer to wsdl document above
	    //2nd argument is service name, refer to wsdl document above
        QName endPointName = 
        new QName("http://service.jaxws.cdac.com/", "GreetingImplService"); 
        Service service = Service.create(wsdlUrl, endPointName);
        //proxy object for published service by passing wsdl  and Qname
        Greeting greetObj = service.getPort(Greeting.class);
        //greetingService object 
        System.out.println(greetObj.getGreetingAsString("Smita"));
 //calling the actual method
	}

}
