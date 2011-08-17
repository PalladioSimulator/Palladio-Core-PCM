/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2SourceFactory;

/**
 * FIXME not up-to-date
 * @author Dominik Ernst
 *
 */
public class PieChartEditorInputFactory implements IElementFactory {
	
	private static Logger logger = Logger
	.getLogger(PieChartEditorInputFactory.class.getCanonicalName());
	
	private static final String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.editors.PieChartInputFactory";
	private static final String TAG_SOURCE = "source";
	private static final String TAG_CLASS = "class";
	private static final String TAG_NAME = "PieChartEditorInput";
	
	/**
	 * Method for restoring {@link PieChartEditorInput} elements. Should call {@link IDataSource#saveState(IMemento)}
	 * of the associated source.
	 * @param memento the {@link IMemento} passed on
	 *            by {@link IPersistableEditor#restoreState(IMemento)}
	 * @return Restored {@link PieChartEditorInput} with non-null reference to the {@link IDataSource}
	 */
	@Override
	public IAdaptable createElement(IMemento memento) {
		//TODO Here should be a factory for all DataFlow elements
		EDP2SourceFactory factory = new EDP2SourceFactory();
		return new PieChartEditorInput((IDataSource) factory
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
	 * Method for writing the current instance of {@link PieChartEditorInput}
	 * to the memento for restoring it when the workbench is reopened.
	 * 
	 * @param memento
	 *            Reference to the memento, passed as a parameter by the
	 *            {@link IPersistableElement#saveState(IMemento)} method in
	 *            {@link PieChartEditorInput}
	 * @param input
	 *            Reference to the calling instance of
	 *            {@link PieChartEditorInput}.
	 */
	public static void saveState(IMemento memento, PieChartEditorInput input) {
		memento.putString(TAG_SOURCE, input.getSource().toString());
		input.getSource().saveState(memento);
		logger.log(Level.INFO, "saveState()");
	}

}
