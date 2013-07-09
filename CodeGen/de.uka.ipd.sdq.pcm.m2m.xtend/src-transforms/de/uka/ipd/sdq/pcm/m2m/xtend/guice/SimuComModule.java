package de.uka.ipd.sdq.pcm.m2m.xtend.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.util.Modules;

import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.*;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim.*;

public class SimuComModule implements Module {
	@Override
	public void configure(Binder binder) {
		// new bindings
		binder.bind(SimAccuracyInfluenceExt.class).in(Singleton.class);
		binder.bind(SimAccuracyXpt.class).in(Singleton.class);
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
