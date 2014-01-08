package com.palladio_simulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaNames;
import com.palladio_simulator.protocom.tech.rmi.PojoInterface;
import java.util.Collection;
import java.util.Collections;

/**
 * Defining the content of component implementation interfaces (the interfaces for the
 * classes implementing the component behavior).
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class PojoComponentClassInterface /* extends /* PojoInterface<BasicComponent> */  */{
  public PojoComponentClassInterface(final /* BasicComponent */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String compilationUnitName() {
    String _interfaceName = JavaNames.interfaceName(this.pcmEntity);
    return _interfaceName;
  }
  
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList("com.palladio_simulator.protocom.framework.IComponent"));
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nThe method describedService__SEFF is undefined for the type PojoComponentClassInterface"
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoComponentClassInterface"
      + "\nThe method providedInterface__OperationProvidedRole is undefined for the type PojoComponentClassInterface"
      + "\nserviceEffectSpecifications__BasicComponent cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nmap cannot be resolved");
  }
  
  public String filePath() {
    Object _fqnInterface = JavaNames.fqnInterface(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnInterface);
    String _plus = (_fqnToDirectoryPath + ".java");
    return _plus;
  }
}
