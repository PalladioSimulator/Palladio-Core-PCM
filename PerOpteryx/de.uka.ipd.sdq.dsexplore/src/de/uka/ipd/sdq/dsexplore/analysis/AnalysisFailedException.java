package de.uka.ipd.sdq.dsexplore.analysis;

public class AnalysisFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1276743034873996034L;

	/**
	 * @see Exception#Exception()
	 */
	public AnalysisFailedException() {
		super();
	}

	/**
	 * @see Exception#Exception(String, Throwable)
	 */
	public AnalysisFailedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @see Exception#Exception(String)
	 */
	public AnalysisFailedException(String arg0) {
		super(arg0);
	}

	/**
	 * @see Exception#Exception(Throwable)
	 */
	public AnalysisFailedException(Throwable arg0) {
		super(arg0);
	}
	
	

}
