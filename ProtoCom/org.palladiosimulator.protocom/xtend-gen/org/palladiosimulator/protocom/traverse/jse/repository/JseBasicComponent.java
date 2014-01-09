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
import org.palladiosimulator.protocom.tech.rmi.PojoBasicComponentClass;
import org.palladiosimulator.protocom.tech.rmi.PojoBasicComponentContextClass;
import org.palladiosimulator.protocom.tech.rmi.PojoBasicComponentContextInterface;
import org.palladiosimulator.protocom.tech.rmi.PojoBasicComponentPortClass;
import org.palladiosimulator.protocom.tech.rmi.PojoComponentClassInterface;
import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent;

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
    JInterface _instance = this.injector.<JInterface>getInstance(JInterface.class);
    PojoComponentClassInterface _pojoComponentClassInterface = new PojoComponentClassInterface(this.entity);
    GeneratedFile<IJInterface> _createFor = _instance.createFor(_pojoComponentClassInterface);
    this.generatedFiles.add(_createFor);
    JClass _instance_1 = this.injector.<JClass>getInstance(JClass.class);
    PojoBasicComponentClass _pojoBasicComponentClass = new PojoBasicComponentClass(this.entity);
    GeneratedFile<IJClass> _createFor_1 = _instance_1.createFor(_pojoBasicComponentClass);
    this.generatedFiles.add(_createFor_1);
    JClass _instance_2 = this.injector.<JClass>getInstance(JClass.class);
    PojoBasicComponentContextClass _pojoBasicComponentContextClass = new PojoBasicComponentContextClass(this.entity);
    GeneratedFile<IJClass> _createFor_2 = _instance_2.createFor(_pojoBasicComponentContextClass);
    this.generatedFiles.add(_createFor_2);
    JInterface _instance_3 = this.injector.<JInterface>getInstance(JInterface.class);
    PojoBasicComponentContextInterface _pojoBasicComponentContextInterface = new PojoBasicComponentContextInterface(this.entity);
    GeneratedFile<IJInterface> _createFor_3 = _instance_3.createFor(_pojoBasicComponentContextInterface);
    this.generatedFiles.add(_createFor_3);
    EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity = this.entity.getProvidedRoles_InterfaceProvidingEntity();
    final Procedure1<ProvidedRole> _function = new Procedure1<ProvidedRole>() {
      public void apply(final ProvidedRole it) {
        JClass _instance = JseBasicComponent.this.injector.<JClass>getInstance(JClass.class);
        PojoBasicComponentPortClass _pojoBasicComponentPortClass = new PojoBasicComponentPortClass(it);
        GeneratedFile<IJClass> _createFor = _instance.createFor(_pojoBasicComponentPortClass);
        JseBasicComponent.this.generatedFiles.add(_createFor);
      }
    };
    IterableExtensions.<ProvidedRole>forEach(_providedRoles_InterfaceProvidingEntity, _function);
  }
}
