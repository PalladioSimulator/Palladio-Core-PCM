package de.uka.ipd.sdq.simucom;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import UsageModelPackage.UsageModel;
import UsageModelPackage.UsageModelPackagePackage;

public class ModelLoader {
	
	@SuppressWarnings("unchecked")
	protected static UsageModel loadSimuComModel(String uri)
	{
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register the default resource factory -- only needed for stand-alone!
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
          Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Get the URI of the model file.
        URI fileURI = URI.createFileURI(uri);
        
        Object o = UsageModelPackagePackage.eINSTANCE;
        System.out.println(o.toString()+" registered!");
        
        UsageModel simulatedWorld = null;
        try {
         	 // Demand load the resource for this file.
     	   Resource resource = resourceSet.getResource(fileURI, true);
         	 
              simulatedWorld = (UsageModel) EcoreUtil.getObjectByType(
                        resource.getContents(), UsageModelPackagePackage.eINSTANCE.getUsageModel());
           resource.save(System.out,null);
         } catch (Exception we) {
              System.out.println(we.getMessage());
              System.exit(1);
         }
         return simulatedWorld;		
	}
}
