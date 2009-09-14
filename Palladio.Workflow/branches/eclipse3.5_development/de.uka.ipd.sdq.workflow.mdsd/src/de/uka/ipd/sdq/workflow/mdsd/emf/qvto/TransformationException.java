package de.uka.ipd.sdq.workflow.mdsd.emf.qvto;

public class TransformationException extends Exception {
	private static final long serialVersionUID = -3858759755796489494L;
	public TransformationException(String msg, Exception e) {
		super(msg, e);
	}
	public TransformationException(String msg) {
		super(msg);
	}
}