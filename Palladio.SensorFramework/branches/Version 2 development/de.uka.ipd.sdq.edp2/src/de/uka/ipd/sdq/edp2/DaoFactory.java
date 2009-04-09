/**
 * 
 */
package de.uka.ipd.sdq.edp2;

/**Factory for creating DataAccessObjects (DAO) of edp2.
 * This allows to access measured data as well as metadata.
 * @author groenda
 */
public interface DaoFactory {
	// Creating DAOs
	
	/**Creates a DAO to access experiment groups.
	 * @param uuid UUID of the experiment group.
	 * @return DAO for the (root) model element experiment group.
	 */
	public ExperimentGroupDao createExperimentGroupDao(String uuid);
	
	/**Creates a DAO to access measured data of type double.
	 * @param uuid UUID of the Measurement.
	 * @return DAO for the measurements with the specified uuid.
	 */
	public BinaryMeasurementsDao<Double> createDoubleMeasurementsDao(String uuid);

	/**Creates a DAO to access measured data of type long.
	 * @param uuid UUID of the Measurement.
	 * @return DAO for the measurements with the specified uuid.
	 */
	public BinaryMeasurementsDao<Long> createLongMeasurementsDao(String uuid);

	/**Creates a DAO to access measured data of type nominal measurement.
	 * @param uuid UUID of the Measurement.
	 * @return DAO for the measurements with the specified uuid.
	 */
	public NominalMeasurementsDao createNominalMeasurementsDao(String uuid);

	/**Creates a DAO to access measured data of type nominal measurement.
	 * @param uuid UUID of the Measurement.
	 * @return DAO for the measurements with the specified uuid.
	 */
	public JScienceXmlMeasurementsDao createJScienceXmlMeasurementsDao(String uuid);

	/**Creates a DAO to access descriptions.
	 * @param uuid UUID of the Descriptions.
	 * @return DAO for the measurements with the specified uuid.
	 */
	public DescriptionsDao createDescriptionsDao(String uuid);
	
	/**Returns the DAO registry of this factory.
	 * @return The registry in which all elements of this factory are registered.
	 */
	public DaoRegistry getDaoRegistry();

}
