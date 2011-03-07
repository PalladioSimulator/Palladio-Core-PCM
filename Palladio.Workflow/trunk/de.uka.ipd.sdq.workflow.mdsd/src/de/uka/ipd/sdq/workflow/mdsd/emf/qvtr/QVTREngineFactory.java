package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr;


/**
 * Interface for QVT-R engine factory
 * If a new engine is created this factory needs to be implemented.
 * The factory can be registered to the de.uka.ipd.sdq.workflow.mdsd.qvtrengine
 * extension point. 
 * 
 * @author Thomas Schuischel
 */
public interface QVTREngineFactory {
	
	/**
	 * Factory method for instantiation of a new {@link AbstractQVTREngine} implementation.
	 * If cleanup is needed dispose should be implemented.
	 * 
	 * @return a new instance of a {@link AbstractQVTREngine} implementation
	 */
	AbstractQVTREngine createEngine();
	
	/**
	 * Cleanup method if needed.
	 * Dispose is called if the engine is not need any longer
	 */
	void dispose();
}
