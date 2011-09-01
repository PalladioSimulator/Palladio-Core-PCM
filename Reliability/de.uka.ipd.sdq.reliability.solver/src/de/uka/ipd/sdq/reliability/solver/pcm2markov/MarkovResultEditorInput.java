package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * Class that is responsible for displaying Markov transformation results
 * as HTML page inside a customized workbench editor of a target instance. 
 * 
 * @author Daniel Patejdl
 *
 */
public class MarkovResultEditorInput implements IEditorInput {
	
	/**
	 * The Markov transformation results (one result object for
	 * each PCM UsageScenario).
	 */
	private List<MarkovTransformationResult> markovResults;

	/**
	 * Gets the Markov transformation results.
	 * @return the Markov transformation results
	 */
	public List<MarkovTransformationResult> getMarkovResults() {
		return markovResults;
	}

	/**
	 * Sets the Markov transformation results.
	 * @param markovResults the Markov transformation results
	 */
	public void setMarkovResults(List<MarkovTransformationResult> markovResults) {
		this.markovResults = markovResults;
	}

	/**
	 * Creates a new MarkovResultEditor, given a list of Markov transformation results.
	 * @param markovResults the Markov transformation results
	 */
	public MarkovResultEditorInput(
			List<MarkovTransformationResult> markovResults) {
		this.markovResults = markovResults;
	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "MarkovResult";
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		return "Markov Result";
	}

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

}
