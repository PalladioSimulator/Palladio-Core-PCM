package de.uka.ipd.sdq.dsexplore.designdecisions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;

/**
 * Handles the loading of the plugins with the extension <extension-point id="de.uka.idd.sdq.dsexplore.newcandidates" name="de.uka.idd.sdq.dsexplore.newcandidates" schema="schema/de.uka.idd.sdq.dsexplore.newcandidates.exsd"/>.
 * 
 * See also the tutorial at http://www.ibm.com/developerworks/xml/library/x-wxxm29.html, where the idea is described.
 * @author Anne
 *
 */
@Deprecated
public class NewCandidateFactory {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	protected IConfigurationElement element;
	private List<INewCandidates> nc;
	
	private static NewCandidateFactory instance = new NewCandidateFactory();

	public List<INewCandidates> getAllNewCandidateExtensions() throws CoreException{
		if (nc == null){
			Collection<Object> extensions = ExtensionHelper.loadExtension("de.uka.ipd.sdq.dsexplore.newcandidates");
			nc = new ArrayList<INewCandidates>();
			for (Iterator<Object> iterator = extensions.iterator(); iterator
					.hasNext();) {
				nc.add((INewCandidates)iterator.next());
				logger.debug("Added an extension de.uka.ipd.sdq.dsexplore.newcandidates");
			}
		}
		return nc;
	}
	
	public static NewCandidateFactory getInstance(){
		return instance;
	}
	
    

}
