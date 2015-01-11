package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class SimuComNature implements IProjectNature {
    
    public static final String NATURE_ID = "de.uka.ipd.sdq.codegen.simucontroller.runconfig.simucomnature";
    
    private IProject project;

    @Override
    public void configure() throws CoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public void deconfigure() throws CoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public IProject getProject() {
        return project;
    }

    @Override
    public void setProject(IProject project) {
        this.project = project;
    }

}
