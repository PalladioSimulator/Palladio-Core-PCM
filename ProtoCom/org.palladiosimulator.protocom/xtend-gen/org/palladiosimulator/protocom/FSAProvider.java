package org.palladiosimulator.protocom;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Google Guice provider for FileSystemAccess. It configures and
 * injects into FSA objects.
 * 
 * TODO: Class is unfinished. Read configuration from wizard pages.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class FSAProvider implements Provider<AbstractFileSystemAccess2> {
  @Inject
  private Injector injector;
  
  @Inject
  @Named("ProjectURI")
  private String projectURI;
  
  public AbstractFileSystemAccess2 get() {
    try {
      EclipseResourceFileSystemAccess2 _xblockexpression = null;
      {
        IWorkspace _workspace = ResourcesPlugin.getWorkspace();
        final IWorkspaceRoot root = _workspace.getRoot();
        final IProject project = root.getProject(this.projectURI);
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        project.open(_nullProgressMonitor);
        final EclipseResourceFileSystemAccess2 fsa = this.injector.<EclipseResourceFileSystemAccess2>getInstance(EclipseResourceFileSystemAccess2.class);
        Map<String,OutputConfiguration> _defaultConfig = this.defaultConfig();
        fsa.setOutputConfigurations(_defaultConfig);
        fsa.setProject(project);
        NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
        fsa.setMonitor(_nullProgressMonitor_1);
        _xblockexpression = fsa;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Map<String,OutputConfiguration> defaultConfig() {
    Map<String,OutputConfiguration> _xblockexpression = null;
    {
      final OutputConfiguration defaultOutput = new OutputConfiguration("PCM");
      defaultOutput.setDescription("Output Folder");
      defaultOutput.setOutputDirectory("./src");
      defaultOutput.setOverrideExistingResources(true);
      defaultOutput.setCreateOutputDirectory(true);
      defaultOutput.setCleanUpDerivedResources(true);
      defaultOutput.setSetDerivedProperty(true);
      final Map<String,OutputConfiguration> map = new HashMap<String, OutputConfiguration>();
      map.put("PCM", defaultOutput);
      _xblockexpression = map;
    }
    return _xblockexpression;
  }
}
