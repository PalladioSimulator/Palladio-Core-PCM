package org.palladiosimulator.protocom.tech.rmi;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.palladiosimulator.protocom.lang.java.IJClass;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.ConceptMapping;

/**
 * Common super type for all provider creating Java classes. Defines default values
 * for all templates.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public abstract class PojoClass<E extends Entity> extends ConceptMapping<E> implements IJClass {
  public PojoClass(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    return null;
  }
  
  public Collection<? extends IJMethod> constructors() {
    return CollectionLiterals.<IJMethod>newLinkedList();
  }
  
  public String packageName() {
    return JavaNames.implementationPackage(this.pcmEntity);
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
    return JavaNames.getFileName(this.pcmEntity);
  }
  
  public String projectName() {
    return null;
  }
}
