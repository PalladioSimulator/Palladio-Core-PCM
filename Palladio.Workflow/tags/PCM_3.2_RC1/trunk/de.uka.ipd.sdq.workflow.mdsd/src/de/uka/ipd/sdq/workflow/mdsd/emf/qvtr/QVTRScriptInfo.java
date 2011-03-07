package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr;


/**
 * QVTScriptInfo provides information for a given {@link QVTRScript}.
 * The informations are the available transformations for a QVT-R script
 * file and the directions for each transformation.
 * 
 * Also it holds the validation status of the QVT-R script.
 *  
 * @author Thomas Schuischel
 *
 */
public class QVTRScriptInfo {
	
	/**
	 * Instance of a QVTRScriptInfoImpl.
	 */
	private AbstractQVTREngine.QVTRScriptInfoImpl qvtScriptInfoImpl = null;
	
	
	/**
	 * Creates a new QVTScriptInfo for a given {@link QVTRScript}.
	 * It uses the first available QVT-R engine.
	 * 
	 * @param qvtrScript	a QVTRScript to analyze
	 */
	public QVTRScriptInfo(final QVTRScript qvtrScript) {
		this(qvtrScript, AbstractQVTREngine.getFirstInstance());
	}

	/**
	 * Creates a new QVTScriptInfo for a given {@link QVTRScript}.
	 * It uses the QVT-R engine for the given engine id.
	 * 
	 * @param qvtrScript	a QVTRScript to analyze
	 * @param qvtrEngineID	an id of the QVT-R engine to use 
	 */
	public QVTRScriptInfo(final QVTRScript qvtrScript, final String qvtrEngineID) {
		this(qvtrScript, AbstractQVTREngine.getInstance(qvtrEngineID));
	}
	
	
	/**
	 * Creates a new QVTScriptInfo for a given {@link QVTRScript}.
	 * It uses the QVT-R engine that is provided by the parameter.
	 * 
	 * @param qvtrScript	a QVTRScript to analyze
	 * @param qvtrEngine	an QVT-R engine to use 
	 */
	protected QVTRScriptInfo(final QVTRScript qvtrScript, final AbstractQVTREngine qvtrEngine) {
		if (qvtrEngine != null) {
			qvtrEngine.setQVTRScript(qvtrScript);
			qvtScriptInfoImpl = qvtrEngine.qvtrScriptInfoImpl();
		}
	}
	
	/**
	 * Returns the directions for a given transformation.
	 * 
	 * @param transformationName	name of a transformation
	 * @return						the direction names for a transformation 
	 */
	public String[] getDirections(final String transformationName) {
		if (qvtScriptInfoImpl != null) {
			return qvtScriptInfoImpl.getDirections(transformationName);
		}
		
		return null;
	}
	
	/**
	 * Returns the available transformations.
	 * 
	 * @return		the transformations names
	 */
	public String[] getTransformations() {
		if (qvtScriptInfoImpl != null) {
			return qvtScriptInfoImpl.getTransformations();
		}
		
		return null;
	}
	
	/**
	 * Returns if the QVT-R script is valid.
	 *  
	 * @return		true if it is a valid QVT-R script
	 */
	public boolean isScriptValid() {
		if (qvtScriptInfoImpl != null) {
			return qvtScriptInfoImpl.isScriptValid();
		}
		
		return false;
	}
}
