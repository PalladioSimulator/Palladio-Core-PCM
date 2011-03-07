package de.uka.ipd.sdq.simuservice.types;


/**
 * Encapsulates input parameters for the prediction service.
 * 
 * author: brosch, heupel, kuester, daniel.patejdl
 */
public class SimuServiceParams {

	/**
	 * The PCM Allocation model file name.
	 */
	private String allocationModelFileName = null;

	/**
	 * The PCM Allocation model file serialized.
	 */
	private String allocationModelXMI = null;

	/**
	 * Indicates if former logging messages shall be cleared before simulation
	 * start.
	 */
	private boolean clearLogging = true;

	/**
	 * Determines the value of the maximum measurements count constraint.
	 */
	private long maxMeasurementsCount = 150000;

	/**
	 * Determines the value of the maximum simulation time constraint.
	 */
	private long maxSimTime = 10000;

	/**
	 * PCM models as serialized ZIP archive
	 */
	private byte[] modelArchive = null;

	/**
	 * The PCM Repository model file names.
	 */
	private String[] repositoryModelFileNames = null;

	/**
	 * The PCM Repository model file serialized.
	 */
	private String[] repositoryModelXMIs = null;

	/**
	 * The PCM Resource Environment model file name.
	 */
	private String resourceEnvironmentFileName = null;

	/**
	 * The PCM Resource Environment Model file serialized.
	 */
	private String resourceEnvironmentModelXMI;

	/**
	 * The directory where the simulation results shall reside.
	 */
	private String resultsDirectory = null;

	/**
	 * The PCM System model file name.
	 */
	private String systemModelFileName = null;

	/**
	 * The PCM System model file serialized.
	 */
	private String systemModelXMI = null;

	/**
	 * The PCM Usage model file name.
	 */
	private String usageModelFileName = null;

	/**
	 * The PCM Usage model file serialized.
	 */
	private String usageModelXMI = null;

	/**
	 * Indicates if logging shall be verbose during simulation
	 */
	private boolean verboseLogging = false;

	/**
	 * Retrieves the PCM Allocation model file name.
	 * 
	 * @return the PCM Allocation model file name
	 */
	public String getAllocationModelFileName() {
		return allocationModelFileName;
	}

	/**
	 * @return the allocationModelXMI
	 */
	public String getAllocationModelXMI() {
		return allocationModelXMI;
	}

	/**
	 * Retrieves the maximum measurements count constraint.
	 * 
	 * @return the maximum measurements count constraint
	 */
	public long getMaxMeasurementsCount() {
		return maxMeasurementsCount;
	}

	/**
	 * Retrieves the maximum simulation time constraint.
	 * 
	 * @return the maximum simulation time constraint
	 */
	public long getMaxSimTime() {
		return maxSimTime;
	}

	/**
	 * @return the modelArchive
	 */
	public byte[] getModelArchive() {
		return modelArchive;
	}

	/**
	 * Retrieves the PCM Repository model file names.
	 * 
	 * @return the PCM Repository model file names
	 */
	public String[] getRepositoryModelFileNames() {
		return repositoryModelFileNames;
	}

	/**
	 * Retrieves the serialized PCM Repository model files.
	 * 
	 * @return the serialized PCM Repository model files
	 */
	public String[] getRepositoryModelXMIs() {
		return repositoryModelXMIs;
	}

	/**
	 * Retrieves the PCM Resource Environment model file name.
	 * 
	 * @return the PCM Resource Environment model file name
	 */
	public String getResourceEnvironmentFileName() {
		return resourceEnvironmentFileName;
	}

	/**
	 * Retrieves the serialized PCM Resource Environment model file.
	 * 
	 * @return the serialized PCM Resource Environment model file
	 */
	public String getResourceEnvironmentModelXMI() {
		return resourceEnvironmentModelXMI;
	}

	/**
	 * Retrieves the simulation results file.
	 * 
	 * @return the simulation results file
	 */
	@Deprecated
	public String getResultsDirectory() {
		return resultsDirectory;
	}

	/**
	 * Retrieves the PCM System model file name.
	 * 
	 * @return the PCM System model file name.
	 */
	public String getSystemModelFileName() {
		return systemModelFileName;
	}

	/**
	 * Retrieves the serialized PCM System model file.
	 * 
	 * @return the serialized PCM System model file
	 */
	public String getSystemModelXMI() {
		return systemModelXMI;
	}

	/**
	 * Retrieves the PCM Usage model file name.
	 * 
	 * @return the PCM Usage model file name
	 */
	public String getUsageModelFileName() {
		return usageModelFileName;
	}

	/**
	 * @return the usageModelXMI
	 */
	public String getUsageModelXMI() {
		return usageModelXMI;
	}

	/**
	 * Retrieves the value of the clearLogging option.
	 * 
	 * @return the value of clearLogging
	 */
	public boolean isClearLogging() {
		return clearLogging;
	}

	/**
	 * Retrieves the value of the verboseLogging option.
	 * 
	 * @return the value of verboseLogging
	 */
	public boolean isVerboseLogging() {
		return verboseLogging;
	}

	/**
	 * Sets the PCM Allocation model file name.
	 * 
	 * @param allocationModelFileName
	 *            The PCM Allocation model file name to set
	 */
	public void setAllocationModelFileName(String allocationModelFileName) {
		this.allocationModelFileName = allocationModelFileName;
	}

	/**
	 * @param allocationModelXMI
	 *            the allocationModelXMI to set
	 */
	public void setAllocationModelXMI(String allocationModelXMI) {
		this.allocationModelXMI = allocationModelXMI;
	}

	/**
	 * Sets the value of the clearLogging option.
	 * 
	 * @param clearLogging
	 *            the value of clearLogging
	 */
	public void setClearLogging(boolean clearLogging) {
		this.clearLogging = clearLogging;
	}

	/**
	 * Sets the maximum measurements count constraint.
	 * 
	 * @param maxMeasurementsCount
	 *            the maximum measurements count constraint
	 */
	public void setMaxMeasurementsCount(long maxMeasurementsCount) {
		this.maxMeasurementsCount = maxMeasurementsCount;
	}

	/**
	 * Sets the maximum simulation time constraint.
	 * 
	 * @param maxSimTime
	 *            the maximum simulation time constraint
	 */
	public void setMaxSimTime(long maxSimTime) {
		this.maxSimTime = maxSimTime;
	}

	/**
	 * @param modelArchive
	 *            the modelArchive to set
	 */
	public void setModelArchive(byte[] modelArchive) {
		this.modelArchive = modelArchive;
	}

	/**
	 * Sets the PCM Repository model file names.
	 * 
	 * @param repositoryModelFileNames
	 *            the PCM Repository model file names to set
	 */
	public void setRepositoryModelFileNames(String[] repositoryModelFileNames) {
		this.repositoryModelFileNames = repositoryModelFileNames;
	}

	/**
	 * Sets the serialized PCM Repository model files.
	 * 
	 * @param repositoryModelXMI
	 *            the serialized PCM Repository model files
	 */
	public void setRepositoryModelXMIs(String[] repositoryModelXMIs) {
		this.repositoryModelXMIs = repositoryModelXMIs;
	}

	/**
	 * Sets the PCM Resource Environment model file name.
	 * 
	 * @param resourceEnvironmentFileName
	 *            the PCM Resource Environment model file name to set
	 */
	public void setResourceEnvironmentFileName(
			String resourceEnvironmentFileName) {
		this.resourceEnvironmentFileName = resourceEnvironmentFileName;
	}

	/**
	 * Sets the serialized PCM Resource Environment model file.
	 * 
	 * @param resourceEnvironmentModelXMI
	 *            the serialized PCM Resource Environment model file
	 */
	public void setResourceEnvironmentModelXMI(
			String resourceEnvironmentModelXMI) {
		this.resourceEnvironmentModelXMI = resourceEnvironmentModelXMI;
	}

	/**
	 * Sets the simulation results file.
	 * 
	 * @param resultsDirectory
	 *            the simulation results file
	 */
	@Deprecated
	public void setResultsDirectory(String resultsDirectory) {
		this.resultsDirectory = resultsDirectory;
	}

	/**
	 * Sets the PCM System model file name.
	 * 
	 * @param systemModelFileName
	 *            the PCM System model file name to set
	 */
	public void setSystemModelFileName(String systemModelFileName) {
		this.systemModelFileName = systemModelFileName;
	}

	/**
	 * Sets the serialized PCM System model file.
	 * 
	 * @param systemModelXMI
	 *            the serialized PCM System model file.
	 */
	public void setSystemModelXMI(String systemModelXMI) {
		this.systemModelXMI = systemModelXMI;
	}

	/**
	 * Sets the PCM Usage model file name.
	 * 
	 * @param usageModelFileName
	 *            the PCM Usage model file name to set
	 */
	public void setUsageModelFileName(String usageModelFileName) {
		this.usageModelFileName = usageModelFileName;
	}

	/**
	 * @param usageModelXMI
	 *            the usageModelXMI to set
	 */
	public void setUsageModelXMI(String usageModelXMI) {
		this.usageModelXMI = usageModelXMI;
	}

	/**
	 * Sets the value of the verboseLogging option.
	 * 
	 * @param verboseLogging
	 *            the value of verboseLogging
	 */
	public void setVerboseLogging(boolean verboseLogging) {
		this.verboseLogging = verboseLogging;
	}

	/**
	 * Checks if the SimuService parameters are complete and consistent.
	 * 
	 * @return a string indicating the validation status of the parameters
	 */
	public String validate() {
		// TODO adopt to interface changes.
		
//		if ((allocationModelXMI == null)
//				|| (!new File(allocationModelXMI).exists()))
//			return "Allocation file \"" + allocationModelXMI
//					+ "\" not set or not existent.";
//		if ((usageModelXMI == null) || (!new File(usageModelXMI).exists()))
//			return "Usage file \"" + usageModelXMI
//					+ "\" not set or not existent.";
//		if ((resultsDirectory == null)
//				|| (!new File(resultsDirectory).isDirectory()))
//			return "Results directory \"" + resultsDirectory
//					+ "\" not set or not existent.";
//		if (maxSimTime < -1) {
//			return "Maximum simulation time = " + maxSimTime
//					+ " (must be >= -1)";
//		}
//		if (maxMeasurementsCount < -1) {
//			return "Maximum measurements count = " + maxMeasurementsCount
//					+ " (must be >= -1)";
//		}
//		if ((maxSimTime == -1) && (maxMeasurementsCount == -1)) {
//			return "Maximum simulation time and maximum measurements count are both not set.";
//		}

		// All tests passed:
		return null;
	}
}