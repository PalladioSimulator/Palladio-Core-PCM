package de.uka.ipd.sdq.edp2.visualization.datasource;

import java.util.HashMap;
import java.util.logging.Logger;

import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.IDataFlow;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;

/**
 * A factory for persistence of {@link IDataFlow} elements.
 * 
 * @author Dominik Ernst
 * 
 */
public abstract class ElementFactory implements IElementFactory {

	/**
	 * Logger for this class.
	 */
	private static Logger logger = Logger.getLogger(ElementFactory.class
			.getCanonicalName());
	/**
	 * The name of the source element under which an elements' source is
	 * persisted in an {@link IMemento}.
	 */
	public final static String SOURCE_KEY = "source";
	/**
	 * Key for retrieving an element's name from its properties.
	 */
	public final static String ELEMENT_KEY = "elementName";
	/**
	 * This factory's ID as it must be used when referenced in an extension.
	 */
	private final static String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory";

	/**
	 * @return this factory's ID.
	 */
	public static String getFactoryId() {
		return FACTORY_ID;
	}

	/**
	 * Method for persisting any kind of data-related elements, i.e.
	 * implementations of {@link IDataFlow}.
	 * 
	 * @param memento
	 *            Reference to the memento, passed as a parameter by the
	 *            {@link IPersistableElement#saveState(IMemento)} method.
	 * @param input
	 *            Reference to the calling instance of {@link IDataFlow}.
	 * 
	 */
	public static void saveState(IMemento memento, IDataFlow input) {
		// get name of element to be persisted from its properties
		HashMap<String, Object> props = input.getProperties();
		String elementName = props.get(ELEMENT_KEY).toString();
		// create a new node in the memento named after the element
		memento.createChild(elementName);
		memento = memento.getChild(elementName);
		
		props.remove(ELEMENT_KEY);
		// save all properties TODO elements name is both as an attribute and
		// xml-element's name persisted
		for (String key : props.keySet()) {
			memento.putString(key, props.get(key).toString());
		}
		// if the input is a sink, there are further elements that must be
		// persisted
		IDataSink sinkInput = null;
		if (input instanceof IDataSink) {
			sinkInput = (IDataSink) input;
			memento.putString(SOURCE_KEY, sinkInput.getSource().getClass()
					.getCanonicalName());
			sinkInput.getSource().saveState(memento);
		}
	}

	/**
	 * Method used during restoration of persisted elements. It is the same for
	 * all implementations of {@link IDataFlow}.
	 * 
	 * @param memento
	 *            the {@link IMemento} from which the properties are read
	 * @param propertiesToOverride
	 *            the properties in which the values are to be replaced
	 */
	protected static void overrideFromMemento(IMemento memento,
			HashMap<String, Object> propertiesToOverride) {
		//don't replace the element name, it is not persisted and shouldn't be altered anyways
		propertiesToOverride.remove(ELEMENT_KEY);
		for (Object key : propertiesToOverride.keySet()) {
			propertiesToOverride.put(key.toString(), memento.getString(key
					.toString()));
		}
	}

}
