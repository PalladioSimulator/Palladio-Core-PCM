package de.uka.ipd.sdq.pcmsolver.visualisation;

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
public class LQNResultEditorInput implements IEditorInput {

	/**
	 * HTML code represented as string.
	 */
	private String htmlCode;

	/**
	 * Gets the HTML code as string.
	 * @return the HTML code as string
	 */
	public String getHtmlCode() {
		return htmlCode;
	}

	/**
	 * Sets the HTML code (string)
	 * @param htmlCode the HTML code as string
	 */
	public void setHtmlCode(String htmlCode) {
		this.htmlCode = htmlCode;
	}

	/**
	 * Creates a new MarkovResultEditor, given a list of Markov transformation results.
	 * @param markovResults the Markov transformation results
	 * @param configuration the configuration properties for the reliability solver workflow
	 */
	public LQNResultEditorInput(String htmlCode) {
		this.htmlCode = htmlCode;
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
		return "LQNResult";
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		return "LQN Result";
	}

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

}
