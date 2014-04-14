package org.palladiosimulator.protocom.tech.iiop.repository;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPManifest;

@SuppressWarnings("all")
public class JavaEEIIOPClientManifest extends JavaEEIIOPManifest {
  public JavaEEIIOPClientManifest(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String classPath() {
    return null;
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEOperationInterfaceProjectName(this.pcmEntity);
  }
}
