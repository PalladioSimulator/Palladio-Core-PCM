package org.palladiosimulator.protocom.tech.iiop.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.palladiosimulator.protocom.lang.java.IJeeEjbDescriptor;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class JavaEEIIOPEjbDescriptor<E extends Entity> extends ConceptMapping<E> implements IJeeEjbDescriptor {
  public JavaEEIIOPEjbDescriptor(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String displayName() {
    return JavaNames.implementationPackage(this.pcmEntity);
  }
  
  public String ejbClientJar() {
    return JavaNames.implementationPackage(this.pcmEntity);
  }
  
  public String filePath() {
    String _filePath = JavaNames.getFilePath(this.pcmEntity);
    return (_filePath + "/META-INF/ejb-jar.xml");
  }
}
