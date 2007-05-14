package de.uka.ipd.sdq.simucom;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

public class ModelLoader {
	
	protected static ResourceSet usageModelResourceSet = new ResourceSetImpl();
	protected static ResourceSet systemResourceSet = new ResourceSetImpl();
	protected static ResourceSet resourceEnvironmentResourceSet = new ResourceSetImpl();
	
	@SuppressWarnings("unchecked")
	protected static UsageModel loadSimuComUsageModel(String uri)
	{
        // Register the default resource factory -- only needed for stand-alone!
		usageModelResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
          Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Get the URI of the model file.
        URI fileURI = URI.createFileURI(uri);
        
        Object o = UsagemodelPackage.eINSTANCE;
        System.out.println(o.toString()+" registered!");
        
        UsageModel simulatedWorld = null;
        try {
         	 // Demand load the resource for this file.
     	   Resource resource = usageModelResourceSet.getResource(fileURI, true);
         	 
              simulatedWorld = (UsageModel) EcoreUtil.getObjectByType(
                        resource.getContents(), UsagemodelPackage.eINSTANCE.getUsageModel());
           resource.save(System.out,null);
         } catch (Exception we) {
              System.out.println(we.getMessage());
              System.exit(1);
         }
         return simulatedWorld;		
	}

	@SuppressWarnings("unchecked")
	protected static de.uka.ipd.sdq.pcm.system.System loadSimuComSystem(String uri)
	{
        // Register the default resource factory -- only needed for stand-alone!
        systemResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
          Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Get the URI of the model file.
        URI fileURI = URI.createFileURI(uri);
        
        Object o = de.uka.ipd.sdq.pcm.system.SystemPackage.eINSTANCE;
        System.out.println(o.toString()+" registered!");
        
        de.uka.ipd.sdq.pcm.system.System simulatedWorld = null;
        try {
         	 // Demand load the resource for this file.
     	   Resource resource = systemResourceSet.getResource(fileURI, true);
         	 
              simulatedWorld = (de.uka.ipd.sdq.pcm.system.System) EcoreUtil.getObjectByType(
                        resource.getContents(), de.uka.ipd.sdq.pcm.system.SystemPackage.eINSTANCE.getSystem());
           resource.save(System.out,null);
         } catch (Exception we) {
              System.out.println(we.getMessage());
              System.exit(1);
         }
         return simulatedWorld;		
	}

	@SuppressWarnings("unchecked")
	protected static de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment loadSimuComResourceEnvironment(String uri)
	{
        // Register the default resource factory -- only needed for stand-alone!
		resourceEnvironmentResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
          Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Get the URI of the model file.
        URI fileURI = URI.createFileURI(uri);
        
        Object o = ResourceenvironmentPackage.eINSTANCE;
        System.out.println(o.toString()+" registered!");
        
        ResourceEnvironment resourceEnvironment = null;
        try {
         	 // Demand load the resource for this file.
     	   Resource resource = resourceEnvironmentResourceSet.getResource(fileURI, true);
         	 
     	  resourceEnvironment = (ResourceEnvironment) EcoreUtil.getObjectByType(
                        resource.getContents(), ResourceenvironmentPackage.eINSTANCE.getResourceEnvironment());
           resource.save(System.out,null);
         } catch (Exception we) {
              System.out.println(we.getMessage());
              System.exit(1);
         }
         return resourceEnvironment;		
	}
	
	/**
	 * @return the systemResourceSet
	 */
	public static ResourceSet getSystemResourceSet() {
		return systemResourceSet;
	}

	/**
	 * @return the usageModelResourceSet
	 */
	public static ResourceSet getUsageModelResourceSet() {
		return usageModelResourceSet;
	}
	
	/**
	 * @return the usageModelResourceSet
	 */
	public static ResourceSet getResourceEnvironmentResourceSet() {
		return resourceEnvironmentResourceSet;
	}
}
