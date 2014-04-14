package org.palladiosimulator.protocom.tech.iiop;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.palladiosimulator.protocom.lang.xml.IJeeEjbDescriptor;
import org.palladiosimulator.protocom.lang.xml.IJeeGlassfishEjbDescriptor;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class JavaEEIIOPDescriptor<E extends Entity> extends ConceptMapping<E> implements IJeeEjbDescriptor, IJeeGlassfishEjbDescriptor {
  public JavaEEIIOPDescriptor(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String ejbName() {
    return null;
  }
  
  public Collection<String> ejbRefName() {
    return CollectionLiterals.<String>newLinkedList();
  }
  
  public String displayName() {
    return null;
  }
  
  public String filePath() {
    return null;
  }
  
  public String ejbClientJar() {
    return null;
  }
  
  public String jndiName() {
    return null;
  }
  
  public String projectName() {
    return null;
  }
}
