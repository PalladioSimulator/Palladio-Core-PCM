package de.uka.ipd.sdq.dsexplore.newcandidates;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IConfigurationElement;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;

/**
 * Handles the loading of the plugins with the extension <extension-point id="de.uka.idd.sdq.dsexplore.newcandidates" name="de.uka.idd.sdq.dsexplore.newcandidates" schema="schema/de.uka.idd.sdq.dsexplore.newcandidates.exsd"/>.
 * 
 * See also the tutorial at http://www.ibm.com/developerworks/xml/library/x-wxxm29.html, where the idea is described.
 * @author Anne
 *
 */
public class NewCandidateProxy implements INewCandidates {
	
	protected IConfigurationElement element;

	@Override
	public List<PCMInstance> generateNewCandidates(PCMInstance currentSolution) {
		// TODO Auto-generated method stub
		
		INewCandidates nc = (INewCandidates)ExtensionHelper.loadExtension("de.uka.ipd.sdq.dsexplore.newcandidates");
		nc.generateNewCandidates(currentSolution);
		
		
		return null;
	}

    

}
