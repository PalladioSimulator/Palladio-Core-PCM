package de.uka.ipd.sdq.simucomframework;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class ModelsAtRuntime {
    
    private static final String MODEL_FOLDER_NAME = "model";

    public static EObject loadModel(final String project, final String relativePath, final String uniqueID) {
        IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(project);
        assert (iProject != null);

        IFolder modelFolder = iProject.getFolder(MODEL_FOLDER_NAME);
        String modelBasePath = "file:/" + modelFolder.getLocation().toOSString();

        URI modelUri = URI.createURI(modelBasePath + "/" + relativePath);
        
        final ResourceSet resourceSet = new ResourceSetImpl();
        final Resource resource = resourceSet.createResource(modelUri);
        
        try {
            resource.load(Collections.EMPTY_MAP);
        } catch (final IOException e) {
            // TODO Auto-generated catch block. Use eclipse error log instead?
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
        return resource.getEObject(uniqueID);
    }
}
