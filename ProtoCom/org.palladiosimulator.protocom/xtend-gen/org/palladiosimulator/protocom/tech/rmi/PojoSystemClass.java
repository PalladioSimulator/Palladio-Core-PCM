package org.palladiosimulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.rmi.PojoComposedStructureClass;

@SuppressWarnings("all")
public class PojoSystemClass extends PojoComposedStructureClass<System> {
  public PojoSystemClass(final System pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<String> interfaces() {
    String _interfaceName = JavaNames.interfaceName(this.pcmEntity);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_interfaceName, JavaConstants.SERIALIZABLE_INTERFACE));
  }
  
  public Collection<? extends IJMethod> constructors() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nThe method providedRoles_InterfaceProvidingEntity is undefined for the type PojoSystemClass"
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoSystemClass"
      + "\nThe method providedInterface__OperationProvidedRole is undefined for the type PojoSystemClass"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nassemblyContext_ProvidedDelegationConnector cannot be resolved");
  }
  
  public Collection<? extends IJField> fields() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method assemblyContexts__ComposedStructure is undefined for the type PojoSystemClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoSystemClass"
      + "\nmap cannot be resolved");
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nInfrastructureProvidedRole cannot be resolved to a type."
      + "\nThe method assemblyContexts__ComposedStructure is undefined for the type PojoSystemClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoSystemClass"
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoSystemClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoSystemClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoSystemClass"
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoSystemClass"
      + "\nThe method id is undefined for the type PojoSystemClass"
      + "\nThe method assemblyContexts__ComposedStructure is undefined for the type PojoSystemClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoSystemClass"
      + "\nThe method or field InfrastructureProvidedRole is undefined for the type PojoSystemClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoSystemClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoSystemClass"
      + "\nThe method or field InfrastructureProvidedRole is undefined for the type PojoSystemClass"
      + "\nThe method id is undefined for the type PojoSystemClass"
      + "\nThe method assemblyContexts__ComposedStructure is undefined for the type PojoSystemClass"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nget cannot be resolved"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nget cannot be resolved");
  }
}
