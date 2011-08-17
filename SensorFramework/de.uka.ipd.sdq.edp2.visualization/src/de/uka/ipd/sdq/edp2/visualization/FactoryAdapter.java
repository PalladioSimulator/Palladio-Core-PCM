package de.uka.ipd.sdq.edp2.visualization;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IElementFactory;

import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2Source;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2SourceFactory;
import de.uka.ipd.sdq.edp2.visualization.editors.PieChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.PieChartEditorInputFactory;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotInput;
import de.uka.ipd.sdq.edp2.visualization.editors.ScatterPlotInputFactory;
import de.uka.ipd.sdq.edp2.visualization.filter.TeardownFilter;
import de.uka.ipd.sdq.edp2.visualization.filter.TeardownFilterFactory;
import de.uka.ipd.sdq.edp2.visualization.filter.WarmupFilterFactory;
import de.uka.ipd.sdq.edp2.visualization.filter.WarmupFilter;
/**
 * FIXME DELETEME - I get replaced by {@link FactoryConnector}.
 * @author ernst
 *
 */
public class FactoryAdapter implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IElementFactory.class) {
			if (adaptableObject == EDP2Source.class)
				return new EDP2SourceFactory();
			if (adaptableObject == PieChartEditorInput.class)
				return new PieChartEditorInputFactory();
			if (adaptableObject == ScatterPlotInput.class)
				return new ScatterPlotInputFactory();
			if (adaptableObject == WarmupFilter.class)
				return new WarmupFilterFactory();
			if (adaptableObject == TeardownFilter.class)
				return new TeardownFilterFactory();
			// TODO for persistence, there must be another way to dynamically
			// get the factories --> extension points!?
			// if (adaptableObject == HistogramFrequencyAdapter.class)
			// return new HistogramFrequencyAdapterFactory();
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return null;
	}

}
