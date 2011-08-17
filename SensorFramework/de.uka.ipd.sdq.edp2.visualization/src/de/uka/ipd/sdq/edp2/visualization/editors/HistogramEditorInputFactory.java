package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.FactoryConnector;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;

/**
 * Factory for {@link ScatterPlotInput}. Also manages persistence of instances
 * of {@link ScatterPlotInput}.
 * 
 * @author ernst
 * 
 */
public class HistogramEditorInputFactory implements IElementFactory {

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
		// TODO Here should be a factory for all DataFlow elements
		FactoryConnector factoryConnector = new FactoryConnector();
		Object sourceFactory = factoryConnector.getAdapter(memento
				.getString(PersistenceTag.SOURCE.getID()),
				IElementFactory.class);
		return new HistogramEditorInput(
				(IDataSource) ((IElementFactory) sourceFactory)
						.createElement(memento));
	}

	/**
	 * 
	 * @return this factory's ID.
	 */
	public static String getFactoryId() {
		return FACTORY_ID;
	}

	/**
	 * Method for writing the current instance of {@link HistogramEditorInput}
	 * to the memento.
	 * 
	 * @param memento
	 *            Reference to the memento, passed as a parameter by the
	 *            {@link IPersistableElement#saveState(IMemento)} method in
	 *            {@link HistogramEditorInput}
	 * @param input
	 *            Reference to the calling instance of
	 *            {@link HistogramEditorInput}.
	 */
	public static void saveState(IMemento memento, HistogramEditorInput input) {
		memento.putString(PersistenceTag.SOURCE.getID(), input.getSource()
				.getClass().getCanonicalName());
		input.getSource().saveState(memento);
	}

}
