//package edu.kit.ipd.sdq.eventsim.workload.probespec.commands;
//
//import org.palladiosimulator.pcm.usagemodel.Start;
//import org.palladiosimulator.pcm.usagemodel.Stop;
//import org.palladiosimulator.pcm.usagemodel.UsageScenario;
//
//import edu.kit.ipd.sdq.simcomp.persistence.Measurement;
//import edu.kit.ipd.sdq.simcomp.persistence.MeasuringPoint;
//import edu.kit.ipd.sdq.simcomp.persistence.Metric;
//import edu.kit.ipd.sdq.simcomp.persistence.factory.Probe;
//import edu.kit.ipd.sdq.simcomp.persistence.factory.TimeSpanCalculator;
//
//public class ResponseTimeCalculatorUsage implements TimeSpanCalculator<Start, Stop>{
//
//	@Override
//	public Measurement calculate(Probe<Start> pFrom, Probe<Stop> pTo, Measurement from, Measurement to) {
//		UsageScenario usc = pTo.getElement().getScenarioBehaviour_AbstractUserAction().getUsageScenario_SenarioBehaviour();
//		double simTime = -1; // TODO
//		
//		double responseTime = to.getMeasurement() - from.getMeasurement();
//		
//		return new Measurement(Metric.RESPONSE_TIME, new MeasuringPoint(usc), to.getWho(), responseTime, simTime);
//	}
//
//}
