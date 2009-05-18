package org.somox.analyzer;

import java.util.HashMap;

import org.eclipse.core.runtime.Preferences;
import org.somox.configuration.ConfigurableComponent;
import org.somox.extractor.ExtractionResult;

import eu.qimpress.samm.staticstructure.Repository;

//import eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository;


/**
 * Interface for Analyzer extensions to be accessed from the SoMoX core
 * @author Benjamin Klatt
 *
 */
public interface ModelAnalyzer {

	/** The result status of the model analyzer */
	public enum Status {READY,RUNNING ,FINISHED,WAITING}

	/**
	 * initialize the analyzer
	 */
	public void init();

	/**
	 * Execute the analyzer
	 * @param preferences	The preferences for this analyzer
	 * @param internalArchitectureModel	The internal architecture model represented through a Q-IMPREss repository
	 * @param extractionResultMap		The map of extraction results
	 * @return	The analysis result object
	 */
	public AnalysisResult analyze(	Preferences preferences,
									Repository internalArchitectureModel,
									HashMap<String, ExtractionResult> extractionResultMap);

	/**
	 * Get the status from the analyzer
	 * @return	The current status of the analyzer. Has to be one of the defined status in this interface
	 */
	public ModelAnalyzer.Status getStatus();
}
