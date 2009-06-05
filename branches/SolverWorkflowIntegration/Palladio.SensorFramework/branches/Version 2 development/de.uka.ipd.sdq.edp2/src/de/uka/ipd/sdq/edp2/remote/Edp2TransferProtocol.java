/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote;

/**Net4J protocol to transfer Edp2 data.
 * @author groenda
 */
public interface Edp2TransferProtocol {
	/** Protocol identifier. */
	public final String PROTOCOL_NAME = "EDP2 Transfer Protocol 0.0.1";

	/** Signal to create a list of all known experiment groups and transfer 
	 * them back to the client.*/
	public static final short LIST_EXPERIMENT_GROUPS_SIGNAL = 1;
	/**Signal to transfer an experiment group (given its uuid). */
	public static final short TRANSFER_EXPERIMENT_GROUP_SIGNAL = 2;
	/**Signal to transfer a NominalMeasurements (given its uuid). */
	public static final short TRANSFER_NOMINAL_MEASUREMENTS_SIGNAL = 3;
	/**Signal to transfer a DoubleBinaryMeasurements (given its uuid). */
	public static final short TRANSFER_DOUBLE_BINARY_MEASUREMENTS_SIGNAL = 4;
	/**Signal to transfer a LongBinaryMeasurements (given its uuid). */
	public static final short TRANSFER_LONG_BINARY_MEASUREMENTS_SIGNAL = 5;
	/**Signal to transfer a Descriptions (given their uuid). */
	public static final short TRANSFER_DESCRIPTIONS_SIGNAL = 6;
}
