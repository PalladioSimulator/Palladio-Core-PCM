package org.palladiosimulator.pcm.repository.presentation;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IFileEditorInput;

public class RepositoryEditor extends RepositoryEditorGen{

    /**
     * This is the method called to load a resource into the editing domain's resource set based on
     * the editor's input. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated not
     */
    public void createModel() {
        // Assumes that the input is a file object.
        //
        final IFileEditorInput modelFile = (IFileEditorInput) this.getEditorInput();
        final URI resourceURI = URI.createPlatformResourceURI(modelFile.getFile().getFullPath().toString(), true);
        Exception exception = null;
        Resource resource = null;
        try {
            // Load the resource through the editing domain.
            //
            resource = this.editingDomain.getResourceSet().getResource(resourceURI, true);
        } catch (final Exception e) {
            exception = e;
            resource = this.editingDomain.getResourceSet().getResource(resourceURI, false);
        }

        final Diagnostic diagnostic = this.analyzeResourceProblems(resource, exception);
        if (diagnostic.getSeverity() != Diagnostic.OK) {
            this.resourceToDiagnosticMap.put(resource, this.analyzeResourceProblems(resource, exception));
        }
        this.editingDomain.getResourceSet().eAdapters().add(this.problemIndicationAdapter);

        this.addExtraResource("pathmap://PCM_MODELS/PrimitiveTypes.repository");
        this.addExtraResource("pathmap://PCM_MODELS/Palladio.resourcetype");
        this.addExtraResource("pathmap://PCM_MODELS/FailureTypes.repository");
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
