package de.uka.ipd.sdq.pcm.codegen.simucom.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.util.Modules;

import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.AllocationXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.CalculatorsXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.CallsXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.ComposedStructureXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.ContextPatternXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.DummiesXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.JavaCoreXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.ProvidedPortsXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.RepositoryXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.ResourcesXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.SEFFBodyXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.SensorsXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.UsageXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.UserActionsXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimAccuracyInfluenceExt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimAccuracyXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimAllocationXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimCalculatorsXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimCallsXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimComposedStructureXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimContextPatternXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimDummiesXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimJavaCoreXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimMeasuringPointExt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimProvidedPortsXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimRepositoryXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimResourcesXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimSEFFBodyXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimSensorsXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimUsageFactoryXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimUsageXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimUserActionsXpt;

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
