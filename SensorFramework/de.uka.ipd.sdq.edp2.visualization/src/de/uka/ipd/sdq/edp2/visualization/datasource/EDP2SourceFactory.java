package de.uka.ipd.sdq.edp2.visualization.datasource;

import java.util.HashMap;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IMemento;

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
		// specific element is created and default properties are retrieved
		EDP2Source source = new EDP2Source();
		HashMap<String, Object> restoredProperties = source.getProperties();
		// default properties are overridden with persisted properties from the
		// memento
		memento = memento.getChild(restoredProperties.get(ELEMENT_KEY)
				.toString());
		overrideFromMemento(memento, restoredProperties);
		//properties are set for the restored element
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
