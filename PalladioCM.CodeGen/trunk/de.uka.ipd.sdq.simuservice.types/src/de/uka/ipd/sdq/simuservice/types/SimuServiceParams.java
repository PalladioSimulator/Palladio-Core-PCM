package de.uka.ipd.sdq.simuservice.types;

import java.io.File;

/**
 * Encapsulates input parameters for the prediction service.
 * 
 * author: brosch, heupel
 */
public class SimuServiceParams {

	/**
	 * The absolute path name of the PCM Repository model file.
	 */
	private String repositoryFile = null;

	/**
	 * Retrieves the repository model file.
	 * 
	 * @return the repository model file
	 */
	public String getRepositoryFile() {
		return repositoryFile;
	}

	/**
	 * Sets the repository model file.
	 * 
	 * @param repositoryFile
	 *            the repository model file to set
	 */
	public void setRepositoryFile(String repositoryFile) {
		this.repositoryFile = repositoryFile;
	}

	/**
	 * The absolute path name of the PCM System model file.
	 */
	private String systemFile = null;

	/**
	 * Retrieves the system file.
	 * 
	 * @return the system file
	 */
	public String getSystemFile() {
		return systemFile;
	}

	/**
	 * Sets the system file.
	 * 
	 * @param systemFile
	 *            the system file to set
	 */
	public void setSystemFile(String systemFile) {
		this.systemFile = systemFile;
	}

	/**
	 * The absolute path name of the PCM ResourceEnvironment model file.
	 */
	private String resourceEnvironmentFile = null;

	/**
	 * Retrieves the resource environment file.
	 * 
	 * @return the resource environment file
	 */
	public String getResourceEnvironmentFile() {
		return resourceEnvironmentFile;
	}

	/**
	 * Sets the resource environment file.
	 * 
	 * @param resourceEnvironmentFile
	 *            the resource environment file to set
	 */
	public void setResourceEnvironmentFile(String resourceEnvironmentFile) {
		this.resourceEnvironmentFile = resourceEnvironmentFile;
	}

	/**
	 * The absolute path name of the PCM Allocation model file.
	 */
	private String allocationFile = null;

	/**
	 * Retrieves the allocation file.
	 * 
	 * @return the allocation file
	 */
	public String getAllocationFile() {
		return allocationFile;
	}

	/**
	 * Sets the allocation file.
	 * 
	 * @param allocationFile
	 *            the allocation file to set
	 */
	public void setAllocationFile(String allocationFile) {
		this.allocationFile = allocationFile;
	}

	/**
	 * The the absolute path name of the PCM Usage model file.
	 */
	private String usageFile = null;

	/**
	 * Retrieves the usage file.
	 * 
	 * @return the usage file
	 */
	public String getUsageFile() {
		return usageFile;
	}

	/**
	 * Sets the usage File
	 * 
	 * @param usageFile
	 *            the usage file
	 */
	public void setUsageFile(String usageFile) {
		this.usageFile = usageFile;
	}

	/**
	 * The directory where the simulation results shall reside.
	 */
	private String resultsDirectory = null;

	/**
	 * Retrieves the simulation results file.
	 * 
	 * @return the simulation results file
	 */
	public String getResultsDirectory() {
		return resultsDirectory;
	}

	/**
	 * Sets the simulation results file.
	 * 
	 * @param resultsDirectory
	 *            the simulation results file
	 */
	public void setResultsDirectory(String resultsDirectory) {
		this.resultsDirectory = resultsDirectory;
	}

	/**
	 * Indicates if former logging messages shall be cleared before simulation
	 * start.
	 */
	private boolean clearLogging = true;

	/**
	 * Retrieves the value of the clearLogging option.
	 * 
	 * @return the value of clearLogging
	 */
	public boolean isClearLogging() {
		return clearLogging;
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
	 * Indicates if logging shall be verbose during simulation
	 */
	private boolean verboseLogging = false;

	/**
	 * Retrieves the value of the verboseLogging option.
	 * 
	 * @return the value of verboseLogging
	 */
	public boolean isVerboseLogging() {
		return verboseLogging;
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
	 * Determines the value of the maximum simulation time constraint.
	 */
	private long maxSimTime = -1;

	/**
	 * Retrieves the maximum simulation time constraint.
	 * 
	 * @return the maximum simulation time constraint
	 */
	public long getMaxSimTime() {
		return maxSimTime;
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
	 * Determines the value of the maximum measurements count constraint.
	 */
	private long maxMeasurementsCount = -1;

	/**
	 * Retrieves the maximum measurements count constraint.
	 * 
	 * @return the maximum measurements count constraint
	 */
	public long getMaxMeasurementsCount() {
		return maxMeasurementsCount;
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
	 * Checks if the SimuService parameters are complete and consistent.
	 * 
	 * @return a string indicating the validation status of the parameters
	 */
	public String validate() {

		if ((repositoryFile == null) || (!new File(repositoryFile).exists()))
			return "Repository file \"" + repositoryFile
					+ "\" not set or not existent.";
		if ((systemFile == null) || (!new File(systemFile).exists()))
			return "System file \"" + systemFile
					+ "\" not set or not existent.";
		if ((resourceEnvironmentFile == null)
				|| (!new File(resourceEnvironmentFile).exists()))
			return "Resource environment file \"" + resourceEnvironmentFile
					+ "\" not set or not existent.";
		if ((allocationFile == null) || (!new File(allocationFile).exists()))
			return "Allocation file \"" + allocationFile
					+ "\" not set or not existent.";
		if ((usageFile == null) || (!new File(usageFile).exists()))
			return "Usage file \"" + usageFile + "\" not set or not existent.";
		if ((resultsDirectory == null)
				|| (!new File(resultsDirectory).isDirectory()))
			return "Results directory \"" + resultsDirectory
					+ "\" not set or not existent.";
		if (maxSimTime < -1) {
			return "Maximum simulation time = " + maxSimTime
					+ " (must be >= -1)";
		}
		if (maxMeasurementsCount < -1) {
			return "Maximum measurements count = " + maxMeasurementsCount
					+ " (must be >= -1)";
		}
		if ((maxSimTime == -1) && (maxMeasurementsCount == -1)) {
			return "Maximum simulation time and maximum measurements count are both not set.";
		}

		// All tests passed:
		return null;
	}
}