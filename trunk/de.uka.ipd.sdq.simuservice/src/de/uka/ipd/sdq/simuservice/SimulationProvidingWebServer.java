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

	/**
	 * The default port to use for the service in case config settings are not available.
	 */
	private final String DEFAULTPORT = "8082";

	/**
	 * Starts the SimuService.
	 */
	public void run() {
		
		// Determine the port where to publish the SimuService
		String port = ConfigurationHelper.getHelper().getPort();
		if(port == null) {
			port = DEFAULTPORT;
		}

		// Determine the service endpoint:
		String endpoint = "http://localhost:" + port + "/services";
		
		// Start the service:
		System.out.println("Simulation web server is being started....");
		Endpoint.publish(endpoint, new SimuService());
		System.out.println("Simulation web server: "
				+ SimuService.class.getName() + " published at " + endpoint);
		System.out.println("Simulation web server: "
				+ SimuService.class.getName() + " ready");
	}
}
