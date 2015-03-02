package de.uka.ipd.sdq.simucom.rerunsimulation.filter;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.dialogs.PatternFilter;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComNature;

/**
 * This class represents a specific project de.uka.ipd.sdq.simucom.rerunsimulation.filter for file
 * choosers. This de.uka.ipd.sdq.simucom.rerunsimulation.filter hides every project in the workspace
 * that hasn't got the SimuComNature. Currently only projects generated via the SimuBench use the
 * SimuComNature
 * 
 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComNature
 * 
 * @author Michael Junker
 *
 */
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
