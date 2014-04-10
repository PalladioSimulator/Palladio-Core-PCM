package org.palladiosimulator.protocom.tech.rmi.resourceenvironment;

import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.palladiosimulator.protocom.lang.java.IJClass;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.tech.ConceptMapping;

/**
 * Creates a configuration file for the ResourceEnvironment.
 * 
 * FIXME: ResourceEnvironment is not an Entity. Therefore we cannot reuse PojoClass at this moment...
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class PojoResourceEnvironment extends ConceptMapping<ResourceEnvironment> implements IJClass {
  public PojoResourceEnvironment(final ResourceEnvironment pcmEntity) {
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
    JMethod _jMethod = new JMethod();
    JMethod _withName = _jMethod.withName("setUpResources");
    JMethod _withParameters = _withName.withParameters("String cpuStrategy, String hddStrategy, String calibrationPath, org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum accuracy");
    JMethod _withStaticModifier = _withParameters.withStaticModifier();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("String idContainer = org.palladiosimulator.protocom.framework.AbstractAllocationStorage.getActiveContainer();");
    _builder.newLine();
    {
      EList<ResourceContainer> _resourceContainer_ResourceEnvironment = this.pcmEntity.getResourceContainer_ResourceEnvironment();
      boolean _hasElements = false;
      for(final ResourceContainer container : _resourceContainer_ResourceEnvironment) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(" else", "");
        }
        _builder.append("// Active resources of container ");
        String _entityName = container.getEntityName();
        _builder.append(_entityName, "");
        _builder.newLineIfNotEmpty();
        _builder.append("if (idContainer.equals(\"");
        String _id = container.getId();
        _builder.append(_id, "");
        _builder.append("\")) {");
        _builder.newLineIfNotEmpty();
        {
          EList<ProcessingResourceSpecification> _activeResourceSpecifications_ResourceContainer = container.getActiveResourceSpecifications_ResourceContainer();
          for(final ProcessingResourceSpecification processingResource : _activeResourceSpecifications_ResourceContainer) {
            {
              ProcessingResourceType _activeResourceType_ActiveResourceSpecification = processingResource.getActiveResourceType_ActiveResourceSpecification();
              String _entityName_1 = _activeResourceType_ActiveResourceSpecification.getEntityName();
              String _lowerCase = _entityName_1.toLowerCase();
              boolean _contains = _lowerCase.contains("cpu");
              if (_contains) {
                _builder.append("\t");
                _builder.append("setUpCPU(cpuStrategy, calibrationPath, accuracy, \"");
                PCMRandomVariable _processingRate_ProcessingResourceSpecification = processingResource.getProcessingRate_ProcessingResourceSpecification();
                String _specification = _processingRate_ProcessingResourceSpecification.getSpecification();
                _builder.append(_specification, "\t");
                _builder.append("\");\t");
                _builder.newLineIfNotEmpty();
              } else {
                ProcessingResourceType _activeResourceType_ActiveResourceSpecification_1 = processingResource.getActiveResourceType_ActiveResourceSpecification();
                String _entityName_2 = _activeResourceType_ActiveResourceSpecification_1.getEntityName();
                String _lowerCase_1 = _entityName_2.toLowerCase();
                boolean _contains_1 = _lowerCase_1.contains("hdd");
                if (_contains_1) {
                  _builder.append("\t");
                  _builder.append("setUpHDD(hddStrategy, calibrationPath, accuracy, \"");
                  PCMRandomVariable _processingRate_ProcessingResourceSpecification_1 = processingResource.getProcessingRate_ProcessingResourceSpecification();
                  String _specification_1 = _processingRate_ProcessingResourceSpecification_1.getSpecification();
                  _builder.append(_specification_1, "\t");
                  _builder.append("\");\t");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    JMethod _withImplementation = _withStaticModifier.withImplementation(_builder.toString());
    return Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation));
  }
  
  public String filePath() {
    return "ProtoComBootstrap/ResourceEnvironment.java";
  }
  
  public Collection<? extends IJMethod> constructors() {
    return CollectionLiterals.<IJMethod>newLinkedList();
  }
  
  public Collection<String> interfaces() {
    return CollectionLiterals.<String>newLinkedList();
  }
  
  public Collection<? extends IJField> fields() {
    return CollectionLiterals.<IJField>newLinkedList();
  }
}
