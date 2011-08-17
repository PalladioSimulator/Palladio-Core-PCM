package de.uka.ipd.sdq.cip.runtime.runconfig.tabs;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractCipLaunchConfigurationTab extends
		AbstractLaunchConfigurationTab {

	protected IResource getSelectedResource() {
		IWorkbench iworkbench = PlatformUI.getWorkbench();
		if (iworkbench == null) return null;
		IWorkbenchWindow iworkbenchwindow = iworkbench.getActiveWorkbenchWindow();
		if (iworkbenchwindow == null) return null;
		IWorkbenchPage iworkbenchpage = iworkbenchwindow.getActivePage();
		if (iworkbenchpage == null) return null;
		//the current selection in the entire page
		ISelection selection = iworkbenchpage.getSelection();
		if (!(selection instanceof IStructuredSelection))
	         return null;
		IStructuredSelection ss = (IStructuredSelection) selection;
	    Object element = ss.getFirstElement();
	    if (element instanceof IResource)
	       return (IResource) element;
	    if (!(element instanceof IAdaptable))
	       return null;
	      IAdaptable adaptable = (IAdaptable)element;
	      Object adapter = adaptable.getAdapter(IResource.class);
	      return (IResource) adapter;
	}
	
	protected IProject getSelectedProject() {
		IResource resource = getSelectedResource();
		if(resource == null) return null;
		return resource.getProject();
	}
	
	protected IResource[] getFeatureConfig() {
		return null;
	}
}
