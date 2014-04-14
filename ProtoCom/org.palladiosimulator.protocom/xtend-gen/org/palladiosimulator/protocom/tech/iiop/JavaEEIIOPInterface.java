package org.palladiosimulator.protocom.tech.iiop;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.IJeeInterface;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class JavaEEIIOPInterface<E extends Entity> extends ConceptMapping<E> implements IJeeInterface {
  public JavaEEIIOPInterface(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String packageName() {
    return JavaNames.fqnJavaEEInterfacePackage(this.pcmEntity);
  }
  
  public String compilationUnitName() {
    return JavaNames.fqnJavaEEInterfaceName(this.pcmEntity);
  }
  
  public Collection<String> interfaces() {
    return CollectionLiterals.<String>newLinkedList();
  }
  
  public Collection<? extends IJMethod> methods() {
    return CollectionLiterals.<IJMethod>newLinkedList();
  }
  
  public Collection<? extends IJField> fields() {
    return CollectionLiterals.<IJField>newLinkedList();
  }
  
  public String filePath() {
    return JavaNames.fqnJavaEEOperationInterfacePath(this.pcmEntity);
  }
  
  public String jeeInterfaceAnnotation() {
    return JavaConstants.JEE_INTERFACE_ANNOTATION_REMOTE;
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEOperationInterfaceProjectName(this.pcmEntity);
  }
}
