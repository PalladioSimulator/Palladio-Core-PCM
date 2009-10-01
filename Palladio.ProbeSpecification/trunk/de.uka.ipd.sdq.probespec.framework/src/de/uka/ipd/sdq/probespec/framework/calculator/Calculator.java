package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.exceptions.CalculatorException;

/**
 * This class is the abstract super class for all Calculator implementations.
 * All specific Calculators have to inherit from this class.
 * 
 * @author Faber
 * 
 */
public abstract class Calculator implements Observer {
	protected SampleBlackboard blackboard;
	protected PipesAndFiltersManager pipesAndFiltersManager;

	private Vector<MeasurementMetric> measurementMetrics = null;

	protected Calculator(SampleBlackboard blackboard) {
		super();
		this.blackboard = blackboard;
		this.measurementMetrics = getConcreteMeasurementMetrics();
		blackboard.addObserver(this);
	}

	/**
	 * This method is called to return meta data about the result tuples of the
	 * calculator. E.g. it is used initialize the pipe and filter chain.
	 * 
	 * @return
	 */
	public Vector<MeasurementMetric> getMeasurementMetrics() {
		return measurementMetrics;
	}

	/**
	 * The update method is called by the SampleBlackboard (observable entity)
	 * containing all ProbeSetSamples. The method casts the two objects and then
	 * calls the execute method of the specific calculator
	 * 
	 * TODO If a logging framework is added to this project, handle the
	 * exception below correctly.
	 * 
	 * @param o
	 *            The observable object (SampleBlackboard)
	 * @param arg
	 *            The ProbeSetSample object written on the SampleBlackboard
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof SampleBlackboard && arg instanceof ProbeSetSample) {
			ProbeSetSample pss = (ProbeSetSample) arg;
			try {
				execute(pss);
			} catch (CalculatorException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * This method should be used to set the manager for the pipe and filter
	 * chain. The specific Calculator will use this reference as receiver for
	 * the result tuple.
	 * 
	 * @param pipesAndFiltersManager
	 *            This is a reference to the manager of the pipe and filter
	 *            chain.
	 */
	public void setPipesAndFiltersManager(
			PipesAndFiltersManager pipesAndFiltersManager) {
		this.pipesAndFiltersManager = pipesAndFiltersManager;
	}

	abstract protected void execute(ProbeSetSample pss)
			throws CalculatorException;

	abstract protected Vector<MeasurementMetric> getConcreteMeasurementMetrics();

}
