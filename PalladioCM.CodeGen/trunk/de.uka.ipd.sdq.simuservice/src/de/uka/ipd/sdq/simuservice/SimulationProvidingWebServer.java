package de.uka.ipd.sdq.simuservice;

import javax.xml.ws.Endpoint;

/**
 * Creates a Web server that publishes an endpoint for the prediction-Web
 * service
 * 
 * @author brosch, heupel
 * 
 */
public class SimulationProvidingWebServer extends Thread {

	private final String ENDPOINT = "http://localhost:8080/services";

	@Override
	public void run() {

		System.out.println("Simulation web server is beeing started....");

		Endpoint.publish(ENDPOINT, new SimuService());

		System.out.println("Simulation web server: "
				+ SimuService.class.getName() + " published at " + ENDPOINT);
		System.out.println("Simulation web server: "
				+ SimuService.class.getName() + " ready");
	}

}
