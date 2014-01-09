package org.palladiosimulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.rmi.PojoClass;

@SuppressWarnings("all")
public class PojoBasicComponentClass /* extends /* PojoClass<BasicComponent> */  */{
  public PojoBasicComponentClass(final /* BasicComponent */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<String> interfaces() {
    String _interfaceName = JavaNames.interfaceName(this.pcmEntity);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_interfaceName));
  }
  
  public Collection<? extends IJMethod> constructors() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nInfrastructureProvidedRole cannot be resolved to a type."
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoBasicComponentClass"
      + "\nThe method or field InfrastructureProvidedRole is undefined for the type PojoBasicComponentClass"
      + "\nThe method entityName is undefined for the type PojoBasicComponentClass"
      + "\nThe method capacity_PassiveResource is undefined for the type PojoBasicComponentClass"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\npassiveResource_BasicComponent cannot be resolved"
      + "\nspecification cannot be resolved");
  }
  
  public Collection<? extends IJField> fields() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nInfrastructureProvidedRole cannot be resolved to a type."
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoBasicComponentClass"
      + "\nThe method providedInterface__OperationProvidedRole is undefined for the type PojoBasicComponentClass"
      + "\nThe method or field InfrastructureProvidedRole is undefined for the type PojoBasicComponentClass"
      + "\nThe method providedInterface__InfrastructureProvidedRole is undefined for the type PojoBasicComponentClass"
      + "\nThe method entityName is undefined for the type PojoBasicComponentClass"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nmap cannot be resolved"
      + "\npassiveResource_BasicComponent cannot be resolved"
      + "\nmap cannot be resolved");
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nResourceDemandingBehaviour cannot be resolved to a type."
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nThe method describedService__SEFF is undefined for the type PojoBasicComponentClass"
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoBasicComponentClass"
      + "\nserviceEffectSpecifications__BasicComponent cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nsteps_Behaviour cannot be resolved"
      + "\nget cannot be resolved"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved");
  }
}
