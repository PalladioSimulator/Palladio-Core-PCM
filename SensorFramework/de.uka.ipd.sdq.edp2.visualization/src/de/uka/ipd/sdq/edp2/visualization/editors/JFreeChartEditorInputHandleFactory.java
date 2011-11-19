/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;

/**
 * Factory class for {@link JFreeChartEditorInputHandle}. Invokes persistence of all {@link JFreeChartEditorInput}
 * elements managed by this handle.
 * @author Dominik Ernst
 *
 */
public class JFreeChartEditorInputHandleFactory implements IElementFactory {

	/**
	 * The factory's ID. Must match the ID specified in the extension point
	 * "org.eclipse.ui.elementFactories".
	 */
	private static final String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInputFactory";
	
	/**
	 * The attribute under which the different inputs names are stored.
	 */
	protected final static String INPUT_NAME_KEY = "inputName";
	
	/**
	 * The attribute under which the size of the input array is persisted.
	 */
	protected final static String INPUT_SIZE_KEY = "inputSize";
	
	/**
	 * The handle's name as a persisted element in the XML.
	 */
	protected final static String ELEMENT_NAME = "InputHandle";
	/**
	 * Key for retrieving an element's name from its properties.
	 */
	protected final static String ELEMENT_KEY = "elementName";
	
	/**
	 * @return this factory's ID.
	 */
	public static String getFactoryId() {
		return FACTORY_ID;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IElementFactory#createElement(org.eclipse.ui.IMemento)
	 */
	@Override
	public IAdaptable createElement(IMemento memento) {
		JFreeChartEditorInputHandle handle = new JFreeChartEditorInputHandle();
		memento = memento.getChild(ELEMENT_NAME);
		int size = memento.getInteger(INPUT_SIZE_KEY);
		for (int j = 0; j < size; j++){
			String elementName = memento.getString(INPUT_NAME_KEY+j);
			
		}
		return null;
	}
	
	public static void saveState(IMemento memento, JFreeChartEditorInputHandle inputHandle) {
		memento.createChild(ELEMENT_NAME);
		memento = memento.getChild(ELEMENT_NAME);
		
		memento.putInteger(INPUT_SIZE_KEY, inputHandle.getInputsSize());
		
		int i = 0;
		for (IDataSink input : inputHandle.getInputs()) {
			memento.putString(INPUT_NAME_KEY+i++, input.getProperties().get(ELEMENT_KEY).toString());
			input.saveState(memento);
		}
	}

}
