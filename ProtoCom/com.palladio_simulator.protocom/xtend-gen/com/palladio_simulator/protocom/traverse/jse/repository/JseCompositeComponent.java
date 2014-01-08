package com.palladio_simulator.protocom.traverse.jse.repository;

import com.palladio_simulator.protocom.traverse.framework.repository.XCompositeComponent;

/**
 * An CompositeComponent translates into the following Java compilation units:
 * <ul>
 * 	<li> a class used to setup the assembly (a CompositeComponent is a ComposedStructure),
 * 	<li> an interface for this component's class,
 * 	<li> a context class for assembly,
 * 	<li> an interface for the context class,
 *  <li> a class for each component's port. TODO: Move to traverse
 * </ul>
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class JseCompositeComponent extends XCompositeComponent {
  public void generate() {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nforEach cannot be resolved");
  }
}
