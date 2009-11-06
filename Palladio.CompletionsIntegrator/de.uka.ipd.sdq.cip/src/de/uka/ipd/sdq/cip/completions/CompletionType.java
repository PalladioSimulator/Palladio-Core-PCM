/**
 * 
 */
package de.uka.ipd.sdq.cip.completions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.CIPPlugin;


/**
 * This class is used as a Completion Type container.
 * 
 * @author Thomas Schuischel
 */
public class CompletionType implements Comparable<CompletionType> {
	
	//
	private final String completionFile;
	private final String annotationMetaFile;
	private final String id;
	private final String name;
	
	//
	private static CompletionType[] cachedCompletions = null;
	

	public CompletionType(IConfigurationElement configElement, String contributor) {
		String metamodel = new String();
		id = getAttribute(configElement, ConstantsContainer.ATT_ID, null);
		name = getAttribute(configElement, ConstantsContainer.ATT_NAME, id);
		completionFile = URI.createPlatformPluginURI("/" + contributor + "/" + getAttribute(configElement, ConstantsContainer.ATT_QVT_FILE, null), false).toString();
		try{
			metamodel = getAttribute(configElement, ConstantsContainer.ATT_METAMODEL, null);
		}
		catch(IllegalArgumentException e){}
		if(!metamodel.isEmpty())
			annotationMetaFile = URI.createPlatformPluginURI("/" + contributor + "/" + metamodel, false).toString();
		else
			annotationMetaFile =  new String();
	}

	/**
	 * @return the completionFile
	 */
	public String getCompletionFile() {
		return completionFile;
	}

	/**
	 * @return the annotationInputFile
	 */
	public String getAnnotationMetaFile() {
		return annotationMetaFile;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	public String getId() {
		return id;
	}
	
	@Override
	public int compareTo(CompletionType o) {
		return id.compareTo(o.id);
	}



	public static CompletionType[] getCompletions(){
		if(cachedCompletions != null)
			return cachedCompletions;
		
		IExtension[] extension = Platform.getExtensionRegistry().getExtensionPoint(CIPPlugin.PLUGIN_ID,"completions").getExtensions();
		List<CompletionType> found = new ArrayList<CompletionType>();
		for(int i = 0; i < extension.length; ++i){
			IConfigurationElement[] configElements = extension[i].getConfigurationElements();
			String contributor = extension[i].getContributor().getName();
			for(int j = 0; j < configElements.length; ++j) {
				CompletionType proxy = parseCompletion(configElements[j],contributor);
				if(proxy != null)
					found.add(proxy);
			}
		}
		
		cachedCompletions = (CompletionType[]) found.toArray(new CompletionType[found.size()]);
		return cachedCompletions;
	}
	
	public static CompletionType findType(String id) {
		CompletionType[] types = getCompletions();
		for(int i = 0; i < types.length; ++i) {
			if(types[i].getId().equals(id))
				return types[i];
		}
		return null;
	}


	public static ArrayList<CompletionEntry> getCompletionEntrys(
			Map<String, String> completionSets) {
		CompletionType[] types = getCompletions();
		ArrayList<CompletionEntry> entrys = new ArrayList<CompletionEntry>();
		
		for(int i = 0; i < types.length; ++i) {
			CompletionEntry entry = new CompletionEntry(types[i]);
			String settings = completionSets.get(types[i].getId());
			entry.fromConfigString(settings);
			entrys.add(entry);
		}
		return entrys;
	}

	
	private static CompletionType parseCompletion(IConfigurationElement configElement, String contributor){
		if(!configElement.getName().equals(ConstantsContainer.TAG_COMPLETION))
			return null;
		try{
			return new CompletionType(configElement,contributor);
		}
		catch(Exception e){
			String name = configElement.getAttribute(ConstantsContainer.ATT_NAME);
			if(name == null)
				name = "[missing name attribute]";
			String msg = "Failed to load completion named " 
				+ name
				+ " in "
				+ configElement.getDeclaringExtension().getNamespaceIdentifier();
			//SimuCIPPlugin.reportError(msg,e);
			return null;
		}
	}
	
	private static String getAttribute(IConfigurationElement configElement,
			String name, String defaultValue) {
		String value = configElement.getAttribute(name);
		if(value != null)
			return value;
		if(defaultValue != null)
			return defaultValue;
		throw new IllegalArgumentException("Missing " + name + " attribute");
	}

}
