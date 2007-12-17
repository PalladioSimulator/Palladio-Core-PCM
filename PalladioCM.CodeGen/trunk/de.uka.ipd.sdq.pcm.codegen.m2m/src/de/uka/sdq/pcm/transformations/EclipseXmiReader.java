package de.uka.sdq.pcm.transformations;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.openarchitectureware.emf.XmiReader;
import org.openarchitectureware.workflow.ConfigurationException;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

public class EclipseXmiReader extends XmiReader {

	@Override
	public void checkConfiguration(Issues issues) {
		try {
			final URI fileURI = URI.createURI(this.modelFile);
			ResourceSet rset = new ResourceSetImpl();
			Resource r = rset.createResource(fileURI);
			r.load(null);
		} catch (Exception ex) {
			this.modelFile = "file:/" + this.modelFile;
			final URI fileURI = URI.createURI(this.modelFile);
			ResourceSet rset = new ResourceSetImpl();
			Resource r = rset.createResource(fileURI);
			try {
				r.load(null);
			} catch (IOException e) {
				issues.addError("File not found: " + modelFile + " Exception: "+ex.getClass().getCanonicalName() + ", "+ex.toString());
			}
		}
	}


	@Override
	public void invoke(WorkflowContext model, ProgressMonitor monitor,
			Issues issues) {
		
		ResourceSet rs = new ResourceSetImpl();
    	URI fileURI = URI.createURI(this.modelFile);
    	
    	if (fileURI.isFile()) {
    		final File f = loadFile(issues);
        	fileURI = URI.createFileURI(f.getAbsolutePath());
    	}
    	
        Resource r = null;
        try {
            r = rs.getResource(fileURI, true);
        } catch (final Exception e) {
            throw new ConfigurationException(e);
        }

        if (firstElementOnly) {
            model.set(outputSlot, r.getContents().get(0));
        } else {
            model.set(outputSlot, r.getContents());
        }
	}

}
