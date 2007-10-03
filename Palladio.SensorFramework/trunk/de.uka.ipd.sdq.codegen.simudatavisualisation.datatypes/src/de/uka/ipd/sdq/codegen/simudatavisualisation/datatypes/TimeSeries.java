package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.util.ArrayList;
import java.util.List;

public class TimeSeries {
	private String myLabel;
	
	List<TimeSeriesEntity> values = new ArrayList<TimeSeriesEntity>();

	public TimeSeries(String myLabel) {
		super();
		this.myLabel = myLabel;
	}

	public String getLabel() {
		return myLabel;
	}

	public void setLabel(String newLabel) {
		myLabel=newLabel;
	}

	public List<TimeSeriesEntity> getValues() {
		return values;
	}

	public void setValues(List<TimeSeriesEntity> values) {
		this.values = values;
	}

	public void add(double x, double y) {
		values.add(new TimeSeriesEntity(x,y));
	}
	
	@Override
	public String toString() {
		String result = this.myLabel + "\n";
		for (TimeSeriesEntity e : this.values) {
			result += e + "\n";
		}
		return result;
	}
}
