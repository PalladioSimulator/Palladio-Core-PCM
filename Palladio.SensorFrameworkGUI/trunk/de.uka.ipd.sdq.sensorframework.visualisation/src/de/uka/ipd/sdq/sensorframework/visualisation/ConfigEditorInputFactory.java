/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;

/**
 * @author Snowball
 *
 */
public class ConfigEditorInputFactory implements IElementFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IElementFactory#createElement(org.eclipse.ui.IMemento)
	 */
	@Override
	public IAdaptable createElement(IMemento memento) {
		return new ConfigEditorInput();
	}

}
