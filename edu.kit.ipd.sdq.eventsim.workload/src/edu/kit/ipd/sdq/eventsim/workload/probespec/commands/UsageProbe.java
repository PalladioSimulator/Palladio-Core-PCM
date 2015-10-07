//package edu.kit.ipd.sdq.eventsim.workload.probespec.commands;
//
//import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
//
//import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
//import edu.kit.ipd.sdq.eventsim.workload.entities.User;
//import edu.kit.ipd.sdq.eventsim.workload.interpreter.listener.IUsageTraversalListener;
//import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageInterpreterConfiguration;
//import edu.kit.ipd.sdq.simcomp.persistence.MeasuringPoint;
//import edu.kit.ipd.sdq.simcomp.persistence.Measurement;
//import edu.kit.ipd.sdq.simcomp.persistence.Metric;
//import edu.kit.ipd.sdq.simcomp.persistence.Trigger;
//import edu.kit.ipd.sdq.simcomp.persistence.factory.AbstractProbe;
//
//public class UsageProbe<A extends AbstractUserAction> extends AbstractProbe<A> {
//
//	protected UsageProbe(A action, String property, UsageInterpreterConfiguration interpreterConfiguration) {
//		super(new MeasuringPoint<A>(action, property));
//
//		if (property.equals("before")) {
//			interpreterConfiguration.addTraversalListener(action, new IUsageTraversalListener() {
//				@Override
//				public void before(AbstractUserAction action, User entity, UserState state) {
//					process(entity);
//				}
//
//				@Override
//				public void after(AbstractUserAction action, User entity, UserState state) {
//					// nothing to do
//				}
//			});
//		} else if (property.equals("after")) {
//			interpreterConfiguration.addTraversalListener(action, new IUsageTraversalListener() {
//				@Override
//				public void before(AbstractUserAction action, User entity, UserState state) {
//					// nothing to do
//				}
//
//				@Override
//				public void after(AbstractUserAction action, User entity, UserState state) {
//					process(entity);
//				}
//			});
//		} else {
//			// TODO
//			throw new IllegalArgumentException();
//		}
//	}
//	
//	private void process(User entity) {
//		// build measurement
//		double simTime = entity.getModel().getSimulationControl().getCurrentSimulationTime();
//		Measurement measurement = new Measurement(Metric.CURRENT_TIME, getMeasuringPoint(), new Trigger<User>(entity), simTime,
//				simTime);
//
//		// store
//		cache.put(measurement);
//
//		// notify
//		measurementListener.forEach(l -> l.notify(measurement));
//	}
//	
//}
