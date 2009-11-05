package de.uka.ipd.sdq.dsexplore.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;

public class ExtensionHelper {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
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
			logger.error("Error: No Extension "+id+" found");
		} else {
			result = new Vector<Object>();
			for (int i = 0; i < ep.length; i++) {
				result.add(ep[i].createExecutableExtension("delegate"));
			}
		}
		return result;
	}
	
	/**
	 * Loads all extensions which extends the
	 * "de.uka.ipd.sdq.dsexplore.analysis" extension point.
	 * 
	 * @return all analysis method extensions
	 */
	public static IExtension[] loadAnalysisExtensions() {
		return Platform.getExtensionRegistry().getExtensionPoint(
				"de.uka.ipd.sdq.dsexplore.analysis").getExtensions();
	}
	

	/**
	 * Given an {@link IExtension}, this methods returns the content of the
	 * specified String attribute.
	 * 
	 * @param extension
	 * @param configurationElement
	 * @param attributeName
	 * @return the attribute content; null if the specified attribute does not
	 *         exist.
	 */
	public static String loadStringAttribute(IExtension extension,
			String configurationElement, String attributeName) {
		IConfigurationElement[] elements = extension.getConfigurationElements();
		for (IConfigurationElement element : elements) {
			if (element.getName().equals(configurationElement)) {
				String attribute = element.getAttribute(attributeName);
				return attribute;
			}
		}

		return null;
	}
	
	/**
	 * TODO: Method obsolete!?
	 * 
	 * Given an {@link IExtension}, this method returns an instance of the
	 * executable extension identified by the specified attribute.
	 * 
	 * @param extension
	 * @param configurationElement
	 * @param attributeName
	 * @return a class instance; null if the passed attribute does not exist.
	 * @throws CoreException
	 */
	public static Object loadExecutableAttribute(IConfigurationElement element,
			String attributeName) throws CoreException {

		return element.createExecutableExtension(attributeName);
	}

	/**
	 * Loads all extensions which extends the
	 * "de.uka.ipd.sdq.dsexplore.analysis" extension point and which specify the given quality attribute.
	 * 
	 * @return all analysis method extensions
	 */
	public static List<IExtension> loadAnalysisExtensions(String qualityAttribute) {
		IExtension[] exts = Platform.getExtensionRegistry().getExtensionPoint(
		"de.uka.ipd.sdq.dsexplore.analysis").getExtensions();
		
		List<IExtension> results = new ArrayList<IExtension>();
		
		for (IExtension extension : exts) {
			if (qualityAttribute.equals(loadQualityAttribute(extension))){
				results.add(extension);
			}
		}
		
		return results;
	}
	
	/**
	 * Loads the name of a single analysis method represented by the passed
	 * extension.
	 * 
	 * @param extension
	 * @return the analysis method's name; null if the passed extension is not
	 *         an analysis extension or the name attribute is not set.
	 */
	private static String loadQualityAttribute(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();
		for (IConfigurationElement element : elements) {
			if (element.getName().equals("analysis")) {
				return element.getAttribute("qualityAttribute");
			}
		}
		
		return null;
	}
	

}
