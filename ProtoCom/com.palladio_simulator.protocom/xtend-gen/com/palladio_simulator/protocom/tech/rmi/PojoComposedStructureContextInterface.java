package com.palladio_simulator.protocom.tech.rmi;

import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaNames;
import com.palladio_simulator.protocom.tech.rmi.PojoInterface;
import java.util.Collection;

@SuppressWarnings("all")
public class PojoComposedStructureContextInterface /* extends /* PojoInterface<InterfaceRequiringEntity> */  */{
  public PojoComposedStructureContextInterface(final /* InterfaceRequiringEntity */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String packageName() {
    Object _fqnContextPackage = JavaNames.fqnContextPackage(this.pcmEntity);
    return _fqnContextPackage;
  }
  
  public String compilationUnitName() {
    String _contextInterfaceName = JavaNames.contextInterfaceName(this.pcmEntity);
    return _contextInterfaceName;
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationRequiredRole cannot be resolved to a type."
      + "\nOperationRequiredRole cannot be resolved to a type."
      + "\nThe method or field OperationRequiredRole is undefined for the type PojoComposedStructureContextInterface"
      + "\nThe method or field OperationRequiredRole is undefined for the type PojoComposedStructureContextInterface"
      + "\nrequiredRoles_InterfaceRequiringEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nrequiredInterface__OperationRequiredRole cannot be resolved"
      + "\nrequiredRoles_InterfaceRequiringEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nrequiredInterface__OperationRequiredRole cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public String filePath() {
    Object _fqnContextInterface = JavaNames.fqnContextInterface(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnContextInterface);
    String _plus = (_fqnToDirectoryPath + ".java");
    return _plus;
  }
}
