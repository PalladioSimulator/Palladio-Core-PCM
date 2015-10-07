//package edu.kit.ipd.sdq.eventsim.workload.probespec.commands;
//
//import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
//
//import edu.kit.ipd.sdq.simcomp.persistence.Measurement;
//import edu.kit.ipd.sdq.simcomp.persistence.MeasuringPoint;
//import edu.kit.ipd.sdq.simcomp.persistence.Metric;
//import edu.kit.ipd.sdq.simcomp.persistence.factory.Probe;
//import edu.kit.ipd.sdq.simcomp.persistence.factory.TimeSpanCalculator;
//
//public class ResponseTimeCalculatorElsc implements TimeSpanCalculator<EntryLevelSystemCall, EntryLevelSystemCall>{
//
//	@Override
//	public Measurement calculate(Probe<EntryLevelSystemCall> pFrom, Probe<EntryLevelSystemCall> pTo, Measurement from, Measurement to) {
//
//		double simTime = -1; // TODO
//		
//		double responseTime = to.getMeasurement() - from.getMeasurement();
//		
//		return new Measurement(Metric.RESPONSE_TIME, new MeasuringPoint(pTo.getElement()), to.getWho(), responseTime, simTime);
//	}
//
//}
