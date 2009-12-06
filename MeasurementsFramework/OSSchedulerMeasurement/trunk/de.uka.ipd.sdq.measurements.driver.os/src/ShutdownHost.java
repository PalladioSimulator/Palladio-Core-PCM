import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.driver.os.OSDriver;


public class ShutdownHost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String hostUrl = "192.168.2.177";
		int port = 2101;
		HostInterface hostInterface = null;
		try {
				System.out.println("Looking up driver on " + hostUrl + ":" + port);
			//masterInterface = Naming.lookup("rmi://" + masterURL + ":" + port + "/Master");
			Registry registry = LocateRegistry.getRegistry(hostUrl, port);
			hostInterface = (HostInterface) registry.lookup(Constants.DriverRMIName);
		} catch (NotBoundException e) {
			System.out.println(e.getMessage());
			return;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		boolean shutdownResult = false;
		if (hostInterface != null) {
			try {
				shutdownResult = hostInterface.shutdown();
			} catch (RemoteException e) {
				System.out.println(e.getMessage());
			}
		}
		if (shutdownResult == false) {
			System.out.println("Failed to shut down driver on " + hostUrl + ":" + port);
		} else {
			System.out.println("Shut down driver on " + hostUrl + ":" + port);
		}

	}

}
