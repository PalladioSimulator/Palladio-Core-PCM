package org.palladiosimulator.protocom.traverse.jse.system;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.java.IJClass;
import org.palladiosimulator.protocom.lang.java.IJInterface;
import org.palladiosimulator.protocom.lang.java.impl.JClass;
import org.palladiosimulator.protocom.lang.java.impl.JInterface;
import org.palladiosimulator.protocom.lang.manifest.IJseManifest;
import org.palladiosimulator.protocom.lang.manifest.impl.JseManifest;
import org.palladiosimulator.protocom.lang.properties.IBuildProperties;
import org.palladiosimulator.protocom.lang.properties.impl.BuildProperties;
import org.palladiosimulator.protocom.lang.xml.IPluginXml;
import org.palladiosimulator.protocom.lang.xml.impl.PluginXml;
import org.palladiosimulator.protocom.tech.rmi.repository.PojoComposedStructureContextClass;
import org.palladiosimulator.protocom.tech.rmi.repository.PojoComposedStructureContextInterface;
import org.palladiosimulator.protocom.tech.rmi.repository.PojoComposedStructureInterface;
import org.palladiosimulator.protocom.tech.rmi.repository.PojoComposedStructurePortClass;
import org.palladiosimulator.protocom.tech.rmi.system.PojoBuildProperties;
import org.palladiosimulator.protocom.tech.rmi.system.PojoManifest;
import org.palladiosimulator.protocom.tech.rmi.system.PojoPluginXml;
import org.palladiosimulator.protocom.tech.rmi.system.PojoSystemClass;
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
    JseManifest _instance_4 = this.injector.<JseManifest>getInstance(JseManifest.class);
    PojoManifest _pojoManifest = new PojoManifest(this.entity);
    GeneratedFile<IJseManifest> _createFor_4 = _instance_4.createFor(_pojoManifest);
    this.generatedFiles.add(_createFor_4);
    PluginXml _instance_5 = this.injector.<PluginXml>getInstance(PluginXml.class);
    PojoPluginXml _pojoPluginXml = new PojoPluginXml(this.entity);
    GeneratedFile<IPluginXml> _createFor_5 = _instance_5.createFor(_pojoPluginXml);
    this.generatedFiles.add(_createFor_5);
    BuildProperties _instance_6 = this.injector.<BuildProperties>getInstance(BuildProperties.class);
    PojoBuildProperties _pojoBuildProperties = new PojoBuildProperties(this.entity);
    GeneratedFile<IBuildProperties> _createFor_6 = _instance_6.createFor(_pojoBuildProperties);
    this.generatedFiles.add(_createFor_6);
  }
}
