package simurex;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import flanagan.complex.Complex;


public class Monitoring {

	public ArrayList measuredValues = new ArrayList();

	public void addValue(double value) {
		measuredValues.add(value);
	}


	public IProbabilityDensityFunction getDistFunc(double distance) {

		Hashtable resultMap = new Hashtable();
		// key = measurement, value = probability

		double singleProb = (double) 1 / measuredValues.size();
		double largestMeas = 0;

		for (int i = 0; i < measuredValues.size(); i++) {
			double value = (Double) measuredValues.get(i);
			long pos = Math.round((double) value / distance);

			if (pos > largestMeas)
				largestMeas = pos;

			if (resultMap.containsKey(pos)) {
				double prob = (Double) resultMap.get(pos);
				resultMap.put(pos, prob + singleProb);
			} else {
				resultMap.put(pos, singleProb);
			}
		}

		List<Complex> pointList = new ArrayList<Complex>();
		for (int j = 0; j <= largestMeas; j++) {
			Complex point = new Complex();
			point.setReal(0.0);
			point.setImag(0.0);
			if (resultMap.containsKey((long) j)) {
				double prob = (Double) resultMap.get((long) j);
				point.setReal(prob);
			}
			pointList.add(point);
		}
		
		IUnit unit = IProbabilityFunctionFactory.eINSTANCE.createUnit("ms");

		return IProbabilityFunctionFactory.eINSTANCE.createSamplePDFFromComplex(distance, pointList,false,unit);
	}

}
