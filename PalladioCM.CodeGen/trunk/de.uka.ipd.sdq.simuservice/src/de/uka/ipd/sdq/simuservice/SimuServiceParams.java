package de.uka.ipd.sdq.simuservice;

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

	public String getRepositoryFile() {
		return repositoryFile;
	}

	public void setRepositoryFile(String repositoryFile) {
		this.repositoryFile = repositoryFile;
	}

	public String getSystemFile() {
		return systemFile;
	}

	public void setSystemFile(String systemFile) {
		this.systemFile = systemFile;
	}

	public String getResourceEnvironmentFile() {
		return resourceEnvironmentFile;
	}

	public void setResourceEnvironmentFile(String resourceEnvironmentFile) {
		this.resourceEnvironmentFile = resourceEnvironmentFile;
	}

	public String getAllocationFile() {
		return allocationFile;
	}

	public void setAllocationFile(String allocationFile) {
		this.allocationFile = allocationFile;
	}

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

		// TODO: check that all file parameters are set != null and point to
		// existing files:
		return true;
	}
}