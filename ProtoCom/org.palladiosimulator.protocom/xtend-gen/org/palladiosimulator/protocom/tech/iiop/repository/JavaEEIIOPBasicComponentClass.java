package org.palladiosimulator.protocom.tech.iiop.repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JField;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmCommons;
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPClass;
import org.palladiosimulator.protocom.tech.iiop.util.PcmIIOPProtoAction;

@SuppressWarnings("all")
public class JavaEEIIOPBasicComponentClass extends JavaEEIIOPClass<BasicComponent> {
  public JavaEEIIOPBasicComponentClass(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<String> interfaces() {
    String _interfaceName = JavaNames.interfaceName(this.pcmEntity);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_interfaceName));
  }
  
  public Collection<? extends IJMethod> constructors() {
    JMethod _jMethod = new JMethod();
    JMethod _jMethod_1 = new JMethod();
    JMethod _withParameters = _jMethod_1.withParameters("String assemblyContextID");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.assemblyContextID = assemblyContextID;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<PassiveResource> _passiveResource_BasicComponent = this.pcmEntity.getPassiveResource_BasicComponent();
      for(final PassiveResource resource : _passiveResource_BasicComponent) {
        _builder.append("passive_resource_");
        String _entityName = resource.getEntityName();
        String _javaVariableName = JavaNames.javaVariableName(_entityName);
        _builder.append(_javaVariableName, "");
        _builder.append(" = new java.util.concurrent.Semaphore(de.uka.ipd.sdq.simucomframework.variables.StackContext.evaluateStatic(\"");
        PCMRandomVariable _capacity_PassiveResource = resource.getCapacity_PassiveResource();
        String _specification = _capacity_PassiveResource.getSpecification();
        String _specificationString = JavaNames.specificationString(_specification);
        _builder.append(_specificationString, "");
        _builder.append("\", Integer.class), true);");
        _builder.newLineIfNotEmpty();
      }
    }
    JMethod _withImplementation = _withParameters.withImplementation(_builder.toString());
    return Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_jMethod, _withImplementation));
  }
  
  public Collection<? extends IJField> fields() {
    LinkedList<JField> _xblockexpression = null;
    {
      final LinkedList<JField> results = CollectionLiterals.<JField>newLinkedList();
      JField _jField = new JField();
      JField _withName = _jField.withName("myComponentStackFrame");
      String _stackframeType = PcmCommons.stackframeType();
      JField _withType = _withName.withType(_stackframeType);
      JField _jField_1 = new JField();
      JField _withName_1 = _jField_1.withName("myDefaultComponentStackFrame");
      String _stackframeType_1 = PcmCommons.stackframeType();
      JField _withType_1 = _withName_1.withType(_stackframeType_1);
      Iterables.<JField>addAll(results, Collections.<JField>unmodifiableList(Lists.<JField>newArrayList(_withType, _withType_1)));
      JField _jField_2 = new JField();
      JField _withName_2 = _jField_2.withName("assemblyContextID");
      JField _withType_2 = _withName_2.withType("String");
      Iterables.<JField>addAll(results, Collections.<JField>unmodifiableList(Lists.<JField>newArrayList(_withType_2)));
      EList<PassiveResource> _passiveResource_BasicComponent = this.pcmEntity.getPassiveResource_BasicComponent();
      final Function1<PassiveResource,JField> _function = new Function1<PassiveResource,JField>() {
        public JField apply(final PassiveResource it) {
          JField _jField = new JField();
          String _entityName = it.getEntityName();
          String _javaVariableName = JavaNames.javaVariableName(_entityName);
          String _plus = ("passive_resource_" + _javaVariableName);
          JField _withName = _jField.withName(_plus);
          return _withName.withType("java.util.concurrent.Semaphore");
        }
      };
      List<JField> _map = ListExtensions.<PassiveResource, JField>map(_passiveResource_BasicComponent, _function);
      Iterables.<JField>addAll(results, _map);
      _xblockexpression = results;
    }
    return _xblockexpression;
  }
  
  public Collection<? extends IJMethod> methods() {
    LinkedList<JMethod> _xblockexpression = null;
    {
      final LinkedList<JMethod> results = CollectionLiterals.<JMethod>newLinkedList();
      JMethod _jMethod = new JMethod();
      JMethod _withName = _jMethod.withName("setComponentFrame");
      String _stackframeParameterList = PcmCommons.stackframeParameterList();
      JMethod _withParameters = _withName.withParameters(_stackframeParameterList);
      JMethod _withImplementation = _withParameters.withImplementation("this.myComponentStackFrame = myComponentStackFrame; this.myDefaultComponentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();");
      Iterables.<JMethod>addAll(results, Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation)));
      EList<ServiceEffectSpecification> _serviceEffectSpecifications__BasicComponent = this.pcmEntity.getServiceEffectSpecifications__BasicComponent();
      final Function1<ServiceEffectSpecification,JMethod> _function = new Function1<ServiceEffectSpecification,JMethod>() {
        public JMethod apply(final ServiceEffectSpecification it) {
          JMethod _jMethod = new JMethod();
          Signature _describedService__SEFF = it.getDescribedService__SEFF();
          String _serviceName = JavaNames.serviceName(_describedService__SEFF);
          JMethod _withName = _jMethod.withName(_serviceName);
          String _stackframeType = PcmCommons.stackframeType();
          JMethod _withReturnType = _withName.withReturnType(_stackframeType);
          String _stackContextParameterList = PcmCommons.stackContextParameterList();
          JMethod _withParameters = _withReturnType.withParameters(_stackContextParameterList);
          StringConcatenation _builder = new StringConcatenation();
          PcmIIOPProtoAction _pcmIIOPProtoAction = new PcmIIOPProtoAction();
          EList<AbstractAction> _steps_Behaviour = ((ResourceDemandingBehaviour) it).getSteps_Behaviour();
          AbstractAction _get = _steps_Behaviour.get(0);
          String _actions = _pcmIIOPProtoAction.actions(_get);
          _builder.append(_actions, "");
          _builder.newLineIfNotEmpty();
          _builder.append("return null;");
          _builder.newLine();
          return _withParameters.withImplementation(_builder.toString());
        }
      };
      List<JMethod> _map = ListExtensions.<ServiceEffectSpecification, JMethod>map(_serviceEffectSpecifications__BasicComponent, _function);
      Iterables.<JMethod>addAll(results, _map);
      _xblockexpression = results;
    }
    return _xblockexpression;
  }
  
  public Collection<? extends IJField> jeeClassDependencyInjection() {
    LinkedList<JField> _xblockexpression = null;
    {
      final LinkedList<JField> results = CollectionLiterals.<JField>newLinkedList();
      EList<RequiredRole> _requiredRoles_InterfaceRequiringEntity = this.pcmEntity.getRequiredRoles_InterfaceRequiringEntity();
      final Function1<RequiredRole,Boolean> _function = new Function1<RequiredRole,Boolean>() {
        public Boolean apply(final RequiredRole it) {
          return Boolean.valueOf(OperationRequiredRole.class.isInstance(it));
        }
      };
      Iterable<RequiredRole> _filter = IterableExtensions.<RequiredRole>filter(_requiredRoles_InterfaceRequiringEntity, _function);
      final Function1<RequiredRole,OperationRequiredRole> _function_1 = new Function1<RequiredRole,OperationRequiredRole>() {
        public OperationRequiredRole apply(final RequiredRole it) {
          return ((OperationRequiredRole) it);
        }
      };
      Iterable<OperationRequiredRole> _map = IterableExtensions.<RequiredRole, OperationRequiredRole>map(_filter, _function_1);
      for (final OperationRequiredRole required : _map) {
        JField _jField = new JField();
        String _javaName = JavaNames.javaName(required);
        String _firstLower = StringExtensions.toFirstLower(_javaName);
        JField _withName = _jField.withName(_firstLower);
        OperationInterface _requiredInterface__OperationRequiredRole = required.getRequiredInterface__OperationRequiredRole();
        String _javaName_1 = JavaNames.javaName(_requiredInterface__OperationRequiredRole);
        JField _withType = _withName.withType(_javaName_1);
        Iterables.<JField>addAll(results, Collections.<JField>unmodifiableList(Lists.<JField>newArrayList(_withType)));
      }
      _xblockexpression = results;
    }
    return _xblockexpression;
  }
}
