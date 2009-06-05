package de.uka.ipd.sdq.pcmbench.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class PalladioProjectNature implements IProjectNature {

	IProject project;
	
	public void configure() throws CoreException {
		// TODO Auto-generated method stub

	}

	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

}
