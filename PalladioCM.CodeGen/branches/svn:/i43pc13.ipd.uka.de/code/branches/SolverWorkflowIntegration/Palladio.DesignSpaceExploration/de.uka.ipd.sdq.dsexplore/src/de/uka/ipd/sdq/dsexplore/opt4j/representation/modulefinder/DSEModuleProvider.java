package de.uka.ipd.sdq.dsexplore.opt4j.representation.modulefinder;

import java.util.Collection;

import org.opt4j.dse.IModuleProvider;

import com.google.inject.Module;

@Deprecated
public class DSEModuleProvider implements IModuleProvider {

	@Override
	public Collection<Class<? extends Module>> getModules() {
		System.out.println("Insert module finding code here");
		return null;
	}

}
