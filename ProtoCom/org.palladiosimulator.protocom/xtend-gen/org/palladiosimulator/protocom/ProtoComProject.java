package org.palladiosimulator.protocom;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sebastian Lehrig, Daria Giacinto
 * TODO Modify JavaDoc
 */
@SuppressWarnings("all")
public class ProtoComProject {
  /**
   * Logger for this class.
   */
  private static Logger logger = Logger.getLogger(ProtoComProject.class);
  
  private final String projectURI;
  
  private final String filePath;
  
  private final IProject iProject;
  
  public ProtoComProject(final String projectURI, final String filePath) {
    try {
      this.projectURI = projectURI;
      this.filePath = filePath;
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      IProject _createProject = this.createProject(projectURI, _nullProgressMonitor);
      this.iProject = _createProject;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private IProject createProject(final String projectURI, final IProgressMonitor monitor) throws JobFailedException {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      final IProject iProject = _root.getProject(projectURI);
      boolean _exists = iProject.exists();
      if (_exists) {
        throw new JobFailedException(
          "Tried to create an existing project. Preceeding cleanup failed");
      }
      boolean _isDebugEnabled = ProtoComProject.logger.isDebugEnabled();
      if (_isDebugEnabled) {
        String _name = this.iProject.getName();
        String _plus = ("Creating Eclipse workspace project " + _name);
        ProtoComProject.logger.debug(_plus);
      }
      iProject.create(monitor);
      iProject.open(monitor);
      return iProject;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IProject getIProject() {
    return this.iProject;
  }
}
