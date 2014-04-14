package org.palladiosimulator.protocom.tech.iiop.repository;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPMFFile;

@SuppressWarnings("all")
public class JavaEEIIOPManifest extends JavaEEIIOPMFFile<BasicComponent> {
  public JavaEEIIOPManifest(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String classPath() {
    return JavaNames.javaEEEjbClientjar(this.pcmEntity);
  }
  
  public String manifestVersion() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("1.0");
    return _builder.toString();
  }
  
  public String filePath() {
    String _fqnJavaEEDescriptorPath = JavaNames.fqnJavaEEDescriptorPath(this.pcmEntity);
    return (_fqnJavaEEDescriptorPath + "MANIFEST.MF");
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEDescriptorProjectName(this.pcmEntity);
  }
}
