package de.fzi.se.validation.effort.workflow;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;

/**Configuration class for validation effort estimations.
 *
 * @author groenda
 *
 */
public class EstimatorConfiguration extends AbstractWorkflowBasedRunConfiguration {

	/** Repository file location */
	protected String repositoryFile;
	/** Behaviour location. */
	protected String behaviourURI;
	/** The confidence level. */
	protected double confidence;

	/**
	 * @return the confidence level.
	 */
	public double getConfidence() {
		return confidence;
	}

	/**Sets the confidence level.
	 * @param confidence Confidence level.
	 */
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	/**
	 * @return the location of the repository file.
	 */
	public String getRepositoryFile() {
		return repositoryFile;
	}

	/**
	 * @param repositoryFile the location of the repository file to set
	 */
	public void setRepositoryFile(String repositoryFile) {
		this.repositoryFile = repositoryFile;
	}

	/**
	 * @return the location of the behaviour.
	 */
	public String getBehaviourURI() {
		return behaviourURI;
	}

	/**
	 * @param behaviourURI the location of the behaviour to set
	 */
	public void setBehaviourURI(String behaviourURI) {
		this.behaviourURI = behaviourURI;
	}

	public String getErrorMessage() {
		// must be null; otherwise a non-empty error message will result in
		// a workflow config being considered invalid
		// see SimuComWorkflowConfiguration
		return null;
	}

	public void setDefaults() {
		// see SimuComWorkflowConfiguration
		throw new RuntimeException("Not implemented. No defaults defined.");
	}

	protected Object clone() throws CloneNotSupportedException {
		EstimatorConfiguration config = (EstimatorConfiguration) super.clone();
		config.behaviourURI = new String(this.behaviourURI);
		config.repositoryFile = new String(this.repositoryFile);
		config.confidence = this.confidence;
		return config;
	}
}
