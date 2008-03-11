package de.uka.ipd.sdq.palladiofileshare.testdriver;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.BusinessFacade;

public class TestDriver {

	private BusinessFacade businessFacade;
	
	public TestDriver() {
		businessFacade = new BusinessFacade();
	}
	
	public static void main(String args) {
		new TestDriver().start();		
	}
	
	
	public void start() {
		businessFacade.uploadFile(null, null);
	}
	
}
