package de.uka.ipd.sdq.pcm.m2m.xtend.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import de.uka.ipd.sdq.pcm.m2m.xtend.helper.M2TFileSystemAccess;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.AllocationXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.BuildXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.CalculatorsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.CallsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.CompletionsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ComposedStructureXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ContextPatternXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.DataTypesXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.DelegatorClassXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.DummiesXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaCoreXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaNamesExt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.PCMext;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ProvidedPortsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.RepositoryXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ResourcesXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SEFFBodyXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SensorsExt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SensorsXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SystemXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.UsageXpt;
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.UserActionsXpt;

public class CoreModule extends AbstractModule {
	private M2TFileSystemAccess fsa;

	public CoreModule(String rootDirectory) {
		this.fsa = new M2TFileSystemAccess(rootDirectory);
	}
	
	@Override
	protected void configure() {
		bind(M2TFileSystemAccess.class).toInstance(fsa);
		
		// load all the base classes of the modules
		bind(AllocationXpt.class).in(Singleton.class);
		bind(BuildXpt.class).in(Singleton.class);
		bind(CalculatorsXpt.class).in(Singleton.class);
		bind(CallsXpt.class).in(Singleton.class);
		bind(CompletionsXpt.class).in(Singleton.class);
		bind(ComposedStructureXpt.class).in(Singleton.class);
		bind(ContextPatternXpt.class).in(Singleton.class);
		bind(DataTypesXpt.class).in(Singleton.class);
		bind(DelegatorClassXpt.class).in(Singleton.class);
		bind(DummiesXpt.class).in(Singleton.class);
		bind(JavaCoreXpt.class).in(Singleton.class);
		bind(JavaNamesExt.class).in(Singleton.class);
		bind(PCMext.class).in(Singleton.class);
		bind(ProvidedPortsXpt.class).in(Singleton.class);
		bind(RepositoryXpt.class).in(Singleton.class);
		bind(ResourcesXpt.class).in(Singleton.class);
		bind(SEFFBodyXpt.class).in(Singleton.class);
		bind(SensorsExt.class).in(Singleton.class);
		bind(SensorsXpt.class).in(Singleton.class);
		bind(SystemXpt.class).in(Singleton.class);
		bind(UsageXpt.class).in(Singleton.class);
		bind(UserActionsXpt.class).in(Singleton.class);
	}
}
