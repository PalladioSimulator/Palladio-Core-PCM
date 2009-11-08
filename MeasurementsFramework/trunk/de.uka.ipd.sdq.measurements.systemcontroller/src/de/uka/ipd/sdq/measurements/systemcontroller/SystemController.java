package de.uka.ipd.sdq.measurements.systemcontroller;


public class SystemController {
	
	public SystemController() {
		System.out.println("SystemController!");
	   RmiConnectionManager.getInstance().initializeHost("192.168.2.109", 2101, "Driver");
	}

	public void cleanup() {
		
	}
}
