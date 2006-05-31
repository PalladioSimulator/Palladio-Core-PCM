package de.uka.ipd.sdq.simucom;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import SystemPackage.SystemPackagePackage;
import UsageModelPackage.UsageModel;
import UsageModelPackage.UsageModelPackagePackage;

public class ModelLoader {
	
	protected static ResourceSet usageModelResourceSet = new ResourceSetImpl();
	protected static ResourceSet systemResourceSet = new ResourceSetImpl();
	
	@SuppressWarnings("unchecked")
	protected static UsageModel loadSimuComUsageModel(String uri)
	{
        // Register the default resource factory -- only needed for stand-alone!
		usageModelResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
          Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Get the URI of the model file.
        URI fileURI = URI.createFileURI(uri);
        
        Object o = UsageModelPackagePackage.eINSTANCE;
        System.out.println(o.toString()+" registered!");
        
        UsageModel simulatedWorld = null;
        try {
         	 // Demand load the resource for this file.
     	   Resource resource = usageModelResourceSet.getResource(fileURI, true);
         	 
              simulatedWorld = (UsageModel) EcoreUtil.getObjectByType(
                        resource.getContents(), UsageModelPackagePackage.eINSTANCE.getUsageModel());
           resource.save(System.out,null);
         } catch (Exception we) {
              System.out.println(we.getMessage());
              System.exit(1);
         }
         return simulatedWorld;		
	}

	@SuppressWarnings("unchecked")
	protected static SystemPackage.System loadSimuComSystem(String uri)
	{
        // Register the default resource factory -- only needed for stand-alone!
        systemResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
          Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Get the URI of the model file.
        URI fileURI = URI.createFileURI(uri);
        
        Object o = SystemPackagePackage.eINSTANCE;
        System.out.println(o.toString()+" registered!");
        
        SystemPackage.System simulatedWorld = null;
        try {
         	 // Demand load the resource for this file.
     	   Resource resource = systemResourceSet.getResource(fileURI, true);
         	 
              simulatedWorld = (SystemPackage.System) EcoreUtil.getObjectByType(
                        resource.getContents(), SystemPackagePackage.eINSTANCE.getSystem());
           resource.save(System.out,null);
         } catch (Exception we) {
              System.out.println(we.getMessage());
              System.exit(1);
         }
         return simulatedWorld;		
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
}
