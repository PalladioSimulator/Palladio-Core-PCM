package org.palladiosimulator.protocom.traverse.jse.system;

import org.palladiosimulator.protocom.traverse.framework.system.XSystem;

/**
 * An System translates into the following Java compilation units:
 * <ul>
 * 	<li> a class used to setup the assembly (a System is a Composed Structure),
 * 	<li> an interface for this component's class,
 * 	<li> a context class for assembly (basically unused, can be removed?),
 * 	<li> an interface for the context class,
 *  <li> a class for each component's port, used by the Usage Scenario. TODO: Move to traverse
 * </ul>
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class JseSystem extends XSystem {
  public void generate() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method providedRoles_InterfaceProvidingEntity is undefined for the type JseSystem"
      + "\nforEach cannot be resolved");
  }
}
