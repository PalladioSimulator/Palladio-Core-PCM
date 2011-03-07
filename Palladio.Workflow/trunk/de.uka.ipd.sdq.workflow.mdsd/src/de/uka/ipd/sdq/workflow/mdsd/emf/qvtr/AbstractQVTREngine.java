package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.internal.QVTREngines;

/**
 * A abstract QVTR engine implementing {@link QVTREngine}.
 * This implements convenience operations for a QVT-R engine. 
 * QVTREngine implementations can derive this class. 
 * It is not intended to instantiated directly.  
 * 
 * @author Thomas Schuischel
 *
 */
public abstract class  AbstractQVTREngine  implements QVTREngine {
	
	/**
	 * Derived engines should implement this to provide the information for 
	 * a give QVT-R script file.
	 * 
	 * @return a QVTRScriptInfoImpl
	 */
	protected abstract QVTRScriptInfoImpl qvtrScriptInfoImpl();
	
	/**
	 * Creates a  new QVTRScriptInfoImpl.
	 * Derived engines can use this to create the QVTRScriptInfoImpl.
	 * 
	 * @param transformationInfo 	A {@link HashMap} of transformations and their directions
	 * @param valid					is the script file valid
	 * @return						a new QVTRScriptImpl
	 */
	protected QVTRScriptInfoImpl createQVTRScriptInfo(final HashMap<String, ArrayList<String> > transformationInfo,
			final Boolean valid) {
		return new QVTRScriptInfoImpl(transformationInfo, valid);
	}
	
	
	/**
	 * Returns a registered QVT-R engine for a given id.
	 * If the engine with the id is not available null is returned.
	 *  
	 * @param id	a id of a QVT-R engine
	 * @return		an implementation of the {@link QVTREngine}
	 */
	public static AbstractQVTREngine getInstance(final String id)	{
		QVTREngines[] engines = QVTREngines.getAllEngines();
		// search for given id
		for (int i = 0;  i < engines.length; i++) {
			// if id found or no id provided return new engine
			if ((id == null) || (engines[i].getId() == id)) {
				return engines[i].newQVTREngine();
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the first available QVT-R engine.
	 * 
	 * @return	an implementation of the {@link QVTREngine}
	 */
	public static AbstractQVTREngine getFirstInstance() {
		// returns the first engine since id is null 
		return getInstance(null);
	}
	
	/**
	 * Returns the ids of all available QVT-R engines.
	 * 
	 * @return a {@link Collection} of QVT-R engine ids
	 */
	public static Collection<String> getAllInstanceIDs() {
		ArrayList<String> engineIDs = new ArrayList<String>();
		QVTREngines[] engines = QVTREngines.getAllEngines();
		// enumerate all ids
		for (int i = 0;  i < engines.length; i++) {
			engineIDs.add(engines[i].getId());
		}
		
		return engineIDs;
	}
	
	/**
	 * Internal implementation of {@link QVTRScriptInfo}.
	 * 
	 * @author Thomas Schuischel
	 *
	 */
	protected static final class QVTRScriptInfoImpl {
		/**
		 * A Map of transformations and directions.
		 */
		private HashMap<String, ArrayList<String> > transformationInfo;
		/**
		 * Is the script valid?
		 */
		private boolean valid;
		
		/**
		 * Private constructor to avoid instantiation from outside. 
		 */
		private QVTRScriptInfoImpl() { };
		
		/**
		 * Creates an new QVTRScriptInfoImpl.
		 * 
		 * @param transformationInfo the map of transformations and directions
		 * @param valid information if the script is valid
		 */
		private QVTRScriptInfoImpl(final HashMap<String, ArrayList<String> > transformationInfo, final Boolean valid) {
			this.transformationInfo = transformationInfo;
			this.valid = valid;
		}
		 
		/**
		 * Returns the directions for a given transformation.
		 * 
		 * @param transformationName the transformation name to query
		 * @return the direction for a given transformation
		 */
		String[] getDirections(final String transformationName) {
			ArrayList<String> directions = transformationInfo.get(transformationName);
			if (directions != null) {
				return directions.toArray(new String[0]);
			}
			return null;
		}
		
		/**
		 * Returns all transformations of a QVT-R script file.
		 * 
		 * @return an array of strings containing transformation names
		 */
		String[] getTransformations() {
			return transformationInfo.keySet().toArray(new String[0]);
		}
		
		/**
		 * Returns if the QVT-R script file is valid.
		 *  
		 * @return true if the script is valid
		 */
		Boolean isScriptValid() {
			return valid;
		}
	}
	
}
