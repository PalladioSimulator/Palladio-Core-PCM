package de.uka.ipd.sdq.dsexplore.helper;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class ExtensionHelper {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	public static Object loadExtension(String id) throws CoreException {
		/* To load an extension, you just need to access the registry (through an instance of IExtensionRegistry) from the platform (through the aptly name Platform object), then inquire for the extension points that the plug-in is interested in. The platform returns an IExtensionPoint object.

		IExtensionPoint returns an array of IConfigurationElement objects, which represent the extension tags in plugin.xml. For each plug-in that implements the extension point, you'll receive an IConfigurationElement. IConfigurationElement offers methods such as getChildren() and getAttribute(), to retrieve the data from the XML markup. Last but not least, createExecutableExtension() returns a Java class that implements the extension. It takes the name of the Java class from an attribute in the XML markup.
		*/
		IConfigurationElement[] ep = Platform.getExtensionRegistry().getConfigurationElementsFor(id);
		
		if (ep.length == 0){
			//Error: No extension found
			logger.error("Error: No Extension "+id+" found");
		} else {
			//TODO: Treat multiple ones found.
				return ep[0].createExecutableExtension("delegate");
				
		}
		return null;
	}

}
