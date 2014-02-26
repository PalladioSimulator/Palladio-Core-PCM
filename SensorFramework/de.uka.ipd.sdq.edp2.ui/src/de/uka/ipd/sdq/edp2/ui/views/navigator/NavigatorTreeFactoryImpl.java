package de.uka.ipd.sdq.edp2.ui.views.navigator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.list.ComputedList;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;

import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;

public class NavigatorTreeFactoryImpl implements IObservableFactory {

	@Override
	public IObservable createObservable(Object target) {
		if (target instanceof IObservableList) {
			return (IObservable) target;
		} else if (target instanceof Repository) {
			return EMFProperties.list(
					RepositoryPackage.Literals.REPOSITORY__EXPERIMENT_GROUPS).observe(
					target);
		} else if (target instanceof ExperimentGroup) {
			IObservable iobs = EMFProperties
					.list(
							ExperimentDataPackage.Literals.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS)
					.observe(target);
			return iobs;
		} else if (target instanceof ExperimentSetting) {
			IObservable iobs = EMFProperties.list(
					ExperimentDataPackage.Literals.EXPERIMENT_SETTING__EXPERIMENT_RUNS)
					.observe(target);
			return iobs;
		} else if (target instanceof ExperimentRun) {
			final Object target2 = target;
			return new ComputedList() {
				private IObservableList list = EMFProperties.list(ExperimentDataPackage.Literals.EXPERIMENT_RUN__MEASUREMENTS).observe(target2);
				private Map<Measurements, IObservableList> listMap = new HashMap<Measurements, IObservableList>();

				{
					list.addListChangeListener(new IListChangeListener() {

						@Override
						public void handleListChange(ListChangeEvent event) {
							event.diff.accept(new ListDiffVisitor() {
								@Override
								public void handleRemove(int index,
										Object element) {
									listMap.remove(element).dispose();
								}

								@Override
								public void handleAdd(int index, Object element) {
									// TODO: Check if working
								}
							});
						}
					});
				}

				@Override
				protected List calculate() {
					List<Object> union = new ArrayList<Object>();
					for (Object measurement: list) {
						IObservableList sublist = listMap.get(measurement);
						if (sublist != null) {
							union.addAll(sublist);
						} else {
							IObservableList obsList = EMFProperties.list(
									ExperimentDataPackage.Literals.MEASUREMENTS__MEASUREMENTS_RANGES).observe(measurement);
							listMap.put((Measurements) measurement, obsList);
							union.addAll(obsList);
						}
					}
					return union;
				}
			};
		} else if (target instanceof MeasurementsRange) {
			final Object target2 = target;
			return new ComputedList() {
				private IObservableList list = EMFProperties.list(ExperimentDataPackage.Literals.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS).observe(target2);
				private IObservableValue value = EMFProperties.value(ExperimentDataPackage.Literals.MEASUREMENTS_RANGE__RAW_MEASUREMENTS).observe(target2);
				@Override
				protected List calculate() {
					List<Object> union = new ArrayList<Object>();
					union.addAll(list);
					if (value != null) {
						union.add(value.getValue());
					}
					return union;
				}
			};
		} else if (target instanceof RawMeasurements) {
			return valueToCollection(EMFProperties.value(
						FeaturePath
								.fromList(
										ExperimentDataPackage.Literals.RAW_MEASUREMENTS__MEASUREMENTS_RANGE,
										ExperimentDataPackage.Literals.MEASUREMENTS_RANGE__MEASUREMENTS,
										ExperimentDataPackage.Literals.MEASUREMENTS__MEASURE))
						.observe(target));
		} else if (target instanceof Edp2Measure) {
			return valueToCollection(EMFProperties.value(FeaturePath.fromList(ExperimentDataPackage.Literals.EDP2_MEASURE__METRIC)).observe(target));
		} else if (target instanceof AggregatedMeasurements) {
			//TODO implement
			return null;
		} else if (target instanceof MetricSetDescription) {
			return EMFProperties.list(ExperimentDataPackage.Literals.METRIC_SET_DESCRIPTION__SUBSUMED_METRICS).observe(target);
		} else if (target instanceof BaseMetricDescription) {
			return null;
		}
		return null;
	}

	/**Wraps an observable value in an observable collection. 
	 * @param value Value which should be contained in the collection.
	 * @return Collection containing the value.
	 */
	private IObservableCollection valueToCollection(IObservableValue value) {
		final IObservableValue finalValue = value;
		return new ComputedList() {
			@Override
			protected List calculate() {
				List<Object> union = new ArrayList<Object>();
				if (finalValue != null) {
					union.add(finalValue.getValue());
				}
				return union;
			}
		};
	}
}
