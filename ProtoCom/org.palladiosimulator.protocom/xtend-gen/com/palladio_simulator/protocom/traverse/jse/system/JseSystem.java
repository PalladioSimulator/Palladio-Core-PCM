package com.palladio_simulator.protocom.traverse.jse.system;

import com.palladio_simulator.protocom.lang.GeneratedFile;
import com.palladio_simulator.protocom.lang.java.IJClass;
import com.palladio_simulator.protocom.lang.java.IJInterface;
import com.palladio_simulator.protocom.lang.java.impl.JClass;
import com.palladio_simulator.protocom.lang.java.impl.JInterface;
import com.palladio_simulator.protocom.tech.rmi.PojoComposedStructureContextClass;
import com.palladio_simulator.protocom.tech.rmi.PojoComposedStructureContextInterface;
import com.palladio_simulator.protocom.tech.rmi.PojoComposedStructureInterface;
import com.palladio_simulator.protocom.tech.rmi.PojoComposedStructurePortClass;
import com.palladio_simulator.protocom.tech.rmi.PojoSystemClass;
import com.palladio_simulator.protocom.traverse.framework.system.XSystem;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
    JInterface _instance = this.injector.<JInterface>getInstance(JInterface.class);
    PojoComposedStructureInterface _pojoComposedStructureInterface = new PojoComposedStructureInterface(this.entity);
    GeneratedFile<IJInterface> _createFor = _instance.createFor(_pojoComposedStructureInterface);
    this.generatedFiles.add(_createFor);
    JClass _instance_1 = this.injector.<JClass>getInstance(JClass.class);
    PojoSystemClass _pojoSystemClass = new PojoSystemClass(this.entity);
    GeneratedFile<IJClass> _createFor_1 = _instance_1.createFor(_pojoSystemClass);
    this.generatedFiles.add(_createFor_1);
    JClass _instance_2 = this.injector.<JClass>getInstance(JClass.class);
    PojoComposedStructureContextClass _pojoComposedStructureContextClass = new PojoComposedStructureContextClass(this.entity);
    GeneratedFile<IJClass> _createFor_2 = _instance_2.createFor(_pojoComposedStructureContextClass);
    this.generatedFiles.add(_createFor_2);
    JInterface _instance_3 = this.injector.<JInterface>getInstance(JInterface.class);
    PojoComposedStructureContextInterface _pojoComposedStructureContextInterface = new PojoComposedStructureContextInterface(this.entity);
    GeneratedFile<IJInterface> _createFor_3 = _instance_3.createFor(_pojoComposedStructureContextInterface);
    this.generatedFiles.add(_createFor_3);
    EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity = this.entity.getProvidedRoles_InterfaceProvidingEntity();
    final Procedure1<ProvidedRole> _function = new Procedure1<ProvidedRole>() {
      public void apply(final ProvidedRole it) {
        JClass _instance = JseSystem.this.injector.<JClass>getInstance(JClass.class);
        PojoComposedStructurePortClass _pojoComposedStructurePortClass = new PojoComposedStructurePortClass(it);
        GeneratedFile<IJClass> _createFor = _instance.createFor(_pojoComposedStructurePortClass);
        JseSystem.this.generatedFiles.add(_createFor);
      }
    };
    IterableExtensions.<ProvidedRole>forEach(_providedRoles_InterfaceProvidingEntity, _function);
  }
}
