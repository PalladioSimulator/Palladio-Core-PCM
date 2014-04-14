package org.palladiosimulator.protocom;

import com.google.common.base.Objects;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.ClasspathComputer;
import org.eclipse.pde.internal.core.natures.PDE;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ProjectCompiler {
  private static IProjectDescription description;
  
  public static void compileProject(final IProject project, final IProgressMonitor monitor, final String projectType) {
    try {
      boolean _notEquals = (!Objects.equal(project, null));
      if (_notEquals) {
        ProjectCompiler.createDescription(project, monitor, projectType);
        ProjectCompiler.setProjectToJavaProject(project);
        ProjectCompiler.setClasspath(project);
        ProjectCompiler.refreshPluginInWorkspace(monitor, project);
        ProjectCompiler.buildProject(monitor, project);
        ProjectCompiler.checkForErrors(project);
      } else {
        throw new Error("Compiling the project failed because it does not exist");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Create a project description and set the JavaCore.NATURE_ID and
   * PDE.PLUGIN_NATURE
   */
  private static void createDescription(final IProject project, final IProgressMonitor monitor, final String projectType) throws JobFailedException {
    boolean _or = false;
    boolean _equals = Objects.equal(projectType, "PROTO");
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(projectType, "POJO");
      _or = _equals_1;
    }
    if (_or) {
      String[] natures = { JavaCore.NATURE_ID, PDE.PLUGIN_NATURE };
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      String _name = project.getName();
      IProjectDescription _newProjectDescription = _workspace.newProjectDescription(_name);
      ProjectCompiler.description = _newProjectDescription;
      ProjectCompiler.description.setNatureIds(natures);
      ProjectCompiler.description.setLocation(null);
      ICommand command = ProjectCompiler.description.newCommand();
      command.setBuilderName(JavaCore.BUILDER_ID);
      ICommand[] buildCommand = { command };
      ProjectCompiler.description.setBuildSpec(buildCommand);
      try {
        project.setDescription(ProjectCompiler.description, monitor);
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
          throw new JobFailedException("Failed setting Java and PDE nature and builders", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } else {
      boolean _equals_2 = Objects.equal(projectType, "EJB3");
      if (_equals_2) {
        String[] natures_1 = { "org.eclipse.jem.workbench.JavaEMFNature", "org.eclipse.wst.common.modulecore.ModuleCoreNature", "org.eclipse.wst.common.project.facet.core.nature", "org.eclipse.jdt.core.javanature" };
        IWorkspace _workspace_1 = ResourcesPlugin.getWorkspace();
        String _name_1 = project.getName();
        IProjectDescription _newProjectDescription_1 = _workspace_1.newProjectDescription(_name_1);
        ProjectCompiler.description = _newProjectDescription_1;
        ProjectCompiler.description.setNatureIds(natures_1);
        ProjectCompiler.description.setLocation(null);
        ICommand command_1 = ProjectCompiler.description.newCommand();
        ICommand commandFacet = ProjectCompiler.description.newCommand();
        ICommand commandValidationBuilder = ProjectCompiler.description.newCommand();
        command_1.setBuilderName(JavaCore.BUILDER_ID);
        commandFacet.setBuilderName("org.eclipse.wst.common.project.facet.core.builder");
        commandValidationBuilder.setBuilderName("org.eclipse.wst.validation.validationbuilder");
        ICommand[] buildCommand_1 = { command_1, commandFacet, commandValidationBuilder };
        ProjectCompiler.description.setBuildSpec(buildCommand_1);
        try {
          project.setDescription(ProjectCompiler.description, monitor);
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof CoreException) {
            final CoreException e_1 = (CoreException)_t_1;
            throw new JobFailedException("Failed setting Java EE nature and builders", e_1);
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      }
    }
  }
  
  /**
   * Create the Java-Project from IProject and set "src", "bin" folder to
   * classpath
   */
  private static void setProjectToJavaProject(final IProject project) throws JobFailedException {
    IJavaProject javaProject = JavaCore.create(project);
    IPath _path = javaProject.getPath();
    IPath srcPath = _path.append("src");
    IPath _path_1 = javaProject.getPath();
    IPath binPath = _path_1.append("bin");
    IClasspathEntry _newSourceEntry = JavaCore.newSourceEntry(srcPath);
    IClasspathEntry _defaultJREContainerEntry = JavaRuntime.getDefaultJREContainerEntry();
    IClasspathEntry[] buildPath = new IClasspathEntry[] { _newSourceEntry, _defaultJREContainerEntry };
    try {
      javaProject.setRawClasspath(buildPath, binPath, null);
    } catch (final Throwable _t) {
      if (_t instanceof JavaModelException) {
        final JavaModelException e = (JavaModelException)_t;
        throw new JobFailedException("Failed setting up JDT project", e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * (non-Javadoc)
   * @See org.eclipse.pde.internal.ui.wizards.plugin.ClasspathComputer.setClasspath(IProject)
   */
  private static void setClasspath(final IProject project) throws JobFailedException {
    try {
      IPluginModelBase _findModel = PluginRegistry.findModel(project);
      ClasspathComputer.setClasspath(project, _findModel);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        throw new JobFailedException("Failed to set JDT classpath", e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * @param monitor
   * @param project
   * @throws JobFailedException
   */
  private static void refreshPluginInWorkspace(final IProgressMonitor monitor, final IProject project) throws JobFailedException {
    try {
      project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        throw new JobFailedException("Refreshing plugin project failed", e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * @param monitor
   * @param project
   * @throws JobFailedException
   */
  private static void buildProject(final IProgressMonitor monitor, final IProject project) throws JobFailedException {
    try {
      project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        throw new JobFailedException("Building plugin project failed", e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * @param project
   * @throws JobFailedException
   */
  private static void checkForErrors(final IProject project) throws JobFailedException {
    try {
      IMarker[] _findMarkers = project.findMarkers(IMarker.PROBLEM, true, 
        IResource.DEPTH_INFINITE);
      int _length = _findMarkers.length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        boolean failed = false;
        IMarker[] markers = project.findMarkers(IMarker.PROBLEM, true, 
          IResource.DEPTH_INFINITE);
        String errorList = "";
        for (final IMarker marker : markers) {
          Object _attribute = marker.getAttribute(IMarker.SEVERITY);
          boolean _equals = Objects.equal(_attribute, Integer.valueOf(IMarker.SEVERITY_ERROR));
          if (_equals) {
            Object _attribute_1 = marker.getAttribute(IMarker.MESSAGE);
            String _plus = (errorList + _attribute_1);
            String _plus_1 = (_plus + "\n");
            errorList = _plus_1;
            failed = true;
          }
        }
        if (failed) {
          throw new JobFailedException(
            ("Unable to build the simulation plugin. Failure Messages: " + errorList));
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        throw new JobFailedException(
          "Compile Plugin failed. Error finding project markers.", e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
