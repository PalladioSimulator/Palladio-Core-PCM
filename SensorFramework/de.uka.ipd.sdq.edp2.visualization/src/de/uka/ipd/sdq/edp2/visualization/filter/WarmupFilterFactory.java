package de.uka.ipd.sdq.edp2.visualization.filter;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.FactoryAdapter;
import de.uka.ipd.sdq.edp2.visualization.FactoryConnector;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;
import de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory;
import de.uka.ipd.sdq.edp2.visualization.editors.HistogramEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotInput;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;

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
		
		FactoryConnector factoryConnector = new FactoryConnector();
		Object sourceFactory = factoryConnector.getAdapter(memento.getString(SOURCE_KEY),
				IElementFactory.class);
		
		IDataSource createdSource = (IDataSource) ((IElementFactory) sourceFactory)
		.createElement(memento);
		
		createdSource.addObserver(filter);
		filter.setSource(createdSource);
		filter.transformData();
		
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
