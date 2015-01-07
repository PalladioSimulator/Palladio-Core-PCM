package de.uka.ipd.sdq.simucom.rerunSimulation.filter;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.dialogs.PatternFilter;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComNature;

public class ProjectFilterPattern extends PatternFilter {

    @Override
    public boolean isElementVisible(Viewer viewer, Object element) {
        boolean visible = false;
        
        if (element instanceof IProject) { 
            IProject project = (IProject) element;
            try {
                IProjectDescription descr = project.getDescription();
                if (descr.hasNature(SimuComNature.NATURE_ID)) {
                    visible = true;
                }
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
        
        return visible;
    }
}
