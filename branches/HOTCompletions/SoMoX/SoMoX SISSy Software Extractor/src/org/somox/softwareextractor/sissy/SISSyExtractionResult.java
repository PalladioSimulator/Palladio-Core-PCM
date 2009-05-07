package org.somox.softwareextractor.sissy;

import java.util.LinkedList;
import java.util.List;

import org.somox.common.Message;
import org.somox.extractor.ExtractionResult;
import org.somox.extractor.SoftwareExtractor;

/**
 * SISSy Extraction result implementation
 *
 * @author benjamin klatt
 *
 */
public class SISSyExtractionResult implements ExtractionResult {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The software extractor produced this result */
	private SoftwareExtractor softwareExtractor = null;

	/** The current status of the extraction */
	private ExtractionResult.ResultStatus resultStatus = ExtractionResult.ResultStatus.NOT_EXECUTED;

	/** The list of messages */
	private List<Message> messages = new LinkedList<Message>();

	// ---------------------------------
	// Constructor
	// ---------------------------------

	/**
	 * Constructor requiring to link the software extractor
	 * @param	softwareExtractor The software extractor this result is about
	 */
	public SISSyExtractionResult(SoftwareExtractor softwareExtractor){
		this.softwareExtractor = softwareExtractor;
	}

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	@Override
	public ExtractionResult.ResultStatus getResultStatus() {
		return this.resultStatus;
	}

	/**
	 * Set the result status of the extractor
	 * @param resultStatus
	 */
	public void setResultStatus(ExtractionResult.ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}

	@Override
	public SoftwareExtractor getSoftwareExtractor() {
		return this.softwareExtractor;
	}

	@Override
	public void addMessage(Message message) {
		this.messages.add(message);
	}

	@Override
	public List<Message> getMessages() {
		return this.messages;
	}

}
