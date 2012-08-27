package de.uka.ipd.sdq.edp2.visualization.inputs;

import java.util.HashMap;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableEditor;

import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.FactoryConnector;
import de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory;

/**
 * Factory for {@link HistogramEditorInput}. Also manages persistence of instances
 * of {@link HistogramEditorInput}.
 * 
 * @author Dominik Ernst
 * 
 */
public class HistogramEditorInputFactory extends ElementFactory {
	
	/**
	 * Logger for this class.
	 */
	private static Logger logger = Logger
			.getLogger(HistogramEditorInputFactory.class.getCanonicalName());
	/**
	 * The factory's ID. Must match the ID specified in the extension point
	 * "org.eclipse.ui.elementFactories".
	 */
	private static final String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.inputs.HistogramEditorInput";

	/**
	 * Method for restoring {@link HistogramEditorInput} elements. Should call
	 * {@link AbstractDataSource#saveState(IMemento)} of the associated source.
	 * 
	 * @param memento the {@link IMemento} passed on
	 *            by {@link IPersistableEditor#restoreState(IMemento)}
	 * @return Restored {@link ScatterPlotInput} with non-{@code null} reference to the
	 *         {@link AbstractDataSource}
	 */
	public IAdaptable createElement(IMemento memento) {
		HistogramEditorInput histogramInput = new HistogramEditorInput();
		
		HashMap<String, Object> restoredProperties = histogramInput.getProperties();
		memento = memento.getChild(restoredProperties.get(ELEMENT_KEY)
				.toString());
		//default properties are overridden with persisted properties from the memento
		overrideFromMemento(memento, restoredProperties);
		//properties are set for the restored element
		histogramInput.setProperties(restoredProperties);
		
		Object sourceFactory = FactoryConnector.instance.getAdapter(memento.getString(SOURCE_KEY),
				IElementFactory.class);
		
		AbstractDataSource createdSource = (AbstractDataSource) ((IElementFactory) sourceFactory)
		.createElement(memento);
		
		histogramInput.setSource(createdSource);
		
		return histogramInput;
	}
	/**
	 * @return this factory's ID.
	 */
	public static String getFactoryId() {
		return FACTORY_ID;
	}

}
