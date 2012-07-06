package de.uka.ipd.sdq.reliability.solver.visualisation;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * Class that is responsible for displaying Markov transformation results as HTML page inside a
 * customized workbench editor of a target instance.
 * 
 * @author Daniel Patejdl
 * 
 */
public class MarkovResultEditorInput implements IEditorInput {

    /**
     * HTML code represented as string.
     */
    private String htmlCode;

    /**
     * Creates a new MarkovResultEditor, given a list of Markov transformation results.
     * 
     * @param markovResults
     *            the Markov transformation results
     * @param configuration
     *            the configuration properties for the reliability solver workflow
     */
    public MarkovResultEditorInput(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public Object getAdapter(Class adapter) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets the HTML code as string.
     * 
     * @return the HTML code as string
     */
    public String getHtmlCode() {
        return htmlCode;
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

    /**
     * Sets the HTML code (string)
     * 
     * @param htmlCode
     *            the HTML code as string
     */
    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }

}
