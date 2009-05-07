package de.uka.ipd.sdq.BySuite.interfaces;

public interface ISimpleCountingResult {
	final int NO_COUNT_AVAILABLE = -1;
	
//	/**
//	 * Simple getter for input file type.
//	 * For SPECjvm2008, we are using the constants from compress.Harness:
//	 *     public static final int DATA_TYPE_COMPRESSED=3;
//     *     public static final int DATA_TYPE_MIXED=2;
//     *     public static final int DATA_TYPE_UNCOMPRESSED=1;
//	 *     public static final int DATA_TYPE_UNKNOWN=0;//
//	 * @return
//	 */
//	public int getFileType();
//	
	/**
	 * For example, for SPECjvm2008.Compress, this is the size of the input file (in bytes)
	 * @return
	 */
	public long getInputCharacterisation();
	
	/**
	 * TODO
	 * @param methodName
	 * @return
	 */
	public Long getMethodCount(String methodName);
	
	/**
	 * TODO
	 * @return
	 */
	public Long getOpcodeCount(int opcode);
	
	/**
	 * TODO
	 * @return
	 */
	public Long getOpcodeCount(String opcode);
	
	/**
	 * For example, for SPECjvm2008.Compress, this is the size of the 
	 * buffer which holds the compressed data of the input file
	 * @return
	 */
	public long getOutputCharacterisation();	

	/**
	 * TODO
	 * @param includeInvokeOpcodes
	 * @return
	 */
	public Long getTotalOpcodeCount(boolean includeInvokeOpcodes);

	/**
	 * Set counted BCs for a opcode-specified BC
	 * @param opcode
	 * @param count
	 */
	public void setOpcodeCount(int opcode, Long count);

}
