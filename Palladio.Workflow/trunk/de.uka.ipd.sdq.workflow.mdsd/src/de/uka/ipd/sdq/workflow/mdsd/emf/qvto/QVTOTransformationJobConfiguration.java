package de.uka.ipd.sdq.workflow.mdsd.emf.qvto;

import java.util.Map;

import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

/**
 * Configuration class of the {@link QVTOTransformationJob}. The QVTO transformation job reads a 
 * QVTO script, parses it and executes it. It takes its input from a {@link MDSDBlackboard} where
 * it also stores its output later. The transformation is allowed to use configuration parameters.
 * @author Steffen Becker
 */
public class QVTOTransformationJobConfiguration {
	private Map<String, Object> opts;
	private ModelLocation[] inoutModels;
	private URI scriptFile;
	private URI traceFile;
		
	public Map<String, Object> getOptions() {
		return opts;
	}
	public void setOptions(Map<String, Object> opts) {
		this.opts = opts;
	}
	/**
	 * @return the inoutModels
	 */
	public ModelLocation[] getInoutModels() {
		return inoutModels;
	}
	/**
	 * Set the location of the models used as parameters for the QVTO transformation. The model 
	 * need to be located on the blackboard. They are allowed to reside only in memory but need
	 * at least to have a URI. Also the order of the models in the array has to match exactly the
	 * order of the parameters of the QVTO transformation. It is necessary to have an entry for all
	 * parameters, i.e., in, out, and inout
	 * @param inoutModels A list of models used as parameter for the transformation
	 */
	public void setInoutModels(ModelLocation[] inoutModels) {
		this.inoutModels = inoutModels;
	}
	/**
	 * @return the scriptFile
	 */
	public URI getScriptFileURI() {
		return scriptFile;
	}
	/**
	 * @param scriptFile the scriptFile to set
	 */
	public void setScriptFileURI(URI scriptFile) {
		this.scriptFile = scriptFile;
	}
	public void setTraceFileURI(URI traceFilePath) {
		this.traceFile = traceFilePath;
	}
	public URI getTraceFileURI() {
		return this.traceFile;
	}
}
