package de.uka.ipd.sdq.simucomframework;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class ModelsAtRuntime {

    public static EObject loadModel(final String resourceURI) {
        URI modelUri = URI.createURI(resourceURI);

        final ResourceSet resourceSet = new ResourceSetImpl();
        final Resource resource = resourceSet.createResource(modelUri);

        try {
            resource.load(Collections.EMPTY_MAP);
        } catch (final IOException e) {
            // TODO Auto-generated catch block. Use eclipse error log instead?
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // Get single EObject if URI has fragment, load whole model if not
        String fragment = modelUri.fragment();
        if(fragment != null) {
            return resource.getEObject(fragment);
        } else {
            return resource.getEObject(modelUri.toString());
        }
    }
    
    /**
     * @param eObject
     *            The object.
     * @return The URI String of the given object.
     */
    public static String getResourceURI(EObject eObject) {
        URI uri = eObject.eResource().getURI();
        String fragment = eObject.eResource().getURIFragment(eObject);
        URI fullUri = uri.appendFragment(fragment);
        
        return fullUri.toString();
    }
}
