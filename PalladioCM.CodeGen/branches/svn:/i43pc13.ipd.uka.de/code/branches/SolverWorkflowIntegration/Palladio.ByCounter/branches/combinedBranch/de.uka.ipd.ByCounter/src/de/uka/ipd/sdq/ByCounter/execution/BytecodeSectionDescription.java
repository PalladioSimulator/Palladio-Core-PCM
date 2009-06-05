package de.uka.ipd.sdq.ByCounter.execution;


/**
 * A small class to describe bytecode sections (for partial instrumentation).
 * TODO why isn't it used anywhere?
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
class BytecodeSectionDescription {
	/**
	 * TODO
	 */
	public static final int DESCRIBED_BY_LINE_NUMBERS = 1;
	
	/**
	 * TODO
	 */
	public int describedBy;

	/**
	 * TODO
	 */
	public int endingLineNr_incl;
	
	/**
	 * TODO
	 */
	public int startingLineNr_incl;
	
	public String toString(){
		return "BytecodeSectionDescription" +
				"["+startingLineNr_incl+"-"+endingLineNr_incl+"]";
	}
	
}
