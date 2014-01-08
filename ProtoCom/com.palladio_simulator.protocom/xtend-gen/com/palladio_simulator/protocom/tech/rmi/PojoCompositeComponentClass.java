package com.palladio_simulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import com.palladio_simulator.protocom.lang.java.IJField;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaNames;
import com.palladio_simulator.protocom.tech.rmi.PojoComposedStructureClass;
import java.util.Collection;
import java.util.Collections;

/**
 * Provider for CompositeComponents.
 * 
 * In contrast to other ComposedStructures, the encapsulated components are created by this one.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class PojoCompositeComponentClass /* extends /* PojoComposedStructureClass<CompositeComponent> */  */{
  public PojoCompositeComponentClass(final /* CompositeComponent */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<String> interfaces() {
    String _interfaceName = JavaNames.interfaceName(this.pcmEntity);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_interfaceName));
  }
  
  public Collection<? extends IJMethod> constructors() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoCompositeComponentClass"
      + "\nThe method id is undefined for the type PojoCompositeComponentClass"
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoCompositeComponentClass"
      + "\nThe method providedInterface__OperationProvidedRole is undefined for the type PojoCompositeComponentClass"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nassemblyContexts__ComposedStructure cannot be resolved"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nassemblyContext_ProvidedDelegationConnector cannot be resolved");
  }
  
  public Collection<? extends IJField> fields() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoCompositeComponentClass"
      + "\nassemblyContexts__ComposedStructure cannot be resolved"
      + "\nmap cannot be resolved");
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nassemblyContexts__ComposedStructure cannot be resolved");
  }
}
