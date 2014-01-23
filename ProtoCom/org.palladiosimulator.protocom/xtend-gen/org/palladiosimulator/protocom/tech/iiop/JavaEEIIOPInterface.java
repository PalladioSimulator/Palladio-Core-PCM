package org.palladiosimulator.protocom.tech.iiop;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Collection;
import java.util.LinkedList;
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
    String _implementationPackage = JavaNames.implementationPackage(this.pcmEntity);
    return _implementationPackage;
  }
  
  public String compilationUnitName() {
    String _javaName = JavaNames.javaName(this.pcmEntity);
    return _javaName;
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
  
  public String filePath() {
    String _fileName = JavaNames.getFileName(this.pcmEntity);
    return _fileName;
  }
  
  public String jeeInterfaceRemoteAnnotation() {
    return JavaConstants.JEE_INTERFACE_ANNOTATION_REMOTE;
  }
}
