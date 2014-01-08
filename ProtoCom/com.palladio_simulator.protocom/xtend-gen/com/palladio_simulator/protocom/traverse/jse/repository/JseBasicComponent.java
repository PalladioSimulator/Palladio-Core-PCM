package com.palladio_simulator.protocom.traverse.jse.repository;

import com.palladio_simulator.protocom.traverse.framework.repository.XBasicComponent;

/**
 * A Basic Component translates into the following Java compilation units:
 * <ul>
 * 	<li> a class implementing the component's resource demands,
 * 	<li> an interface for the component class,
 * 	<li> a context class for assembly,
 * 	<li> an interface for the context class,
 *  <li> a class for each component's port.
 * </ul>
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class JseBasicComponent extends XBasicComponent {
  public void generate() {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidedRoles_InterfaceProvidingEntity cannot be resolved"
      + "\nforEach cannot be resolved");
  }
}
