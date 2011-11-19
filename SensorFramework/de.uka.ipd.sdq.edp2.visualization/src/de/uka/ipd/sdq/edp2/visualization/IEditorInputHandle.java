/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization;

import java.util.ArrayList;
import java.util.Observer;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * Interface for classes wrapping multiple editor inputs into one object to be displayed
 * by an editor.
 * @author Dominik Ernst
 *
 */
public interface IEditorInputHandle extends IEditorInput, Observer, ISelection, IPersistableElement {

	/**
	 * Method to retrieve all contained {@link IDataSink}s. These are intended to be displayed by the same
	 * {@link IVisualization}.
	 * @return the contained {@link IDataSink}s
	 */
	public ArrayList<IDataSink> getInputs();
	
	/**
	 * Adds an {@link IDataSink} to this {@link IEditorInputHandle}'s list of inputs.
	 * @param newInput the {@link IDataSink} to add.
	 * @return <true> if the {@link IDataSink} could be added successfully.
	 */
	public boolean addInput(IDataSink newInput);
	
	/**
	 * Removes an {@link IDataSink} from this {@link IEditorInputHandle}'s list of inputs.
	 * @param removedInput the {@link IDataSink} to add.
	 * @return <true> if the {@link IDataSink} could found and removed.
	 */
	public boolean removeInput(IDataSink removedInput);
	
	/**
	 * 
	 * @return the inputs-Array's size
	 */
	public int getInputsSize();
	
	/**
	 * Method to return the combined set of input data, which can be displayed by an {@link IVisualization}.
	 * @return
	 */
	public Object getInputDataset();
	
}
