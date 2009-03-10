package org.somox.analyzer;

import java.util.List;

import org.somox.common.Message;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository;

/**
 * The result of an analysis iteration.
 *
 * This result object contains all information about the last
 * model analyzer result like the status or the analyzed model
 *
 * @author Benjamin Klatt
 *
 */
public interface AnalysisResult {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	/** The result status of the analysis step */
	public enum ResultStatus {NOT_EXECUTED,SUCCESS,FAILED}

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	/**
	 * The result status of the extraction.
	 * Will be one of the constants AnalysisResult.ResultStatus
	 * @return The status of the analysis
	 */
	public AnalysisResult.ResultStatus getResultStatus();


	/**
	 * Get  the Model Analyzer that was performed
	 * @return The model analyzer that has been executed
	 */
	public ModelAnalyzer getModelAnalyzer();

	/**
	 * Get the resulting internal architectural model
	 * @return Q-IMPRESS model repository.
	 */
	public Repository getInternalArchitectureModel();

	/**
	 * Add a message object to the result
	 *
	 * @param message The message object
	 */
	public void addMessage(Message message);

	/**
	 * Get a list of all message objects assigned to this result
	 * @return List of all assigned message objects
	 */
	public List<Message> getMessages();

}
