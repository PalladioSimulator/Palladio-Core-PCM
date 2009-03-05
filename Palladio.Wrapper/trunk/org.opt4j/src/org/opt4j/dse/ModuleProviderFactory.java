package org.opt4j.dse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

public class ModuleProviderFactory {

	private static ModuleProviderFactory instance = new ModuleProviderFactory();
	private List<IModuleProvider> nc;
	
	private ModuleProviderFactory(){}

	public List<IModuleProvider> getAllModuleProviderExtensions() throws CoreException{
		if (nc == null){
			Collection<Object> extensions = ExtensionHelper.loadExtension("org.opt4j.modules");
			nc = new ArrayList<IModuleProvider>();
			for (Iterator<Object> iterator = extensions.iterator(); iterator
					.hasNext();) {
				nc.add((IModuleProvider)iterator.next());
				//TODO: fix logging
				System.out.println("Added an extension org.opt4j.modules");
			}
		}
		return nc;
	}
	
	public static ModuleProviderFactory getInstance(){
		return instance;
	}
	
}
