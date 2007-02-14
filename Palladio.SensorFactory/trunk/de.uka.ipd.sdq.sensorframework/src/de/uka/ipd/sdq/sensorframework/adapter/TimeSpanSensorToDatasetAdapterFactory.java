package de.uka.ipd.sdq.sensorframework.adapter;

import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;

public class TimeSpanSensorToDatasetAdapterFactory implements IAdapterFactory {

	public static final int HISTOGRAM_CLASS_WIDTH = 1;

	public boolean canAdapt(Class fromClass, Class targetClass) {
		if (TimeSpanSensor.class.isAssignableFrom(fromClass)
				&& targetClass == XYSeries.class)
			return true;
		return false;
	}

	public Object getAdapter(Object adaptee, Class targetClass) {
		TimeSpanSensor s = (TimeSpanSensor) adaptee;
		XYSeries series = new XYSeries(s.getSensorName()+" [ID: "+s.getSensorID()+"]", true, false);
		for (TimeSpanMeasurement ts : new TimeSpanMeasurement[0] /*TODO!!!*/) {
			int histogramClass = (int)((ts.getTimeSpan()+HISTOGRAM_CLASS_WIDTH/2) / HISTOGRAM_CLASS_WIDTH);
			int index = series.indexOf(histogramClass*HISTOGRAM_CLASS_WIDTH);
			if (index >= 0)
			{
				Number oldValue = series.getY(index);
				series.update(index,(Number)(oldValue.intValue()+1));
			}
			else
				series.add(histogramClass*HISTOGRAM_CLASS_WIDTH,(double)1);
		}
		return normalizeSeries(series);
	}

	private XYSeries normalizeSeries(XYSeries series)
	{
		XYSeries result = new XYSeries(series.getKey(),true,false);
		int numberOfObservations = 0;
		XYSeries workingSeries = null;
		try {
			workingSeries = (XYSeries) series.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		for (int i = 0, n=workingSeries.getItemCount(); i < n; i++)
		{
			numberOfObservations += workingSeries.getDataItem(i).getY().intValue();
		}
		for (int i = 0, n=workingSeries.getItemCount(); i < n; i++)
		{
			Number x = workingSeries.getDataItem(i).getX();
			double y = workingSeries.getDataItem(i).getY().doubleValue()/numberOfObservations;
			result.add(new XYDataItem(x,y));
		}
		return result;
	}
	
}
