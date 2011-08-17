package de.uka.ipd.sdq.edp2.transformation.adapter;

import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.FactoryConnector;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;
/**
 * A factory for {@link HistogramFrequencyAdapter} elements. Responsible for persistance and restoring.
 * @author Dominik Ernst
 *
 */
public class HistogramFrequencyAdapterFactory implements IElementFactory {

	private static Logger logger = Logger
			.getLogger(HistogramFrequencyAdapterFactory.class
					.getCanonicalName());
	/**
	 * The name of the child element/key under which this class is persisted in an {@link IMemento}.
	 */
	private final static String ELEMENT_NAME = "HistogramFrequencyAdapter";
	/**
	 * This factory's ID as it must be used when referenced in an extension.
	 */
	private final static String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.adapter.HistogramFrequencyAdapterFactory";

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IElementFactory#createElement(org.eclipse.ui.IMemento)
	 */
	@Override
	public IAdaptable createElement(IMemento memento) {
		// TODO Here should be a factory for all DataFlow elements
		memento = memento.getChild(ELEMENT_NAME);
		FactoryConnector factoryConnector = new FactoryConnector();
		Object sourceFactory = factoryConnector.getAdapter(memento
				.getString(PersistenceTag.SOURCE.getID()),
				IElementFactory.class);

		return new HistogramFrequencyAdapter(
				(IDataSource) ((IElementFactory) sourceFactory)
						.createElement(memento), memento
						.getInteger(PersistenceTag.DATA_SERIES_INDEX.getID()),
				memento.getInteger(PersistenceTag.NUMBER_OF_BINS.getID()));
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
	 *            Reference to the calling instance of
	 *            {@link HistogramFrequencyAdapter}.
	 * 
	 */
	public static void saveState(IMemento memento,
			HistogramFrequencyAdapter input) {

		memento.createChild(ELEMENT_NAME);
		memento = memento.getChild(ELEMENT_NAME);
		memento.putString(PersistenceTag.SOURCE.getID(), input.getSource()
				.getClass().getCanonicalName());
		memento.putInteger(PersistenceTag.DATA_SERIES_INDEX.getID(), input
				.getDataSeriesIndex());
		memento.putInteger(PersistenceTag.NUMBER_OF_BINS.getID(), input
				.getNumberOfBins());
		input.getSource().saveState(memento);

	}

}
