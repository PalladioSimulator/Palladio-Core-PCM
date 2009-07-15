package org.opt4j.dse;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class ExtensionHelper {
	
	/**
	 * returns all found extensions for this id. 
	 * @param id
	 * @return
	 * @throws CoreException
	 */
	public static Collection<Object> loadExtension(String id) throws CoreException {
		/* To load an extension, you just need to access the registry (through an instance of IExtensionRegistry) from the platform (through the aptly name Platform object), then inquire for the extension points that the plug-in is interested in. The platform returns an IExtensionPoint object.

		IExtensionPoint returns an array of IConfigurationElement objects, which represent the extension tags in plugin.xml. For each plug-in that implements the extension point, you'll receive an IConfigurationElement. IConfigurationElement offers methods such as getChildren() and getAttribute(), to retrieve the data from the XML markup. Last but not least, createExecutableExtension() returns a Java class that implements the extension. It takes the name of the Java class from an attribute in the XML markup.
		*/
		IConfigurationElement[] ep = Platform.getExtensionRegistry().getConfigurationElementsFor(id);
		
		Collection<Object> result = null;
		
		if (ep.length == 0){
			//Error: No extension found
			System.out.println("Error: No Extension "+id+" found");
		} else {
			result = new Vector<Object>();
			for (int i = 0; i < ep.length; i++) {
				result.add(ep[i].createExecutableExtension("delegate"));
			}
		}
		return result;
	}

}
