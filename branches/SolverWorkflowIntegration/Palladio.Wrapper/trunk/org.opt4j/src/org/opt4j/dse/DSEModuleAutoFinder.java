package org.opt4j.dse;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.opt4j.config.ModuleAutoFinder;
import org.opt4j.config.ModuleFinder;

import com.google.inject.Module;

/**
 * Extends the {@link ModuleAutoFinder} to add {@link Module}s that are found for the Extensions.
 * Cannot be a Decorator for {@link ModuleFinder}s (which would have been nicer)  because Guice seems to be complicated for that.
 * @author Anne
 *
 */
public class DSEModuleAutoFinder extends ModuleAutoFinder {

	//If it was a decorator...
	//private ModuleFinder decoratedModuleFinder;
	
	/*public DSEModuleAutoFinder(ModuleFinder decoratedModuleFinder) {
		this.decoratedModuleFinder = decoratedModuleFinder;
	}*/

	@Override
	public Collection<Class<? extends Module>> getModules() {
		
		//Collection<Class<? extends Module>> modules = decoratedModuleFinder.getModules();
		Collection<Class<? extends Module>> modules = super.getModules();
		
		try {
			List<IModuleProvider> moduleProviders = ModuleProviderFactory.getInstance().getAllModuleProviderExtensions();
			for (IModuleProvider moduleProvider : moduleProviders) {
				modules.addAll(moduleProvider.getModules());
			}
		} catch (CoreException e) {
			// so no modules are loaded this way. Whatever. 
			e.printStackTrace();
		}
		
		return modules; 
	}
	
	

}
