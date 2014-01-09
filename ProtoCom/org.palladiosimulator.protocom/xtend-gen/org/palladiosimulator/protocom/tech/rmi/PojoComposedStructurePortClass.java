package org.palladiosimulator.protocom.tech.rmi;

import java.util.Arrays;
import java.util.Collection;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.rmi.PojoClass;

@SuppressWarnings("all")
public class PojoComposedStructurePortClass /* extends /* PojoClass<ProvidedRole> */  */{
  public PojoComposedStructurePortClass(final /* ProvidedRole */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    return JavaConstants.RMI_REMOTE_OBJECT_CLASS;
  }
  
  public Collection<? extends IJField> fields() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved");
  }
  
  public Collection<? extends IJMethod> constructors() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidingEntity_ProvidedRole cannot be resolved");
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
  
  public Object providedRoleMethods(final OperationProvidedRole role) {
    if (role != null) {
      return _providedRoleMethods(role);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(role).toString());
    }
  }
}
