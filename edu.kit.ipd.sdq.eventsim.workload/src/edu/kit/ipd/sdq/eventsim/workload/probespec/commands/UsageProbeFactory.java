//package edu.kit.ipd.sdq.eventsim.workload.probespec.commands;
//
//import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
//
//import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageInterpreterConfiguration;
//
//public class UsageProbeFactory {
//
//	private UsageInterpreterConfiguration interpreterConfiguration;
//	
//	public UsageProbeFactory(UsageInterpreterConfiguration interpreterConfiguration) {
//		this.interpreterConfiguration = interpreterConfiguration;
//	}
//	
//	public <A extends AbstractUserAction> UsageProbe<A> probeFor(A action, String property) {
//		return new UsageProbe<A>(action, property, interpreterConfiguration);
//	}
//	
//}
