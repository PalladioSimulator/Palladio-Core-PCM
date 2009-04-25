package de.uka.ipd.sdq.dsexplore.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * helps handling the {@link ILaunchConfiguration} needed during a Design Exploration. Offers methods to generate new {@link ILaunchConfiguration} to run the simulation and also delete the generated {@link ILaunchConfiguration}s again.
 * 
 * The {@link ConfigurationHelper} is globally available as a singleton instance, you can also create a new {@link ConfigurationHelper} for local use. 
 * @author Anne
 *
 */
public class ConfigurationHelper {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	/**
	 * Singleton instance
	 */
	private static ConfigurationHelper helper = new ConfigurationHelper();

	/**
	 * Remembers the {@link ILaunchConfiguration} this Helper generated so that it can delete them again. 
	 */
	private List<ILaunchConfiguration> rememberedLaunchConfigs = new ArrayList<ILaunchConfiguration>();

	/**
	 * Creates a copy of the passed {@link ILaunchConfiguration} and updates the file names of the passed {@link PCMInstance}.
	 * @param configuration The base configuration to copy from
	 * @param instance the {@link PCMInstance} to use the file names from. 
	 * @return a copy of configuration in which the filenames of the instance are used.
	 * @throws CoreException if the configuration cannot be copied or the new configuration cannot be saved to the run dialogs
	 */
	public ILaunchConfiguration updateConfig(final ILaunchConfiguration configuration,
			PCMInstance instance) throws CoreException {
		
 		//FIXME: really append the suffixes. 
		
			ILaunchConfigurationWorkingCopy workingCopy = configuration.copy(instance.getName());
			workingCopy.setAttribute(ConstantsContainer.REPOSITORY_FILE, instance.getRepositoryFileName());
			workingCopy.setAttribute(ConstantsContainer.ALLOCATION_FILE, instance.getAllocationFileName());
			workingCopy.setAttribute(ConstantsContainer.SYSTEM_FILE, instance.getSystemFileName());
			workingCopy.setAttribute(ConstantsContainer.USAGE_FILE, instance.getUsageModelFileName());
			workingCopy.setAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, instance.getResourceRepositoryFileName());
			
			workingCopy.setAttribute(SimuComConfig.EXPERIMENT_RUN, instance.getName());
			
			ILaunchConfiguration newLaunchConfig = workingCopy.doSave();
			
			this.rememberedLaunchConfigs.add(newLaunchConfig);
			
			return newLaunchConfig;
		
	}
	
	/**
	 * Deletes all {@link ILaunchConfiguration} this helper has generated before. 
	 */
	public void cleanUp(){
		for (Iterator<ILaunchConfiguration> iterator = rememberedLaunchConfigs.iterator(); iterator
				.hasNext();) {
			ILaunchConfiguration config = iterator.next();
			try {
				config.delete();
			} catch (CoreException e) {
				logger.warn("Could not clean up the launch configs, thus some will stay in your run dialog.");
				e.printStackTrace();
			}			
		}
	}
	
	/**
	 * Get the global singleton instance of this helper.  
	 * @return
	 */
	public static ConfigurationHelper getInstance(){
		return helper;
	}
	
	/**
	 * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
	 * 
	 * @param fileName
	 *            the filename specifying the file to load from
	 * @return The EObject loaded from the file
	 */
	public static EObject loadFromXMIFile(final String fileName) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		registerPackages(resourceSet);

		// Construct the URI for the instance file.
		// The argument is treated as a file path only if it denotes an existing
		// file. Otherwise, it's directly treated as a URL.
		File file = new File(fileName);
		URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(fileName);

		Resource resource = null;
		// Demand load resource for this file.
		try {
			resource = resourceSet.getResource(uri, true);
		} catch (Exception e) {
			Logger.getLogger("de.uka.ipd.sdq.dsexplore").error(e.getMessage());
			return null;
		}

		// logger.debug("Loaded " + uri);

		// if (!fileName.endsWith(".assembly") &&
		// !fileName.endsWith("repository")) {
		// // Validate the contents of the loaded resource.
		// for (Iterator j = resource.getContents().iterator(); j.hasNext();) {
		// EObject eObject = (EObject) j.next();
		// Diagnostic diagnostic = Diagnostician.INSTANCE
		// .validate(eObject);
		// if (diagnostic.getSeverity() != Diagnostic.OK) {
		// System.out.println();
		// System.out.println(diagnostic.getMessage());
		// // printDiagnostic(diagnostic, "");
		//					
		// }
		// }
		// }
		EObject eObject = (EObject) resource.getContents().iterator().next();
		return EcoreUtil.getRootContainer(eObject);
	}
	
	/**
	 * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
	 * 
	 * @param resourceSet
	 *            The resource set to register all contained model packages
	 *            with.
	 */
	private static void registerPackages(final ResourceSet resourceSet) {

		resourceSet.getPackageRegistry().put(AllocationPackage.eNS_URI,
				AllocationPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ParameterPackage.eNS_URI,
				ParameterPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(
				ResourceenvironmentPackage.eNS_URI,
				ResourceenvironmentPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ResourcetypePackage.eNS_URI,
				ResourcetypePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(RepositoryPackage.eNS_URI,
				RepositoryPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(SeffPackage.eNS_URI,
				SeffPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(SystemPackage.eNS_URI,
				SystemPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(UsagemodelPackage.eNS_URI,
				UsagemodelPackage.eINSTANCE);

	}
	

}
