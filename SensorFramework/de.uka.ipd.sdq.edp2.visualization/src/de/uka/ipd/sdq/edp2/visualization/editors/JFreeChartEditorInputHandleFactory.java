/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.FactoryConnector;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;

/**
 * Factory class for {@link JFreeChartEditorInputHandle}. Invokes persistence of all {@link IDataSink}
 * elements managed by this handle.
 * @author Dominik Ernst
 *
 */
public class JFreeChartEditorInputHandleFactory implements IElementFactory {
	
	/**
	 * Logger for this class.
	 */
	private static Logger logger = Logger
	.getLogger(JFreeChartEditorInputHandleFactory.class.getCanonicalName());
	/**
	 * The factory's ID. Must match the ID specified in the extension point
	 * "org.eclipse.ui.elementFactories".
	 */
	private static final String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.JFreeChartEditorInputHandleFactory";
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
	protected final static String ELEMENT_NAME = "JFreeChartEditorInputHandle";
	/**
	 * Key for retrieving an element's name from its properties.
	 */
	protected final static String ELEMENT_KEY = "elementName";
	/**
	 * A {@link FactoryConnector}.
	 */
	protected final static FactoryConnector factoryConnector = new FactoryConnector();
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
			Object sinkFactory = factoryConnector.getAdapter(elementName, IElementFactory.class);
			IDataSink createdSink = (IDataSink) ((IElementFactory) sinkFactory)
			.createElement(memento);
			
			handle.addInput(createdSink);
		}
		return handle;
	}
	
	public static void saveState(IMemento memento, JFreeChartEditorInputHandle inputHandle) {
		memento.createChild(ELEMENT_NAME);
		memento = memento.getChild(ELEMENT_NAME);
		memento.putInteger(INPUT_SIZE_KEY, inputHandle.getInputsSize());
		int i = 0;
		for (IDataSink input : inputHandle.getInputs()) {
			memento.putString(INPUT_NAME_KEY+i++, input.getClass().getCanonicalName());
			input.saveState(memento);
		}
	}

}
