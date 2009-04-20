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
	private String repositoryFile;

	/**
	 * The absolute path name of the PCM System model file.
	 */
	private String systemFile;

	/**
	 * The absolute path name of the PCM ResourceEnvironment model file.
	 */
	private String resourceEnvironmentFile;

	/**
	 * The absolute path name of the PCM Allocation model file.
	 */
	private String allocationFile;

	/**
	 * The the absolute path name of the PCM Usage model file.
	 */
	private String usageFile;

	/**
	 * The directory where the simulation results shall reside.
	 */
	private String resultsDirectory;

	/**
	 * The constructor.
	 * 
	 * @param repositoryFile
	 *            the absolute path name of the PCM Repository model file
	 * @param systemFile
	 *            the absolute path name of the PCM System model file
	 * @param resourceEnvironmentFile
	 *            the absolute path name of the PCM ResourceEnvironment model
	 *            file
	 * @param allocationFile
	 *            the absolute path name of the PCM Allocation model file
	 * @param usageFile
	 *            the absolute path name of the PCM Usage model file
	 * @param the
	 *            directory where the simulation results shall reside
	 */
	public SimuServiceParams(final String repositoryFile,
			final String systemFile, final String resourceEnvironmentFile,
			final String allocationFile, final String usageFile,
			final String resultsDirectory) {

		// Take over the given values:
		this.repositoryFile = repositoryFile;
		this.systemFile = systemFile;
		this.resourceEnvironmentFile = resourceEnvironmentFile;
		this.allocationFile = allocationFile;
		this.usageFile = usageFile;
		this.resultsDirectory = resultsDirectory;
	}

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
	 * @param repositoryFile the repository model file to set
	 */
	public void setRepositoryFile(String repositoryFile) {
		this.repositoryFile = repositoryFile;
	}

	/**
	 * Retrieves the system file.
	 * 
	 * @return the system file
	 */
	public String getSystemFile() {
		return systemFile;
	}

	/**
	 * Sets the system file
	 * 
	 * @param systemFile the system file to set
	 */
	public void setSystemFile(String systemFile) {
		this.systemFile = systemFile;
	}

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
	 * @param resourceEnvironmentFile the resource environment file to set
	 */
	public void setResourceEnvironmentFile(String resourceEnvironmentFile) {
		this.resourceEnvironmentFile = resourceEnvironmentFile;
	}

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
	 * @param allocationFile the allocation file to set
	 */
	public void setAllocationFile(String allocationFile) {
		this.allocationFile = allocationFile;
	}

	/**
	 * Retrieves the usage file.
	 * 
	 * @return the usage file
	 */
	public String getUsageFile() {
		return usageFile;
	}

	
	public void setUsageFile(String usageFile) {
		this.usageFile = usageFile;
	}

	public String getResultsDirectory() {
		return resultsDirectory;
	}

	public void setResultsDirectory(String resultsDirectory) {
		this.resultsDirectory = resultsDirectory;
	}

	/**
	 * Checks if the SimuService parameters are complete and consistent.
	 * 
	 * @return TRUE, if the parameters are valid; FALSE otherwise
	 */
	public boolean isValid() {
		// check that all file parameters are set != null and point to
		// existing files:
		if (repositoryFile == null || !new File(repositoryFile).exists()) return false;
		if (systemFile == null || !new File(systemFile).exists()) return false;
		if (resourceEnvironmentFile == null || !new File(resourceEnvironmentFile).exists()) return false;
		if (allocationFile == null || !new File(allocationFile).exists()) return false;
		if (usageFile == null || !new File(usageFile).exists()) return false;
		// does the directory have to exist?
		if (resultsDirectory == null || !new File(resultsDirectory).exists()) return false; 
		
		return true;
	}
}