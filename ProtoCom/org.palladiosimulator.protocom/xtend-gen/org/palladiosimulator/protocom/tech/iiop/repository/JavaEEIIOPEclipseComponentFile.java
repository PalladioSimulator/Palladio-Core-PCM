package org.palladiosimulator.protocom.tech.iiop.repository;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPComponentFile;

@SuppressWarnings("all")
public class JavaEEIIOPEclipseComponentFile extends JavaEEIIOPComponentFile<BasicComponent> {
  public JavaEEIIOPEclipseComponentFile(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String wbModuleDeployName() {
    return JavaNames.fqnJavaEEBasicComponentClassPackage(this.pcmEntity);
  }
  
  public String wbResource() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("tag=\"defaultRootSource\"");
    return _builder.toString();
  }
  
  public String property() {
    return JavaNames.fqnJavaEEBasicComponentClassPackage(this.pcmEntity);
  }
  
  public String filePath() {
    String _fqnJavaEEPreferencesPath = JavaNames.fqnJavaEEPreferencesPath(this.pcmEntity);
    return (_fqnJavaEEPreferencesPath + "org.eclipse.wst.common.component");
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEDescriptorProjectName(this.pcmEntity);
  }
}
