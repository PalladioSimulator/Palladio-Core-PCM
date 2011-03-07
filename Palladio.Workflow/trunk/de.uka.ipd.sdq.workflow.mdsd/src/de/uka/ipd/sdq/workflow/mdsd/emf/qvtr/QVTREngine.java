package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr;

import java.io.PrintStream;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Interface for QVT-R engine 
 * If a new engine is created this interface needs to be implemented.
 * The interface can be instantiated through a {@link QVTREngineFactory}. 
 * 
 * @author Thomas Schuischel
 */
public interface QVTREngine {

	/**
	 * Sets a property of the QVT-R engine.
	 * The available propertys depend on the engine implementation
	 *  
	 * @param name		name of the property
	 * @param value		value of the property
	 */
	void setProperty(String name, String value);
	/**
	 * Set the debug mode for the engine.
	 * This provides detailed information for the transformation.
	 * 
	 * @param debug 	enable or disable debug
	 */
	void setDebug(Boolean debug);
	
	/**
	 * Sets the QVT-R script to execute.
	 * QVT-R scripts a handled by {@link QVTRScript}.
	 * 
	 * @param qvtrScript	script to execute	
	 */
	void setQVTRScript(QVTRScript qvtrScript);
	/**
	 * Adds a model set to the engine.
	 * For a given QVT transformation a model set for each TypedModel of the 
	 * transformation declaration must be defined.
	 * 
	 * Model sets are a {@link Collection} of model resources.
	 *  
	 * @param models	a collection of models to add
	 */
	void addModels(Collection<Resource> models);
	
	/**
	 * Sets the traces {@link ResourceSet}. 
	 * The trace model is stored in the resource set´.
	 * 
	 * @param rSet	ResourceSet the traces to store in
	 */
	void setTracesResourceSet(ResourceSet rSet);
	/**
	 * Sets the {@link ResourceSet} that contains previous traces.
	 * The engine can use the information in traces from previous 
	 * transformations to track model changes.
	 * 
	 * @param rSet	ResourceSet containing previous traces
	 */
	void setOldTracesResourceSet(ResourceSet rSet);
	
	/**
	 * Enables extended debug logging.
	 * The logging output is written to a {@link PrintStream}.
	 * 
	 * @param extendedDebugingLog	PrintStream to log
	 */
	void setExtendedDebugingLog(PrintStream extendedDebugingLog);
	
	/**
	 * Sets a working directory. 
	 * Traces are stored here for example.
	 * The use of this directory depends on the engine implementation
	 *  
	 * @param directoryURI	an {@link URI} of a directory 
	 */
	void setWorkingDirectory(URI directoryURI);
	
	/**
	 * Execute the transformation.
	 */
	void transform();
	
}
