package de.uka.ipd.sdq.dsexplore.opt4j.archive;

import org.opt4j.start.Opt4JModule;

public class PopulationTrackerModule extends Opt4JModule {

	@Override
	protected void config() {
		 // AsEagerSingleton means that an instance is always created 
		    bind(PopulationTracker.class).asEagerSingleton();
	}

}
