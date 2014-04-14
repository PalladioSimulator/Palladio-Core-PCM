package org.palladiosimulator.protocom.tech.iiop.repository;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPEclipseComponentFile;

@SuppressWarnings("all")
public class JavaEEIIOPEclipseClientComponentFile extends JavaEEIIOPEclipseComponentFile {
  public JavaEEIIOPEclipseClientComponentFile(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String wbResource() {
    return null;
  }
  
  public String property() {
    return null;
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEOperationInterfaceProjectName(this.pcmEntity);
  }
}
