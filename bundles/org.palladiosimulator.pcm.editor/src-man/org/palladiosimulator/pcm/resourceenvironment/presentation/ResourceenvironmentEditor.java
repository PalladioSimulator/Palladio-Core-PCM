package org.palladiosimulator.pcm.resourceenvironment.presentation;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.util.EditUIUtil;

public class ResourceenvironmentEditor extends ResourceenvironmentEditorGen {

	/**
	 * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public void createModel() {
	    URI resourceURI = EditUIUtil.getURI(getEditorInput());
	    Exception exception = null;
	    Resource resource = null;
	    try {
	        // Load the resource through the editing domain.
	        // 
	        resource = editingDomain.getResourceSet().getResource(resourceURI, true);
	    } catch (Exception e) {
	        exception = e;
	        resource = editingDomain.getResourceSet().getResource(resourceURI, false);
	    }
	    Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
	    if (diagnostic.getSeverity() != Diagnostic.OK) {
	        resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
	    }
	    editingDomain.getResourceSet().eAdapters().add(problemIndicationAdapter);
	    addExtraResource("pathmap://PCM_MODELS/PrimitiveTypes.repository");
	    addExtraResource("pathmap://PCM_MODELS/Palladio.resourcetype");
	    addExtraResource("pathmap://PCM_MODELS/FailureTypes.repository");
	}
	
    /**
     * Adds the extra resource.
     *
     * @param uri
     *            the uri
     */
    private void addExtraResource(final String uri) {
        final Resource extraResource = this.editingDomain.getResourceSet().getResource(URI.createURI(uri), true);
        try {
            extraResource.load(new HashMap<Object, Object>());
        } catch (final IOException e) {
            // FIXME: Empty catch block!
        }
    }
}
