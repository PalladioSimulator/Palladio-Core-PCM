package org.palladiosimulator.protocom.traverse.jse.repository;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.java.IJClass;
import org.palladiosimulator.protocom.lang.java.IJInterface;
import org.palladiosimulator.protocom.lang.java.impl.JClass;
import org.palladiosimulator.protocom.lang.java.impl.JInterface;
import org.palladiosimulator.protocom.tech.rmi.PojoComposedStructureContextClass;
import org.palladiosimulator.protocom.tech.rmi.PojoComposedStructureContextInterface;
import org.palladiosimulator.protocom.tech.rmi.PojoComposedStructureInterface;
import org.palladiosimulator.protocom.tech.rmi.PojoComposedStructurePortClass;
import org.palladiosimulator.protocom.tech.rmi.PojoCompositeComponentClass;
import org.palladiosimulator.protocom.traverse.framework.repository.XCompositeComponent;

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
    JInterface _instance = this.injector.<JInterface>getInstance(JInterface.class);
    PojoComposedStructureInterface _pojoComposedStructureInterface = new PojoComposedStructureInterface(this.entity);
    GeneratedFile<IJInterface> _createFor = _instance.createFor(_pojoComposedStructureInterface);
    this.generatedFiles.add(_createFor);
    JClass _instance_1 = this.injector.<JClass>getInstance(JClass.class);
    PojoCompositeComponentClass _pojoCompositeComponentClass = new PojoCompositeComponentClass(this.entity);
    GeneratedFile<IJClass> _createFor_1 = _instance_1.createFor(_pojoCompositeComponentClass);
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
        JClass _instance = JseCompositeComponent.this.injector.<JClass>getInstance(JClass.class);
        PojoComposedStructurePortClass _pojoComposedStructurePortClass = new PojoComposedStructurePortClass(it);
        GeneratedFile<IJClass> _createFor = _instance.createFor(_pojoComposedStructurePortClass);
        JseCompositeComponent.this.generatedFiles.add(_createFor);
      }
    };
    IterableExtensions.<ProvidedRole>forEach(_providedRoles_InterfaceProvidingEntity, _function);
  }
}