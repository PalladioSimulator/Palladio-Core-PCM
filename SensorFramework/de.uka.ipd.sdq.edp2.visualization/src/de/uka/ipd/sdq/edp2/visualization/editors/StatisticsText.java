package de.uka.ipd.sdq.edp2.visualization.editors;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.measure.Measure;

import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
/**
 * 
 * @author Dominik Ernst
 *
 */
public class StatisticsText implements de.uka.ipd.sdq.edp2.visualization.IVisualization {

	protected IDataSource source;
	protected ArrayList<MetricDescription> roles;

	public void output() {
		PrintWriter out = new PrintWriter(System.err);
		out.print(printStoredMeasurements());
	}

	@SuppressWarnings("unchecked")
	private String printStoredMeasurements() {
		String result = "";
		
		MetricDescription metric = source.getMeasurementsRange().getMeasurements().getMeasure().getMetric();
		result += metric.getName() + "\n";
		result += "canAccept() liefert: " + source +"\n";
		
		ArrayList<OrdinalMeasurementsDao<Measure>> list = new ArrayList<OrdinalMeasurementsDao<Measure>>();
		for (DataSeries data : source.getOutput()) {
			list.add(MeasurementsUtility.getOrdinalMeasurementsDao(data));
		}
		
		OrdinalMeasurementsDao<Measure> omdSeries1 = MeasurementsUtility
				.getOrdinalMeasurementsDao(source.getOutput().get(0));
		OrdinalMeasurementsDao<Measure> omdSeries2 = MeasurementsUtility
				.getOrdinalMeasurementsDao(source.getOutput().get(1));

		List<Measure> list1 = omdSeries1.getMeasurements();
		List<Measure> list2 = omdSeries2.getMeasurements();
		for (int pos = 0; pos < list1.size(); pos++) {
			result += list1.get(pos) + "\t" + list2.get(pos) + "\n";
		}
		return result;
	}

	@Override
	public void restoreState(IMemento memento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveState(IMemento memento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getContributorId() {
		// TODO Auto-generated method stub
		return null;
	}

}
