package de.uka.ipd.sdq.simuservice;

import javax.xml.ws.Endpoint;


/**
 * Creates a Web server that publishes an endpoint for the prediction-Web service
 * @author brosch, heupel
 *
 */
public class SimulationProvidingWebServer extends Thread {

	@Override
	public void run() {
		System.out.println("Server is beeing started....");
		
		//Start server + publish Web service under specified address (AND ONLY THERE)
		Endpoint endpoint = Endpoint.publish( "http://localhost:8080/services",
                new SimuService() ); 
		
		System.out.println("Server started - you should now be able to acces the webservice");
		
		
	}
	
}
