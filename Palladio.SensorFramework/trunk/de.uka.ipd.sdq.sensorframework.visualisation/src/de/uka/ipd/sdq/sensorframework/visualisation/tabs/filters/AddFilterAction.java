/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;
import de.uka.ipd.sdq.sensorframework.filter.AbstractMeasurementsFilter;
import de.uka.ipd.sdq.sensorframework.filter.FilterRegistry;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ActionListSelectionDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ViewAndAdapterFactory;

/**
 * @author Roman Andrej
 *
 */
public class AddFilterAction extends SelectionAdapter {
	
	private AbstractMeasurementsFilter filter = null;

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent event) {
		ActionListSelectionDialog dialog = new ActionListSelectionDialog(
				event.display.getActiveShell(), new FilterLabelProvider(), 250, 200);
		dialog.setElements(getDefinedFilters());
		dialog.open();
		Object[] results = dialog.getResult();
		
		if (results != null)
			filter = (AbstractMeasurementsFilter) results[0];
		Assert.isNotNull(filter);
		addFilter(filter);
	}
	
	private Object[] getDefinedFilters() {

		List<AbstractMeasurementsFilter> result = FilterRegistry
				.singleton().getAllAvailableFilters();

		return result.toArray();
	}
	
	private void addFilter(AbstractMeasurementsFilter filter){
		IAdapterFactory adapterFactory = AdapterRegistry.singleton().getFactoryByID(
				VisualisationPlugin.FILTER_FACTORY_ID);
		adapterFactory.getAdapter(filter);
	}
}

/** The Class define the LabelProvider for ActionListSelectionDialog. */
class FilterLabelProvider1 extends LabelProvider {
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof AbstractMeasurementsFilter) {
			AbstractMeasurementsFilter filter = (AbstractMeasurementsFilter) element;
			return filter.getClass().getSimpleName();
		}
		return super.getText(element);
	}
}
