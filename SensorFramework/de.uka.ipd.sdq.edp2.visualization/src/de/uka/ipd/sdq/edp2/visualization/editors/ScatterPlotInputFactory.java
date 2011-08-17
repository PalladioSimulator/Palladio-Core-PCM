package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.FactoryAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;

/**
 * Factory for {@link ScatterPlotInput}. Also manages persistence of instances
 * of {@link ScatterPlotInput}.
 * 
 * @author Dominik Ernst
 * 
 */
public class ScatterPlotInputFactory implements IElementFactory {

	private static Logger logger = Logger
			.getLogger(ScatterPlotInputFactory.class.getCanonicalName());
	/**
	 * The factory's ID. Must match the ID specified in the extension point
	 * "org.eclipse.ui.elementFactories".
	 */
	private static final String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotInputFactory";

	/**
	 * Method for restoring {@link ScatterPlotInput} elements. Should call
	 * {@link IDataSource#saveState(IMemento)} of the associated source.
	 * 
	 * @param memento the {@link IMemento} passed on
	 *            by {@link IPersistableEditor#restoreState(IMemento)}
	 * @return Restored {@link ScatterPlotInput} with non-null reference to the
	 *         {@link IDataSource}
	 */
	public IAdaptable createElement(IMemento memento) {
		// TODO Here should be a factory for all DataFlow elements
		FactoryAdapter factoryAdapter = new FactoryAdapter();
		Object sourceFactory = null;
		try {
			sourceFactory = factoryAdapter.getAdapter(Class.forName(memento
					.getString(PersistenceTag.SOURCE.getID())),
					IElementFactory.class);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ScatterPlotInput(
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
	 * Method for writing the current instance of {@link ScatterPlotInput} to
	 * the memento.
	 * 
	 * @param memento
	 *            Reference to the memento, passed as a parameter by the
	 *            {@link IPersistableElement#saveState(IMemento)} method in
	 *            {@link ScatterPlotInput}
	 * @param input
	 *            Reference to the calling instance of {@link ScatterPlotInput}.
	 */
	public static void saveState(IMemento memento, ScatterPlotInput input) {
		memento.putString(PersistenceTag.SOURCE.getID(), input.getSource()
				.getClass().getCanonicalName());
		input.getSource().saveState(memento);
		logger.log(Level.INFO, "saveState()");
	}

}
