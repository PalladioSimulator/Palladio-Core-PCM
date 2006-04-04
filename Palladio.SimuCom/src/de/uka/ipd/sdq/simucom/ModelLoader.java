package de.uka.ipd.sdq.simucom;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.util.UML2Resource;

import de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage;
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedArchitecture;

public class ModelLoader {
	protected static void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
			UML2Resource.FILE_EXTENSION, UML2Resource.Factory.INSTANCE);
	}

	protected static void registerPathmaps(URI uri) {
		URIConverter.URI_MAP.put(URI.createURI(UML2Resource.LIBRARIES_PATHMAP),
			uri.appendSegment("libraries").appendSegment(""));

		URIConverter.URI_MAP.put(
			URI.createURI(UML2Resource.METAMODELS_PATHMAP), uri.appendSegment(
				"metamodels").appendSegment(""));

		URIConverter.URI_MAP.put(URI.createURI(UML2Resource.PROFILES_PATHMAP),
			uri.appendSegment("profiles").appendSegment(""));
	}

	protected static SimulatedArchitecture loadSimuComModel(String uri)
	{
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register the default resource factory -- only needed for stand-alone!
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
          Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Get the URI of the model file.
        URI fileURI = URI.createFileURI(uri);
        
        Object o = SimuComModelPackage.eINSTANCE;
        SimulatedArchitecture sa = null;
        try {
         	 // Demand load the resource for this file.
     	   Resource resource = resourceSet.getResource(fileURI, true);
         	 
              sa = (SimulatedArchitecture) EcoreUtil.getObjectByType(
                        resource.getContents(), SimuComModelPackage.eINSTANCE.getSimulatedArchitecture());
           resource.save(System.out,null);
         } catch (Exception we) {
              System.out.println(we.getMessage());
              System.exit(1);
         }
         return sa;		
	}
}
