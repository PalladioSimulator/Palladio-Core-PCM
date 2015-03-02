package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * Class for the SimuCom Project Nature. This project nature is attached to every project that is
 * generated before the SimuCom Simulation starts.
 * 
 * This is an implementation of org.eclipse.core.resources.natures extension point and was only
 * intended to support de.uka.ipd.sdq.simucom.rerunsimulation plug-in
 * 
 * @author Michael Junker
 *
 */
public class SimuComNature implements IProjectNature {

    /**
     * The id of this project nature. Can be used to search for projects containing this nature
     */
    public static final String NATURE_ID = "de.uka.ipd.sdq.codegen.simucontroller.runconfig.simucomnature";

    private IProject project;

    @Override
    public void configure() throws CoreException {
    }

    @Override
    public void deconfigure() throws CoreException {
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
