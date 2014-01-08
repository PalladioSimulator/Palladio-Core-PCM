package com.palladio_simulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import com.palladio_simulator.protocom.lang.java.IJField;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaConstants;
import com.palladio_simulator.protocom.lang.java.util.JavaNames;
import com.palladio_simulator.protocom.tech.rmi.PojoClass;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("all")
public class PojoComposedStructureContextClass /* extends /* PojoClass<InterfaceRequiringEntity> */  */{
  public PojoComposedStructureContextClass(final /* InterfaceRequiringEntity */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<? extends IJField> fields() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationRequiredRole cannot be resolved to a type."
      + "\nThe method or field OperationRequiredRole is undefined for the type PojoComposedStructureContextClass"
      + "\nrequiredRoles_InterfaceRequiringEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nrequiredInterface__OperationRequiredRole cannot be resolved");
  }
  
  public Collection<? extends IJMethod> constructors() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationRequiredRole cannot be resolved to a type."
      + "\nrequiredRoles_InterfaceRequiringEntity cannot be resolved"
      + "\nrequiredInterface__OperationRequiredRole cannot be resolved"
      + "\nrequiredRoles_InterfaceRequiringEntity cannot be resolved");
  }
  
  public String packageName() {
    Object _fqnContextPackage = JavaNames.fqnContextPackage(this.pcmEntity);
    return _fqnContextPackage;
  }
  
  public String compilationUnitName() {
    Object _contextClassName = JavaNames.contextClassName(this.pcmEntity);
    return _contextClassName;
  }
  
  public Collection<String> interfaces() {
    String _contextInterfaceName = JavaNames.contextInterfaceName(this.pcmEntity);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_contextInterfaceName, JavaConstants.SERIALIZABLE_INTERFACE));
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationRequiredRole cannot be resolved to a type."
      + "\nOperationRequiredRole cannot be resolved to a type."
      + "\nThe method or field OperationRequiredRole is undefined for the type PojoComposedStructureContextClass"
      + "\nThe method entityName is undefined for the type PojoComposedStructureContextClass"
      + "\nThe method id is undefined for the type PojoComposedStructureContextClass"
      + "\nThe method requiringEntity_RequiredRole is undefined for the type PojoComposedStructureContextClass"
      + "\nThe method or field OperationRequiredRole is undefined for the type PojoComposedStructureContextClass"
      + "\nrequiredRoles_InterfaceRequiringEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nrequiredInterface__OperationRequiredRole cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\nrequiredRoles_InterfaceRequiringEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nrequiredInterface__OperationRequiredRole cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public String filePath() {
    Object _fqnContext = JavaNames.fqnContext(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnContext);
    String _plus = (_fqnToDirectoryPath + ".java");
    return _plus;
  }
}
