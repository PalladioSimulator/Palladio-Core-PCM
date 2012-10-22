package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions;

public class UnknownResourceException extends ResourceModelBuilderException {
	
	private String serverName;

	public UnknownResourceException(String serverName) {
		this.serverName = serverName;
	}
	
	

	@Override
	public String getMessage() {
		return "Unknown Server: "+serverName+"!";
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = -2723812942199272826L;

	
}
