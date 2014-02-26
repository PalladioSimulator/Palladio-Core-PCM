package de.uka.ipd.sdq.edp2.ui.views.navigator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;

import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;
import de.uka.ipd.sdq.edp2.models.Repository.util.RepositorySwitch;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;

public class NavigatorTreeLabelProviderImpl extends StyledCellLabelProvider {
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	private IMapChangeListener mapChangeListener = new IMapChangeListener() {
		public void handleMapChange(MapChangeEvent event) {
			Set<?> affectedElements = event.diff.getChangedKeys();
			if (!affectedElements.isEmpty()) {
				LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
						NavigatorTreeLabelProviderImpl.this, affectedElements.toArray());
				fireLabelProviderChanged(newEvent);
			}
		}
	};

	public NavigatorTreeLabelProviderImpl(IObservableMap[] attributeMaps) {
		for (int i = 0; i < attributeMaps.length; i++) {
			attributeMaps[i].addMapChangeListener(mapChangeListener);
		}
	}

	@Override
	public String getToolTipText(Object element) {
		return "#dummy#";
	}

	@Override
	public void update(ViewerCell cell) {
		if (cell.getElement() instanceof EObject) {
			EObject eObject = (EObject) cell.getElement();
			StyledString styledString = null;
			styledString = new ExperimentDataSwitch<StyledString>() {
				public StyledString caseExperimentGroup(ExperimentGroup object) {
					StyledString styledString = new StyledString("Experiment Group");
					String decoration = " " + object.getPurpose() + " (" +object.getUuid() + ")";
					styledString.append(decoration, StyledString.COUNTER_STYLER);
					return styledString;
				};
				public StyledString caseExperimentSetting(ExperimentSetting object) {
					StyledString styledString = new StyledString(object.getDescription());
					return styledString;
				};
				public StyledString caseExperimentRun(ExperimentRun object) {
					StyledString styledString = new StyledString("Experiment Run " + dateFormat.format(object.getStartTime()));
					String decoration = " (" + object.getUuid() + ")";
					styledString.append(decoration, StyledString.COUNTER_STYLER);
					return styledString;
				};
				public StyledString caseMeasurementsRange(MeasurementsRange object) {
					StyledString styledString = new StyledString("Range");
					if (object.getStartTime() != null && object.getEndTime() != null) {
						String decoration = " (" + object.getStartTime() + "-" + object.getEndTime() + ")";
						styledString.append(decoration, StyledString.COUNTER_STYLER);
					}
					return styledString;
				};
				public StyledString caseRawMeasurements(RawMeasurements object) {
					StyledString styledString = new StyledString("Raw");
					String decoration = " (" + object.getDataSeries().size() + ")";
					styledString.append(decoration, StyledString.COUNTER_STYLER);
					return styledString;
				};
				public StyledString caseAggregatedMeasurements(AggregatedMeasurements object) {
					StyledString styledString = new StyledString("Aggregated");
					return styledString;
				};
				public StyledString caseEdp2Measure(de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure object) {
					StyledString styledString = new StyledString(object.getMeasuredObject()==null ? "Measure" : object.getMeasuredObject());
					String decoration = " (" + object.getMetric().getName() + ")";
					styledString.append(decoration, StyledString.COUNTER_STYLER);
					return styledString;
				};
				public StyledString caseMeasurements(Measurements object) {
					StyledString styledString = new StyledString("Measurement");
					return styledString;
				};
				public StyledString caseBaseMetricDescription(de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription object) {
					StyledString styledString = new StyledString(object.getName()==null? "Base Metric" : object.getName());
					String decoration = " (" + object.getScale() + ")";
					styledString.append(decoration, StyledString.COUNTER_STYLER);
					return styledString;
				};
				public StyledString caseNumericalBaseMetricDescription(de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription object) {
					StyledString styledString = new StyledString(object.getName()==null? "Base Metric" : object.getName());
					String decoration = " (" + object.getScale() + ", " + object.getDefaultUnit() + ")";
					styledString.append(decoration, StyledString.COUNTER_STYLER);
					return styledString;
				};
				public StyledString caseMetricDescription(de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription object) {
					StyledString styledString = new StyledString(object.getName()==null ? "Metric Set" : object.getName());
					return styledString;
				};
			}.doSwitch(eObject);
			if (styledString == null) { 
				styledString = new RepositorySwitch<StyledString>() {
					public StyledString caseLocalDirectoryRepository(de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository object) {
						StyledString styledString = new StyledString("Local File");
						String decoration = " (" + object.getUri() + ")";
						styledString.append(decoration, StyledString.COUNTER_STYLER);
						return styledString;
					};
					public StyledString caseLocalMemoryRepository(de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository object) {
						StyledString styledString = new StyledString("Local Memory");
						String decoration = " (" + object.getDomain() + ")";
						styledString.append(decoration, StyledString.COUNTER_STYLER);
						return styledString;
					};
					public StyledString caseRemoteCdoRepository(de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository object) {
						StyledString styledString = new StyledString("Remote");
						String decoration = " (" + object.getUrl() + ")";
						styledString.append(decoration, StyledString.COUNTER_STYLER);
						return styledString;
					};
					public StyledString caseLocalSensorFrameworkRepository(de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository object) {
						StyledString styledString = new StyledString("Local Sensor Framework V1");
						String decoration = " (" + object.getUri() + ")";
						styledString.append(decoration, StyledString.COUNTER_STYLER);
						return styledString;
					};
				}.doSwitch(eObject);
			}
			if (styledString == null) {
				Logger.getLogger(NavigatorTreeLabelProviderImpl.class.getCanonicalName()).log(Level.SEVERE, "Could not create label for " + eObject);
			} else {
				cell.setText(styledString.getString());
				//cell.setImage();
				cell.setStyleRanges(styledString.getStyleRanges());
			}
		}
	}
}
