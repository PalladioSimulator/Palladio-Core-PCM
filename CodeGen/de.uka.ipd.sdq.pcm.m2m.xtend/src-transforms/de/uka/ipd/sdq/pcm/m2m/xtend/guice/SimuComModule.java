package de.uka.ipd.sdq.pcm.m2m.xtend.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.util.Modules;

import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.AllocationXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.CalculatorsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.CallsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ComposedStructureXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ContextPatternXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.DummiesXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaCoreXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ProvidedPortsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.RepositoryXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ResourcesXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SEFFBodyXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SensorsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.UsageXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.UserActionsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimAccuracyInfluenceExt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimAccuracyXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimAllocationXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimCalculatorsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimCallsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimComposedStructureXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimContextPatternXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimDummiesXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimJavaCoreXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimMeasuringPointExt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimProvidedPortsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimRepositoryXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimResourcesXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimSEFFBodyXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimSensorsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimUsageFactoryXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimUsageXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.SimUserActionsXpt;

public class SimuComModule implements Module {
	@Override
	public void configure(Binder binder) {
		// new bindings
		binder.bind(SimAccuracyInfluenceExt.class).in(Singleton.class);
		binder.bind(SimAccuracyXpt.class).in(Singleton.class);
		binder.bind(SimMeasuringPointExt.class).in(Singleton.class);
		binder.bind(SimUsageFactoryXpt.class).in(Singleton.class);
		
		// changed bindings
		binder.bind(AllocationXpt.class).to(SimAllocationXpt.class).in(Singleton.class);
		binder.bind(CalculatorsXpt.class).to(SimCalculatorsXpt.class).in(Singleton.class);
		binder.bind(CallsXpt.class).to(SimCallsXpt.class).in(Singleton.class);
		binder.bind(ComposedStructureXpt.class).to(SimComposedStructureXpt.class).in(Singleton.class);
		binder.bind(ContextPatternXpt.class).to(SimContextPatternXpt.class).in(Singleton.class);
		binder.bind(DummiesXpt.class).to(SimDummiesXpt.class).in(Singleton.class);
		binder.bind(JavaCoreXpt.class).to(SimJavaCoreXpt.class).in(Singleton.class);
		binder.bind(ProvidedPortsXpt.class).to(SimProvidedPortsXpt.class).in(Singleton.class);
		binder.bind(RepositoryXpt.class).to(SimRepositoryXpt.class).in(Singleton.class);
		binder.bind(ResourcesXpt.class).to(SimResourcesXpt.class).in(Singleton.class);
		binder.bind(SEFFBodyXpt.class).to(SimSEFFBodyXpt.class).in(Singleton.class);
		binder.bind(SensorsXpt.class).to(SimSensorsXpt.class).in(Singleton.class);
		binder.bind(UsageXpt.class).to(SimUsageXpt.class).in(Singleton.class);
		binder.bind(UserActionsXpt.class).to(SimUserActionsXpt.class).in(Singleton.class);
	}
	
	public static Injector getInjector(String rootDirectory) {
		return Guice.createInjector(
				Modules.override(new CoreModule(rootDirectory))
					.with(new SimuComModule()));
	}
}
