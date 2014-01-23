package org.palladiosimulator.protocom.tech.iiop.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.palladiosimulator.protocom.lang.java.IJeeGlassfishEjbDescriptor;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class JavaEEIIOPGlassfishEjbDescriptor<E extends Entity> extends ConceptMapping<E> implements IJeeGlassfishEjbDescriptor {
  public JavaEEIIOPGlassfishEjbDescriptor(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String ejbName() {
    String _javaName = JavaNames.javaName(this.pcmEntity);
    return _javaName;
  }
  
  public String ejbRefName() {
    return "Remote Required EJB Name";
  }
  
  public String jndiName() {
    return "Corba IP Bla Bla";
  }
  
  public String filePath() {
    String _filePath = JavaNames.getFilePath(this.pcmEntity);
    String _plus = (_filePath + "/META-INF/glassfish-ejb-jar.xml");
    return _plus;
  }
}
