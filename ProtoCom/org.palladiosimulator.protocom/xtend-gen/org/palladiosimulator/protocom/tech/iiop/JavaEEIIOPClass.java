package org.palladiosimulator.protocom.tech.iiop;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.IJeeClass;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class JavaEEIIOPClass<E extends Entity> extends ConceptMapping<E> implements IJeeClass {
  public JavaEEIIOPClass(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    return null;
  }
  
  public Collection<? extends IJMethod> constructors() {
    return CollectionLiterals.<IJMethod>newLinkedList();
  }
  
  public String packageName() {
    return null;
  }
  
  public String compilationUnitName() {
    return JavaNames.javaName(this.pcmEntity);
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
    return JavaNames.fqnJavaEEBasicComponentClassPath(this.pcmEntity);
  }
  
  public String jeeClassStatelessAnnotation() {
    return JavaConstants.JEE_EJB_ANNOTATION_STATELESS;
  }
  
  public String jeeClassDependencyInjectionAnnotation() {
    return JavaConstants.JEE_EJB_ANNOTATION_EJB;
  }
  
  public Collection<? extends IJField> jeeClassDependencyInjection() {
    return CollectionLiterals.<IJField>newLinkedList();
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEBasicComponentProjectName(this.pcmEntity);
  }
}
