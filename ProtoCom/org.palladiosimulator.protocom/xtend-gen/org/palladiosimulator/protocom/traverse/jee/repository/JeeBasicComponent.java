package org.palladiosimulator.protocom.traverse.jee.repository;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.java.IJeeClass;
import org.palladiosimulator.protocom.lang.java.IJeeInterface;
import org.palladiosimulator.protocom.lang.java.impl.JeeClass;
import org.palladiosimulator.protocom.lang.java.impl.JeeInterface;
import org.palladiosimulator.protocom.lang.manifest.IJeeManifest;
import org.palladiosimulator.protocom.lang.manifest.impl.JeeManifest;
import org.palladiosimulator.protocom.lang.prefs.IJeePreferences;
import org.palladiosimulator.protocom.lang.prefs.impl.JeePreferences;
import org.palladiosimulator.protocom.lang.xml.IClasspath;
import org.palladiosimulator.protocom.lang.xml.IJeeComponentFile;
import org.palladiosimulator.protocom.lang.xml.IJeeEjbDescriptor;
import org.palladiosimulator.protocom.lang.xml.IJeeFacetCoreXml;
import org.palladiosimulator.protocom.lang.xml.IJeeGlassfishEjbDescriptor;
import org.palladiosimulator.protocom.lang.xml.impl.Classpath;
import org.palladiosimulator.protocom.lang.xml.impl.JeeComponentFile;
import org.palladiosimulator.protocom.lang.xml.impl.JeeEjbDescriptor;
import org.palladiosimulator.protocom.lang.xml.impl.JeeFacetCore;
import org.palladiosimulator.protocom.lang.xml.impl.JeeGlassfishEjbDescriptor;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPBasicComponentClass;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPBasicComponentPortClass;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPClasspath;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPClientClasspath;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPClientFacetCore;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPClientManifest;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPClientPreferences;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPComponentClassInterface;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPEclipseClientComponentFile;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPEclipseComponentFile;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPEjbDescriptor;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPFacetCore;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPGlassfishEjbDescriptor;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPManifest;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPOperationInterface;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPPreferences;
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
    JavaEEIIOPGlassfishEjbDescriptor _javaEEIIOPGlassfishEjbDescriptor = new JavaEEIIOPGlassfishEjbDescriptor(this.entity);
    GeneratedFile<IJeeGlassfishEjbDescriptor> _createFor_2 = _instance_2.createFor(_javaEEIIOPGlassfishEjbDescriptor);
    this.generatedFiles.add(_createFor_2);
    JeeEjbDescriptor _instance_3 = this.injector.<JeeEjbDescriptor>getInstance(JeeEjbDescriptor.class);
    JavaEEIIOPEjbDescriptor _javaEEIIOPEjbDescriptor = new JavaEEIIOPEjbDescriptor(this.entity);
    GeneratedFile<IJeeEjbDescriptor> _createFor_3 = _instance_3.createFor(_javaEEIIOPEjbDescriptor);
    this.generatedFiles.add(_createFor_3);
    EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity_1 = this.entity.getProvidedRoles_InterfaceProvidingEntity();
    final Procedure1<ProvidedRole> _function_1 = new Procedure1<ProvidedRole>() {
      public void apply(final ProvidedRole it) {
        JeeInterface _instance = JeeBasicComponent.this.injector.<JeeInterface>getInstance(JeeInterface.class);
        JavaEEIIOPOperationInterface _javaEEIIOPOperationInterface = new JavaEEIIOPOperationInterface(it);
        GeneratedFile<IJeeInterface> _createFor = _instance.createFor(_javaEEIIOPOperationInterface);
        JeeBasicComponent.this.generatedFiles.add(_createFor);
      }
    };
    IterableExtensions.<ProvidedRole>forEach(_providedRoles_InterfaceProvidingEntity_1, _function_1);
    JeeManifest _instance_4 = this.injector.<JeeManifest>getInstance(JeeManifest.class);
    JavaEEIIOPManifest _javaEEIIOPManifest = new JavaEEIIOPManifest(this.entity);
    GeneratedFile<IJeeManifest> _createFor_4 = _instance_4.createFor(_javaEEIIOPManifest);
    this.generatedFiles.add(_createFor_4);
    JeeManifest _instance_5 = this.injector.<JeeManifest>getInstance(JeeManifest.class);
    JavaEEIIOPClientManifest _javaEEIIOPClientManifest = new JavaEEIIOPClientManifest(this.entity);
    GeneratedFile<IJeeManifest> _createFor_5 = _instance_5.createFor(_javaEEIIOPClientManifest);
    this.generatedFiles.add(_createFor_5);
    JeePreferences _instance_6 = this.injector.<JeePreferences>getInstance(JeePreferences.class);
    JavaEEIIOPPreferences _javaEEIIOPPreferences = new JavaEEIIOPPreferences(this.entity);
    GeneratedFile<IJeePreferences> _createFor_6 = _instance_6.createFor(_javaEEIIOPPreferences);
    this.generatedFiles.add(_createFor_6);
    JeePreferences _instance_7 = this.injector.<JeePreferences>getInstance(JeePreferences.class);
    JavaEEIIOPClientPreferences _javaEEIIOPClientPreferences = new JavaEEIIOPClientPreferences(this.entity);
    GeneratedFile<IJeePreferences> _createFor_7 = _instance_7.createFor(_javaEEIIOPClientPreferences);
    this.generatedFiles.add(_createFor_7);
    JeeComponentFile _instance_8 = this.injector.<JeeComponentFile>getInstance(JeeComponentFile.class);
    JavaEEIIOPEclipseComponentFile _javaEEIIOPEclipseComponentFile = new JavaEEIIOPEclipseComponentFile(this.entity);
    GeneratedFile<IJeeComponentFile> _createFor_8 = _instance_8.createFor(_javaEEIIOPEclipseComponentFile);
    this.generatedFiles.add(_createFor_8);
    JeeComponentFile _instance_9 = this.injector.<JeeComponentFile>getInstance(JeeComponentFile.class);
    JavaEEIIOPEclipseClientComponentFile _javaEEIIOPEclipseClientComponentFile = new JavaEEIIOPEclipseClientComponentFile(this.entity);
    GeneratedFile<IJeeComponentFile> _createFor_9 = _instance_9.createFor(_javaEEIIOPEclipseClientComponentFile);
    this.generatedFiles.add(_createFor_9);
    JeeFacetCore _instance_10 = this.injector.<JeeFacetCore>getInstance(JeeFacetCore.class);
    JavaEEIIOPFacetCore _javaEEIIOPFacetCore = new JavaEEIIOPFacetCore(this.entity);
    GeneratedFile<IJeeFacetCoreXml> _createFor_10 = _instance_10.createFor(_javaEEIIOPFacetCore);
    this.generatedFiles.add(_createFor_10);
    JeeFacetCore _instance_11 = this.injector.<JeeFacetCore>getInstance(JeeFacetCore.class);
    JavaEEIIOPClientFacetCore _javaEEIIOPClientFacetCore = new JavaEEIIOPClientFacetCore(this.entity);
    GeneratedFile<IJeeFacetCoreXml> _createFor_11 = _instance_11.createFor(_javaEEIIOPClientFacetCore);
    this.generatedFiles.add(_createFor_11);
    Classpath _instance_12 = this.injector.<Classpath>getInstance(Classpath.class);
    JavaEEIIOPClasspath _javaEEIIOPClasspath = new JavaEEIIOPClasspath(this.entity);
    GeneratedFile<IClasspath> _createFor_12 = _instance_12.createFor(_javaEEIIOPClasspath);
    this.generatedFiles.add(_createFor_12);
    Classpath _instance_13 = this.injector.<Classpath>getInstance(Classpath.class);
    JavaEEIIOPClientClasspath _javaEEIIOPClientClasspath = new JavaEEIIOPClientClasspath(this.entity);
    GeneratedFile<IClasspath> _createFor_13 = _instance_13.createFor(_javaEEIIOPClientClasspath);
    this.generatedFiles.add(_createFor_13);
  }
}
