package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions;

public class WrongBuilderException extends ResourceModelBuilderException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4215037719779982409L;
	
	private String expectedBuilder = "";

	public WrongBuilderException(String expectedBuilder) {
		super();
		this.expectedBuilder = expectedBuilder;
	}

	@Override
	public String getMessage() {
		return "Wrong Builder! Expected was: "+expectedBuilder;
	}
	

}
