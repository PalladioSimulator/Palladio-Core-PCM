package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.probespec.framework.BlackboardVote;
import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.exceptions.CalculatorException;

public abstract class UnaryCalculator extends Calculator {

	private Integer probeSetID;
	
	protected UnaryCalculator(ISampleBlackboard blackboard, Integer probeSetID) {
		this.probeSetID = probeSetID;
		blackboard.addBlackboardListener(this, probeSetID);
	}
	
	abstract protected Vector<Measure<?, ? extends Quantity>> calculate(
			ProbeSetSample sample)
			throws CalculatorException;
	
	@Override
	abstract protected Vector<MeasurementMetric> getConcreteMeasurementMetrics();

	@Override
	protected BlackboardVote execute(ProbeSetSample pss) throws CalculatorException {
		if (probeSetID.equals(pss.getProbeSetAndRequestContext().getProbeSetID())) {
			Vector<Measure<?, ? extends Quantity>> resultTuple = calculate(pss);
			fireCalculated(resultTuple);
		}
		return BlackboardVote.DISCARD;
	}

}
