package org.palladiosimulator.protocom.traverse.jee.repository;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.java.IJeeClass;
import org.palladiosimulator.protocom.lang.java.IJeeEjbDescriptor;
import org.palladiosimulator.protocom.lang.java.IJeeGlassfishEjbDescriptor;
import org.palladiosimulator.protocom.lang.java.IJeeInterface;
import org.palladiosimulator.protocom.lang.java.impl.JeeClass;
import org.palladiosimulator.protocom.lang.java.impl.JeeEjbDescriptor;
import org.palladiosimulator.protocom.lang.java.impl.JeeGlassfishEjbDescriptor;
import org.palladiosimulator.protocom.lang.java.impl.JeeInterface;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPBasicComponentClass;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPBasicComponentPortClass;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPComponentClassInterface;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPEjbDescriptor;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPGlassfishEjbDescriptor;
import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent;

@SuppressWarnings("all")
public class JeeBasicComponent extends XBasicComponent {
  public void generate() {
    JeeInterface _instance = this.injector.<JeeInterface>getInstance(JeeInterface.class);
    JavaEEIIOPComponentClassInterface _javaEEIIOPComponentClassInterface = new JavaEEIIOPComponentClassInterface(this.entity);
    GeneratedFile<IJeeInterface> _createFor = _instance.createFor(_javaEEIIOPComponentClassInterface);
    this.generatedFiles.add(_createFor);
    JeeClass _instance_1 = this.injector.<JeeClass>getInstance(JeeClass.class);
    JavaEEIIOPBasicComponentClass _javaEEIIOPBasicComponentClass = new JavaEEIIOPBasicComponentClass(this.entity);
    GeneratedFile<IJeeClass> _createFor_1 = _instance_1.createFor(_javaEEIIOPBasicComponentClass);
    this.generatedFiles.add(_createFor_1);
    EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity = this.entity.getProvidedRoles_InterfaceProvidingEntity();
    final Procedure1<ProvidedRole> _function = new Procedure1<ProvidedRole>() {
      public void apply(final ProvidedRole it) {
        JeeClass _instance = JeeBasicComponent.this.injector.<JeeClass>getInstance(JeeClass.class);
        JavaEEIIOPBasicComponentPortClass _javaEEIIOPBasicComponentPortClass = new JavaEEIIOPBasicComponentPortClass(it);
        GeneratedFile<IJeeClass> _createFor = _instance.createFor(_javaEEIIOPBasicComponentPortClass);
        JeeBasicComponent.this.generatedFiles.add(_createFor);
      }
    };
    IterableExtensions.<ProvidedRole>forEach(_providedRoles_InterfaceProvidingEntity, _function);
    JeeGlassfishEjbDescriptor _instance_2 = this.injector.<JeeGlassfishEjbDescriptor>getInstance(JeeGlassfishEjbDescriptor.class);
    JavaEEIIOPGlassfishEjbDescriptor<BasicComponent> _javaEEIIOPGlassfishEjbDescriptor = new JavaEEIIOPGlassfishEjbDescriptor<BasicComponent>(this.entity);
    GeneratedFile<IJeeGlassfishEjbDescriptor> _createFor_2 = _instance_2.createFor(_javaEEIIOPGlassfishEjbDescriptor);
    this.generatedFiles.add(_createFor_2);
    JeeEjbDescriptor _instance_3 = this.injector.<JeeEjbDescriptor>getInstance(JeeEjbDescriptor.class);
    JavaEEIIOPEjbDescriptor<BasicComponent> _javaEEIIOPEjbDescriptor = new JavaEEIIOPEjbDescriptor<BasicComponent>(this.entity);
    GeneratedFile<IJeeEjbDescriptor> _createFor_3 = _instance_3.createFor(_javaEEIIOPEjbDescriptor);
    this.generatedFiles.add(_createFor_3);
  }
}
