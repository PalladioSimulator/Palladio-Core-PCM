package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.probespec.framework.BlackboardVote;
import de.uka.ipd.sdq.probespec.framework.IBlackboardListener;
import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.exceptions.CalculatorException;

/**
 * This class is the abstract super class for all Calculator implementations.
 * All specific Calculators have to inherit from this class.
 * <p>
 * Calculators observe the {@link ISampleBlackboard} for probe set samples
 * (Observer Pattern). As soon as a new probe set sample is published at the
 * blackboard, the {@link #execute(ProbeSetSample)} method is invoked. The
 * calculator have to decide, whether the probe set sample is of interest for
 * the calculation.
 * 
 * @author Faber
 * 
 */
public abstract class Calculator implements IBlackboardListener {

	private Vector<MeasurementMetric> measurementMetrics = null;

	// copy on write enables listeners to unregister during event processing.
	private CopyOnWriteArrayList<ICalculatorListener> listeners;

	protected Calculator() {
		this.measurementMetrics = getConcreteMeasurementMetrics();
		listeners = new CopyOnWriteArrayList<ICalculatorListener>();
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

//	/**
//	 * The update method is called by the SampleBlackboard (observable entity)
//	 * containing all ProbeSetSamples. The method casts the two objects and then
//	 * calls the execute method of the specific calculator
//	 * 
//	 * TODO If a logging framework is added to this project, handle the
//	 * exception below correctly.
//	 * 
//	 * @param o
//	 *            The observable object (SampleBlackboard)
//	 * @param arg
//	 *            The ProbeSetSample object written on the SampleBlackboard
//	 */
//	@Override
//	public void update(Observable o, Object arg) {
//		if (o instanceof SampleBlackboard && arg instanceof ProbeSetSample) {
//			ProbeSetSample pss = (ProbeSetSample) arg;
//			try {
//				execute(pss);
//			} catch (CalculatorException e) {
//				e.printStackTrace();
//			}
//
//		}
//	}

	@Override
	public BlackboardVote sampleArrived(ProbeSetSample pss) {
		try {
			return execute(pss);
		} catch (CalculatorException e) {
			e.printStackTrace();
		}
//		return decideBlackboardVote();
		return BlackboardVote.DISCARD;
	}
	
//	public abstract BlackboardVote decideBlackboardVote();

	abstract protected BlackboardVote execute(ProbeSetSample pss)
			throws CalculatorException;

	abstract protected Vector<MeasurementMetric> getConcreteMeasurementMetrics();

	public void addCalculatorListener(ICalculatorListener l) {
		listeners.add(l);
	}

	protected void fireCalculated(
			Vector<Measure<?, ? extends Quantity>> resultTuple) {
		for (ICalculatorListener l : listeners) {
			l.calculated(resultTuple);
		}
	}

}
