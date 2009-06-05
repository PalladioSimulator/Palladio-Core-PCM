package de.uka.sdq.pcm.transformations;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.openarchitectureware.emf.XmiReader;
import org.openarchitectureware.workflow.ConfigurationException;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

public class SameResourceSetXmiReader extends XmiReader {

	protected static ResourceSet rs = new ResourceSetImpl();
	
	@Override
	public void invoke(WorkflowContext model, ProgressMonitor monitor,
			Issues issues) {
        final File f = loadFile(issues);
        final URI fileURI = URI.createFileURI(f.getAbsolutePath());

        final Resource r = rs.createResource(fileURI);
        try {
            r.load(null);
        } catch (final IOException e) {
            throw new ConfigurationException(e);
        }

        if (firstElementOnly) {
            model.set(outputSlot, r.getContents().get(0));
        } else {
            model.set(outputSlot, r.getContents());
        }
	}

}
