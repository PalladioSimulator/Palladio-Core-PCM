package de.uka.ipd.sdq.edp2.visualization.filter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.FactoryAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotInput;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;

/**
 * 
 * @author Dominik Ernst
 * 
 */
public class TeardownFilterFactory implements IElementFactory {

	private static Logger logger = Logger.getLogger(TeardownFilterFactory.class
			.getCanonicalName());
	private final static String ELEMENT_NAME = "TeardownFilter";
	private final static String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.filter.TeardownFilterFactory";

	@Override
	public IAdaptable createElement(IMemento memento) {
		// TODO Here should be a factory for all DataFlow elements
		memento = memento.getChild(ELEMENT_NAME);
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
		return new TeardownFilter(
				(IDataSource) ((IElementFactory) sourceFactory)
						.createElement(memento), memento
						.getInteger(PersistenceTag.DROPPED_VALUES_ABS.getID()),
				memento.getFloat(PersistenceTag.DROPPED_VALUES_REL.getID()));
	}

	/**
	 * 
	 * @return this factory's ID.
	 */
	public static String getFactoryId() {
		return FACTORY_ID;
	}

	/**
	 * Method for persisting implementations of of {@link IFilter} to the
	 * memento.
	 * 
	 * 
	 * @param memento
	 *            Reference to the memento, passed as a parameter by the
	 *            {@link IPersistableElement#saveState(IMemento)} method.
	 * @param input
	 *            Reference to the calling instance of {@link ScatterPlotInput}.
	 * 
	 */
	public static void saveState(IMemento memento, IFilter input) {

		if (input instanceof TeardownFilter) {
			TeardownFilter inputTierdownFilter = (TeardownFilter) input;
			memento.createChild(ELEMENT_NAME);
			memento = memento.getChild(ELEMENT_NAME);
			memento.putString(PersistenceTag.SOURCE.getID(),
					inputTierdownFilter.getSource().getClass()
							.getCanonicalName());
			memento.putInteger(PersistenceTag.DROPPED_VALUES_ABS.getID(),
					inputTierdownFilter.getDroppedValues());
			memento.putFloat(PersistenceTag.DROPPED_VALUES_REL.getID(),
					inputTierdownFilter.getDroppedValuesPercentage());
			inputTierdownFilter.getSource().saveState(memento);
			logger.log(Level.INFO, "saveState()");
		}

	}

}
