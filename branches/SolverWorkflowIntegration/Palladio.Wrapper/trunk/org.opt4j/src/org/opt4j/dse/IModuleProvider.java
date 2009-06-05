package org.opt4j.dse;

import java.util.Collection;

import com.google.inject.Module;

public interface IModuleProvider {
	
	public Collection<Class<? extends Module>> getModules();

}
