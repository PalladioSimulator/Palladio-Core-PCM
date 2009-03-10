package org.somox.analyzer.simplemodelanalyzer;

import java.util.LinkedList;
import java.util.List;

import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.ModelAnalyzer;
import org.somox.common.Message;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository;

public class SimpleAnalysisResult implements AnalysisResult {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The executed model analyzer */
	private ModelAnalyzer modelAnalyzer = null;

	/** The result status */
	private AnalysisResult.ResultStatus resultStatus = AnalysisResult.ResultStatus.NOT_EXECUTED;

	/** the internal architecture model resulting from the performed analysis */
	private Repository internalArchitectureModel = null;

	/** The list of messages */
	private List<Message> messages = new LinkedList<Message>();

	// ---------------------------------
	// Constructor
	// ---------------------------------

	public SimpleAnalysisResult(ModelAnalyzer analyzer){
		this.modelAnalyzer = analyzer;
	}

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	// ---------------------------------
	// Helper Methods
	// ---------------------------------

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	@Override
	public ModelAnalyzer getModelAnalyzer() {
		return this.modelAnalyzer;
	}

	@Override
	public AnalysisResult.ResultStatus getResultStatus() {
		return resultStatus;
	}

	/**
	 * @param status the status to set
	 */
	public void setResultStatus(AnalysisResult.ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}

	@Override
	public Repository getInternalArchitectureModel() {
		return internalArchitectureModel;
	}

	/**
	 * @param internalArchitectureModel the internalArchitectureModel to set
	 */
	public void setInternalArchitectureModel(Repository internalArchitectureModel) {
		this.internalArchitectureModel = internalArchitectureModel;
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
