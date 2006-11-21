package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions;

public class UnknownCustomerException extends ResourceModelBuilderException {
	
	private String customerName;

	public UnknownCustomerException(String customerName) {
		this.customerName = customerName;
	}
	
	

	@Override
	public String getMessage() {
		return "Unknown customer: "+ customerName+"!";
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 9167765977227295984L;

}
