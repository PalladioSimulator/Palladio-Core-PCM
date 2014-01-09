package org.palladiosimulator.protocom.tech.rmi;

import java.util.Collection;
import org.palladiosimulator.protocom.lang.java.IJClass;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.tech.rmi.PojoClass;

/**
 * Common provider for System and CompositeComponent elements.
 * 
 * The most important difference between a System and a CompositeComponent is that the
 * BasicComponents of a CompositeComponent are always deployed on the same ResourceEnvironment
 * and therefore can be initialized by the enclosing child component.
 * 
 * This does NOT hold for Systems, as these use the RMI registry to assembly their enclosed
 * child components.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public abstract class PojoComposedStructureClass<E/*  extends ComposedProvidingRequiringEntity */> extends PojoClass<E> implements IJClass {
  public PojoComposedStructureClass(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<? extends IJField> fields() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nThe method providedRoles_InterfaceProvidingEntity is undefined for the type PojoComposedStructureClass"
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoComposedStructureClass"
      + "\nThe method providedInterface__OperationProvidedRole is undefined for the type PojoComposedStructureClass"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nmap cannot be resolved");
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationRequiredRole cannot be resolved to a type."
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nThe method assemblyContexts__ComposedStructure is undefined for the type PojoComposedStructureClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoComposedStructureClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoComposedStructureClass"
      + "\nThe method encapsulatedComponent__AssemblyContext is undefined for the type PojoComposedStructureClass"
      + "\nThe method or field OperationRequiredRole is undefined for the type PojoComposedStructureClass"
      + "\nThe method providedRoles_InterfaceProvidingEntity is undefined for the type PojoComposedStructureClass"
      + "\nThe method or field OperationProvidedRole is undefined for the type PojoComposedStructureClass"
      + "\nThe method providedInterface__OperationProvidedRole is undefined for the type PojoComposedStructureClass"
      + "\nType mismatch: cannot convert from Object to OperationProvidedRole"
      + "\nmap cannot be resolved"
      + "\nrequiredRoles_InterfaceRequiringEntity cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nmap cannot be resolved");
  }
}
