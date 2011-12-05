package de.uka.ipd.sdq.edp2.transformation.filter;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.edp2.visualization.FactoryConnector;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory;

/**
 * Factory for {@link WarmupFilter} elements. Responsible for persistence and restoring.
 * @author Dominik Ernst
 *
 */
public class WarmupFilterFactory extends ElementFactory{

	private static Logger logger = Logger.getLogger(WarmupFilterFactory.class
			.getCanonicalName());

	private final static String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.filter.WarmupFilterFactory";

	public IAdaptable createElement(IMemento memento) {
		WarmupFilter filter = new WarmupFilter();
		
		HashMap<String, Object> restoredProperties = filter.getProperties();
		memento = memento.getChild(restoredProperties.get(ELEMENT_KEY)
				.toString());
		//default properties are overridden with persisted properties from the memento
		overrideFromMemento(memento, restoredProperties);
		//properties are set for the restored element
		filter.setProperties(restoredProperties);
		
		FactoryConnector factoryConnector = FactoryConnector.getInstance();
		Object sourceFactory = factoryConnector.getAdapter(memento.getString(SOURCE_KEY),
				IElementFactory.class);
		
		AbstractDataSource createdSource = (AbstractDataSource) ((IElementFactory) sourceFactory)
		.createElement(memento);
		
		logger.log(Level.INFO, "Created source of WarmupFilter: "+createdSource.toString());
		
		filter.setSource(createdSource);
		
		return filter;
	}
	/**
	 * 
	 * @return this factory's ID.
	 */
	public static String getFactoryId() {
		return FACTORY_ID;
	}

}
