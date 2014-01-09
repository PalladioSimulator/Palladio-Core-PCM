package com.palladio_simulator.protocom.tech.rmi;

import com.palladio_simulator.protocom.lang.java.IJField;
import com.palladio_simulator.protocom.lang.java.IJInterface;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaNames;
import com.palladio_simulator.protocom.tech.ConceptMapping;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Collection;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Common super type for all provider creating Java interfaces. Defines default values
 * for all templates.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public abstract class PojoInterface<E extends Entity> extends ConceptMapping<E> implements IJInterface {
  public PojoInterface(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String packageName() {
    String _implementationPackage = JavaNames.implementationPackage(this.pcmEntity);
    return _implementationPackage;
  }
  
  public String compilationUnitName() {
    String _javaName = JavaNames.javaName(this.pcmEntity);
    return _javaName;
  }
  
  public String filePath() {
    String _fileName = JavaNames.getFileName(this.pcmEntity);
    return _fileName;
  }
  
  public Collection<String> interfaces() {
    LinkedList<String> _newLinkedList = CollectionLiterals.<String>newLinkedList();
    return _newLinkedList;
  }
  
  public Collection<? extends IJMethod> methods() {
    LinkedList<IJMethod> _newLinkedList = CollectionLiterals.<IJMethod>newLinkedList();
    return _newLinkedList;
  }
  
  public Collection<? extends IJField> fields() {
    LinkedList<IJField> _newLinkedList = CollectionLiterals.<IJField>newLinkedList();
    return _newLinkedList;
  }
}
