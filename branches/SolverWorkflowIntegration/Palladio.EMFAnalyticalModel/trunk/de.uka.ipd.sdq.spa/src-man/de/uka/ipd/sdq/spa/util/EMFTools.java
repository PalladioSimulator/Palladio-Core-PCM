package de.uka.ipd.sdq.spa.util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.spa.SpaPackage;


public class EMFTools {
	
	@SuppressWarnings("unchecked")
	public static EObject loadFromXMI(String fileName) {
        // Create a resource set to hold the resources.
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register the appropriate resource factory to handle all file
        // extentions.
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                        new XMIResourceFactoryImpl());

        // Register the package to ensure it is available during loading.
        resourceSet.getPackageRegistry().put(SpaPackage.eNS_URI,
        		SpaPackage.eINSTANCE);

        // Construct the URI for the instance file.
        // The argument is treated as a file path only if it denotes an existing
        // file. Otherwise, it's directly treated as a URL.
        File file = new File(fileName);
        URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath())
                : URI.createURI(fileName);

        // Demand load resource for this file.
        Resource resource = resourceSet.getResource(uri, true);
        System.out.println("Loaded " + uri);

   
        EObject eObject = (EObject)resource.getContents().iterator().next();
        return EcoreUtil.getRootContainer(eObject);
    }
	
	@SuppressWarnings("unchecked")
	public static void saveToXMI(EObject objectToSave, String fileName) {
		  // Create a resource set.
		  ResourceSet resourceSet = new ResourceSetImpl();

		  // Register the default resource factory -- only needed for stand-alone!
		  resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		  // Get the URI of the model file.
		  URI fileURI = URI.createFileURI(new File(fileName).getAbsolutePath());

		  // Create a resource for this file.
		  Resource resource = resourceSet.createResource(fileURI);

		  // Add the book and writer objects to the contents.
		  resource.getContents().add(objectToSave);

		  // Save the contents of the resource to the file system.
		  try
		  {
		    resource.save(Collections.EMPTY_MAP);
		  }
		  catch (IOException e) {}
	}	

}
