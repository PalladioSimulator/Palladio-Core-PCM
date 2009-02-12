package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.PassiveResourceConfiguration;
import scheduler.configuration.ProcessConfiguration;

public interface ISchedulingFactory {
	
	public static ISchedulingFactory eINSTANCE = new SchedulingFactory();

	public abstract IActiveResource createActiveResource(
			ActiveResourceConfiguration configuration);

	public abstract IPassiveResource createPassiveResource(
			PassiveResourceConfiguration configuration);

	public abstract IRunningProcess createRunningProcess(
			ISchedulableProcess process, ProcessConfiguration process_configuration,
			ActiveResourceConfiguration resource_configuration);

	public abstract void resetFactory();
}