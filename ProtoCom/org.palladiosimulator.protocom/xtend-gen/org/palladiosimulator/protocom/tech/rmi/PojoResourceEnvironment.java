package org.palladiosimulator.protocom.tech.rmi;

import java.util.Collection;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.palladiosimulator.protocom.lang.java.IJClass;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.tech.ConceptMapping;

/**
 * Creates a configuration file for the ResourceEnvironment.
 * 
 * FIXME: ResourceEnvironment is not an Entity. Therefore we cannot reuse PojoClass at this moment...
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class PojoResourceEnvironment /* extends /* ConceptMapping<ResourceEnvironment> */  */implements IJClass {
  public PojoResourceEnvironment(final /* ResourceEnvironment */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    return "org.palladiosimulator.protocom.framework.AbstractResourceEnvironment";
  }
  
  public String packageName() {
    return "ProtoComBootstrap";
  }
  
  public String compilationUnitName() {
    return "ResourceEnvironment";
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method entityName is undefined for the type PojoResourceEnvironment"
      + "\nThe method id is undefined for the type PojoResourceEnvironment"
      + "\nThe method activeResourceSpecifications_ResourceContainer is undefined for the type PojoResourceEnvironment"
      + "\nThe method activeResourceType_ActiveResourceSpecification is undefined for the type PojoResourceEnvironment"
      + "\nThe method processingRate_ProcessingResourceSpecification is undefined for the type PojoResourceEnvironment"
      + "\nThe method activeResourceType_ActiveResourceSpecification is undefined for the type PojoResourceEnvironment"
      + "\nThe method processingRate_ProcessingResourceSpecification is undefined for the type PojoResourceEnvironment"
      + "\nresourceContainer_ResourceEnvironment cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\ntoLowerCase cannot be resolved"
      + "\ncontains cannot be resolved"
      + "\nspecification cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\ntoLowerCase cannot be resolved"
      + "\ncontains cannot be resolved"
      + "\nspecification cannot be resolved");
  }
  
  public String filePath() {
    return "ProtoComBootstrap/ResourceEnvironment.java";
  }
  
  public Collection<? extends IJMethod> constructors() {
    LinkedList<IJMethod> _newLinkedList = CollectionLiterals.<IJMethod>newLinkedList();
    return _newLinkedList;
  }
  
  public Collection<String> interfaces() {
    LinkedList<String> _newLinkedList = CollectionLiterals.<String>newLinkedList();
    return _newLinkedList;
  }
  
  public Collection<? extends IJField> fields() {
    LinkedList<IJField> _newLinkedList = CollectionLiterals.<IJField>newLinkedList();
    return _newLinkedList;
  }
}
