package org.palladiosimulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJInterface;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.ConceptMapping;

/**
 * Defining the content of component implementation interfaces (the interfaces for
 * the classes implementing the component behavior).
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class PojoComposedStructureInterface /* extends /* ConceptMapping<InterfaceProvidingEntity> */  */implements IJInterface {
  public PojoComposedStructureInterface(final /* InterfaceProvidingEntity */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String packageName() {
    Object _implementationPackage = JavaNames.implementationPackage(this.pcmEntity);
    return _implementationPackage;
  }
  
  public String compilationUnitName() {
    String _interfaceName = JavaNames.interfaceName(this.pcmEntity);
    return _interfaceName;
  }
  
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(JavaConstants.RMI_REMOTE_INTERFACE, JavaConstants.SERIALIZABLE_INTERFACE));
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoComposedStructureInterface"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved");
  }
  
  public Collection<? extends IJField> fields() {
    return null;
  }
  
  public String filePath() {
    Object _fqnInterface = JavaNames.fqnInterface(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnInterface);
    String _plus = (_fqnToDirectoryPath + ".java");
    return _plus;
  }
}
