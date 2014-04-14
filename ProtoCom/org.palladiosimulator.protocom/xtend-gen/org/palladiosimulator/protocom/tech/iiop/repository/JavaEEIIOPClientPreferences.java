package org.palladiosimulator.protocom.tech.iiop.repository;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPPreferences;

@SuppressWarnings("all")
public class JavaEEIIOPClientPreferences extends JavaEEIIOPPreferences {
  public JavaEEIIOPClientPreferences(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEOperationInterfaceProjectName(this.pcmEntity);
  }
}
