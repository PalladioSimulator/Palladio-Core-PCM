package com.palladio_simulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaNames;
import com.palladio_simulator.protocom.tech.rmi.PojoClass;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Provider for port classes based on provided roles. Please not that InfrastructureProvidedRoles
 * were - to some degree - hacked into the PCM such that cumbersome case distinction for
 * Operation and Infrastructure is necessary.
 * 
 * Possible TODO is to split PojoBasicComponentPortClass into two classes with a common super type.
 * Keep in mind though that InfrastructureComponents in ProtoCom are not generated, but rather calls
 * to the real infrastructure!
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class PojoBasicComponentPortClass /* extends /* PojoClass<ProvidedRole> */  */{
  public PojoBasicComponentPortClass(final /* ProvidedRole */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidingEntity_ProvidedRole cannot be resolved");
  }
  
  public String packageName() {
    Object _fqnPortPackage = JavaNames.fqnPortPackage(this.pcmEntity);
    return _fqnPortPackage;
  }
  
  public String compilationUnitName() {
    Object _portClassName = JavaNames.portClassName(this.pcmEntity);
    return _portClassName;
  }
  
  public Collection<String> interfaces() {
    Object _providedRoleInterface = this.providedRoleInterface(this.pcmEntity);
    return Collections.<Object>unmodifiableList(Lists.<Object>newArrayList(_providedRoleInterface));
  }
  
  public Collection<? extends IJMethod> constructors() {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public Collection<? extends IJMethod> methods() {
    Object _providedRoleMethods = this.providedRoleMethods(this.pcmEntity);
    return _providedRoleMethods;
  }
  
  public String filePath() {
    Object _fqnPortPackage = JavaNames.fqnPortPackage(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnPortPackage);
    String _plus = (_fqnToDirectoryPath + "/");
    Object _portClassName = JavaNames.portClassName(this.pcmEntity);
    String _plus_1 = (_plus + _portClassName);
    String _plus_2 = (_plus_1 + ".java");
    return _plus_2;
  }
  
  protected Object _providedRoleMethods(final /* OperationProvidedRole */Object role) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Object to OperationSignature"
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved"
      + "\nsignatures__OperationInterface cannot be resolved"
      + "\nmap cannot be resolved");
  }
  
  protected Object _providedRoleMethods(final /* InfrastructureProvidedRole */Object role) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Object to OperationSignature"
      + "\nprovidedInterface__InfrastructureProvidedRole cannot be resolved"
      + "\ninfrastructureSignatures__InfrastructureInterface cannot be resolved"
      + "\nmap cannot be resolved");
  }
  
  protected Object _providedRoleInterface(final /* OperationProvidedRole */Object role) {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved");
  }
  
  protected Object _providedRoleInterface(final /* InfrastructureProvidedRole */Object role) {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidedInterface__InfrastructureProvidedRole cannot be resolved");
  }
  
  public Object providedRoleMethods(final OperationProvidedRole role) {
    if (role != null) {
      return _providedRoleMethods(role);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(role).toString());
    }
  }
  
  public Object providedRoleInterface(final OperationProvidedRole role) {
    if (role != null) {
      return _providedRoleInterface(role);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(role).toString());
    }
  }
}
