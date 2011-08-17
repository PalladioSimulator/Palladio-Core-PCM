package de.uka.ipd.sdq.edp2.visualization.datasource;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.FactoryConnector;
import de.uka.ipd.sdq.edp2.visualization.IDataFlow;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;

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
	 * A central {@link FactoryConnector}.
	 */
	protected final static FactoryConnector factoryConnector = new FactoryConnector();
	/**
	 * The name of the source element under which an elements' source is
	 * persisted in an {@link IMemento}.
	 */
	private final static String SOURCE_KEY = "source";
	/**
	 * Key for retrieving an elements' name from its properties.
	 */
	private final static String ELEMENT_KEY = "elementName";
	/**
	 * This factory's ID as it must be used when referenced in an extension.
	 */
	private final static String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory";

	/**
	 * 
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
		logger.log(Level.INFO, "savestate ElementFactory");
		HashMap<String, Object> props = input.getProperties();
		String elementName = props.get(ELEMENT_KEY).toString();
		memento.createChild(elementName);
		memento = memento.getChild(elementName);
		for (String key : props.keySet()) {
			memento.putString(key, props.get(key).toString());
		}

		IDataSink sinkInput = null;
		if (input instanceof IDataSink) {
			logger.log(Level.INFO, "found a sink");
			sinkInput = (IDataSink) input;
			memento.putString(SOURCE_KEY, sinkInput.getSource().getClass()
					.getCanonicalName());
			sinkInput.getSource().saveState(memento);
		}
	}

}
