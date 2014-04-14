package org.palladiosimulator.protocom;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;

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
  
  public AbstractFileSystemAccess2 get() {
    EclipseResourceFileSystemAccess2 _xblockexpression = null;
    {
      final EclipseResourceFileSystemAccess2 fsa = this.injector.<EclipseResourceFileSystemAccess2>getInstance(EclipseResourceFileSystemAccess2.class);
      Map<String,OutputConfiguration> _defaultConfig = this.defaultConfig();
      fsa.setOutputConfigurations(_defaultConfig);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      fsa.setMonitor(_nullProgressMonitor);
      _xblockexpression = fsa;
    }
    return _xblockexpression;
  }
  
  public Map<String,OutputConfiguration> defaultConfig() {
    Map<String,OutputConfiguration> _xblockexpression = null;
    {
      final OutputConfiguration defaultOutput = new OutputConfiguration("PCM");
      defaultOutput.setDescription("Output Folder");
      defaultOutput.setOutputDirectory(".");
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
