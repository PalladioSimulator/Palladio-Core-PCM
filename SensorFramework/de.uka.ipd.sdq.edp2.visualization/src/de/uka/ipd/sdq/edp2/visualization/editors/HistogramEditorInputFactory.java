package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.FactoryConnector;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;

/**
 * Factory for {@link ScatterPlotInput}. Also manages persistence of instances
 * of {@link ScatterPlotInput}.
 * 
 * @author ernst
 * 
 */
public class HistogramEditorInputFactory extends ElementFactory {

	private static Logger logger = Logger
			.getLogger(HistogramEditorInputFactory.class.getCanonicalName());
	/**
	 * The factory's ID. Must match the ID specified in the extension point
	 * "org.eclipse.ui.elementFactories".
	 */
	private static final String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.editors.HistogramEditorInputFactory";

	/**
	 * Method for restoring {@link HistogramEditorInput} elements. Should call
	 * {@link IDataSource#saveState(IMemento)} of the associated source.
	 * 
	 * @param memento the {@link IMemento} passed on
	 *            by {@link IPersistableEditor#restoreState(IMemento)}
	 * @return Restored {@link ScatterPlotInput} with non-{@code null} reference to the
	 *         {@link IDataSource}
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
		
		FactoryConnector factoryConnector = new FactoryConnector();
		Object sourceFactory = factoryConnector.getAdapter(memento.getString(SOURCE_KEY),
				IElementFactory.class);
		
		IDataSource createdSource = (IDataSource) ((IElementFactory) sourceFactory)
		.createElement(memento);
		
		logger.log(Level.INFO, "Created source of EditorInput: "+createdSource.toString());
		
		createdSource.addObserver(histogramInput);
		histogramInput.setSource(createdSource);
		histogramInput.updateDataset();
		
		return histogramInput;
	}
	/**
	 * @return this factory's ID.
	 */
	public static String getFactoryId() {
		return FACTORY_ID;
	}

}
