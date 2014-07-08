package de.uka.ipd.sdq.simucomframework;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * This class provides static helper methods for accessing models during runtime. Models are stored
 * in resources, identified by resource URIs. Concrete model elements are identified by their
 * fragments.
 * 
 * TODO Move this class to Palladio Commons?
 * 
 * @author Sebastian Lehrig
 */
public class ModelsAtRuntime {

    /**
     * Loads the EObject specified by the given resource URI. The resource URI has to include the
     * concrete fragment that references the EObject; otherwise an EObject cannot be uniquely
     * identified in a given resource. For example, the String
     * "platform:/resource/myProject/daufault.usagemodel#_ieXlgKDrEeKjDcfkNgs1Gg" correctly includes
     * a fragment while "platform:/resource/myProject/daufault.usagemodel" does not.
     * 
     * @param resourceURI
     *            Resource URI to a given EObject (has to include fragment).
     * @return The referenced EObject.
     */
    public static EObject loadModel(final String resourceURI) {
        final URI modelUri = URI.createURI(resourceURI);
        final ResourceSet resourceSet = new ResourceSetImpl();
        final Resource resource = resourceSet.createResource(modelUri);

        try {
            resource.load(Collections.EMPTY_MAP);
        } catch (final IOException e) {
            // TODO Auto-generated catch block. Use eclipse error log instead?
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        if (modelUri.fragment() == null) {
            throw new IllegalArgumentException(
                    "The resource URI has to include the concrete fragment that references the EObject;"
                            + "otherwise an EObject cannot be uniquely identified in a given resource");
        }

        return resource.getEObject(modelUri.fragment());
    }

    /**
     * Created a resource URI for a given EObject; including its fragment that uniquely identifies
     * the EObject within the resource.
     * 
     * @param eObject
     *            The given EObject.
     * @return The URI String of the given object; including its fragment.
     */
    public static String getResourceURI(final EObject eObject) {
        final URI uri = eObject.eResource().getURI();
        final String fragment = eObject.eResource().getURIFragment(eObject);
        final URI fullUri = uri.appendFragment(fragment);

        return fullUri.toString();
    }
}
