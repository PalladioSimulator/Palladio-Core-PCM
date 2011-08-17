package de.uka.ipd.sdq.edp2.visualization.datasource;

import java.util.HashMap;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;

/**
 * Factory, which persists and creates {@link EDP2Source} elements.
 * 
 * @author Dominik Ernst
 * 
 */
public class EDP2SourceFactory extends ElementFactory {
	/**
	 * The factory's ID. Must match the ID specified in the extension point
	 * "org.eclipse.ui.elementFactories".
	 */
	private static final String FACTORY_ID = "de.uka.ipd.sdq.edp2.editor.EDP2SourceFactory";
	/**
	 * Name of the managed element.
	 */
	private static final String ELEMENT_NAME = "EDP2Source";
	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(EDP2SourceFactory.class.getCanonicalName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IElementFactory#createElement(org.eclipse.ui.IMemento)
	 */
	@Override
	public IAdaptable createElement(IMemento memento) {
		EDP2Source source = new EDP2Source();
		memento = memento.getChild(ELEMENT_NAME);
	
		HashMap<String, Object> restoredProperties = new HashMap<String, Object>();
		for (Object key : source.getProperties().keySet()){
			restoredProperties.put(key.toString(), memento.getString(key.toString()));
		}
		source.setProperties(restoredProperties);
		return source;
	}
	
	/**
	 * @return this factory's ID.
	 */
	public static String getFactoryId() {
		return FACTORY_ID;
	}

}
