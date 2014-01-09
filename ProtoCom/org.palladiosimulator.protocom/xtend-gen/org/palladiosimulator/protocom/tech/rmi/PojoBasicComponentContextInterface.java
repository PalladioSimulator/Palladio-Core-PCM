package org.palladiosimulator.protocom.tech.rmi;

import java.util.Collection;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.rmi.PojoInterface;

@SuppressWarnings("all")
public class PojoBasicComponentContextInterface /* extends /* PojoInterface<BasicComponent> */  */{
  public PojoBasicComponentContextInterface(final /* BasicComponent */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String filePath() {
    Object _fqnContextInterface = JavaNames.fqnContextInterface(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnContextInterface);
    String _plus = (_fqnToDirectoryPath + ".java");
    return _plus;
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
      + "\nThe method or field OperationRequiredRole is undefined for the type PojoBasicComponentContextInterface"
      + "\nThe method or field OperationRequiredRole is undefined for the type PojoBasicComponentContextInterface"
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
}
