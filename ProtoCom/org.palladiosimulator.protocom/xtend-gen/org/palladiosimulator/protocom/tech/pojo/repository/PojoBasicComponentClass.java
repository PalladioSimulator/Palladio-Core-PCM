package org.palladiosimulator.protocom.tech.pojo.repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
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
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JField;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.DataTypes;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.Parameters;
import org.palladiosimulator.protocom.lang.java.util.PcmCodeStubAction;
import org.palladiosimulator.protocom.tech.rmi.PojoClass;

/**
 * Defining the content of component implementations (classes implementing the component behavior).
 * 
 * @author Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PojoBasicComponentClass extends PojoClass<BasicComponent> {
  public PojoBasicComponentClass(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<String> interfaces() {
    String _interfaceName = JavaNames.interfaceName(this.pcmEntity);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_interfaceName));
  }
  
  public Collection<? extends IJMethod> constructors() {
    JMethod _jMethod = new JMethod();
    JMethod _withParameters = _jMethod.withParameters("String assemblyContextID");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.assemblyContextID = assemblyContextID;");
    _builder.newLine();
    {
      EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity = this.pcmEntity.getProvidedRoles_InterfaceProvidingEntity();
      final Function1<ProvidedRole,Boolean> _function = new Function1<ProvidedRole,Boolean>() {
        public Boolean apply(final ProvidedRole it) {
          boolean _isInstance = OperationProvidedRole.class.isInstance(it);
          return Boolean.valueOf(_isInstance);
        }
      };
      Iterable<ProvidedRole> _filter = IterableExtensions.<ProvidedRole>filter(_providedRoles_InterfaceProvidingEntity, _function);
      final Function1<ProvidedRole,OperationProvidedRole> _function_1 = new Function1<ProvidedRole,OperationProvidedRole>() {
        public OperationProvidedRole apply(final ProvidedRole it) {
          return ((OperationProvidedRole) it);
        }
      };
      Iterable<OperationProvidedRole> _map = IterableExtensions.<ProvidedRole, OperationProvidedRole>map(_filter, _function_1);
      boolean _hasElements = false;
      for(final OperationProvidedRole role : _map) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("try {", "");
        }
        String _portMemberVar = JavaNames.portMemberVar(role);
        _builder.append(_portMemberVar, "");
        _builder.append(" = new ");
        String _fqnPort = JavaNames.fqnPort(role);
        _builder.append(_fqnPort, "");
        _builder.append("(this, assemblyContextID);");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append("} catch (java.rmi.RemoteException e) {  }", "");
      }
    }
    _builder.newLine();
    {
      EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity_1 = this.pcmEntity.getProvidedRoles_InterfaceProvidingEntity();
      final Function1<ProvidedRole,Boolean> _function_2 = new Function1<ProvidedRole,Boolean>() {
        public Boolean apply(final ProvidedRole it) {
          boolean _isInstance = InfrastructureProvidedRole.class.isInstance(it);
          return Boolean.valueOf(_isInstance);
        }
      };
      Iterable<ProvidedRole> _filter_1 = IterableExtensions.<ProvidedRole>filter(_providedRoles_InterfaceProvidingEntity_1, _function_2);
      final Function1<ProvidedRole,InfrastructureProvidedRole> _function_3 = new Function1<ProvidedRole,InfrastructureProvidedRole>() {
        public InfrastructureProvidedRole apply(final ProvidedRole it) {
          return ((InfrastructureProvidedRole) it);
        }
      };
      Iterable<InfrastructureProvidedRole> _map_1 = IterableExtensions.<ProvidedRole, InfrastructureProvidedRole>map(_filter_1, _function_3);
      boolean _hasElements_1 = false;
      for(final InfrastructureProvidedRole role_1 : _map_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
          _builder.append("try {", "");
        }
        String _portMemberVar_1 = JavaNames.portMemberVar(role_1);
        _builder.append(_portMemberVar_1, "");
        _builder.append(" = new ");
        String _fqnPort_1 = JavaNames.fqnPort(role_1);
        _builder.append(_fqnPort_1, "");
        _builder.append("(this, assemblyContextID);");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements_1) {
        _builder.append("} catch (java.rmi.RemoteException e) {  }", "");
      }
    }
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
    return Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation));
  }
  
  public Collection<? extends IJField> fields() {
    LinkedList<JField> _xblockexpression = null;
    {
      final LinkedList<JField> results = CollectionLiterals.<JField>newLinkedList();
      JField _jField = new JField();
      JField _withName = _jField.withName("myContext");
      String _fqnContextInterface = JavaNames.fqnContextInterface(this.pcmEntity);
      JField _withType = _withName.withType(_fqnContextInterface);
      Iterables.<JField>addAll(results, Collections.<JField>unmodifiableList(Lists.<JField>newArrayList(_withType)));
      JField _jField_1 = new JField();
      JField _withName_1 = _jField_1.withName("assemblyContextID");
      JField _withType_1 = _withName_1.withType("String");
      Iterables.<JField>addAll(results, Collections.<JField>unmodifiableList(Lists.<JField>newArrayList(_withType_1)));
      EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity = this.pcmEntity.getProvidedRoles_InterfaceProvidingEntity();
      final Function1<ProvidedRole,Boolean> _function = new Function1<ProvidedRole,Boolean>() {
        public Boolean apply(final ProvidedRole it) {
          boolean _isInstance = OperationProvidedRole.class.isInstance(it);
          return Boolean.valueOf(_isInstance);
        }
      };
      Iterable<ProvidedRole> _filter = IterableExtensions.<ProvidedRole>filter(_providedRoles_InterfaceProvidingEntity, _function);
      final Function1<ProvidedRole,OperationProvidedRole> _function_1 = new Function1<ProvidedRole,OperationProvidedRole>() {
        public OperationProvidedRole apply(final ProvidedRole it) {
          return ((OperationProvidedRole) it);
        }
      };
      Iterable<OperationProvidedRole> _map = IterableExtensions.<ProvidedRole, OperationProvidedRole>map(_filter, _function_1);
      final Function1<OperationProvidedRole,JField> _function_2 = new Function1<OperationProvidedRole,JField>() {
        public JField apply(final OperationProvidedRole it) {
          JField _jField = new JField();
          String _portMemberVar = JavaNames.portMemberVar(it);
          JField _withName = _jField.withName(_portMemberVar);
          OperationInterface _providedInterface__OperationProvidedRole = it.getProvidedInterface__OperationProvidedRole();
          String _fqn = JavaNames.fqn(_providedInterface__OperationProvidedRole);
          JField _withType = _withName.withType(_fqn);
          return _withType;
        }
      };
      Iterable<JField> _map_1 = IterableExtensions.<OperationProvidedRole, JField>map(_map, _function_2);
      Iterables.<JField>addAll(results, _map_1);
      EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity_1 = this.pcmEntity.getProvidedRoles_InterfaceProvidingEntity();
      final Function1<ProvidedRole,Boolean> _function_3 = new Function1<ProvidedRole,Boolean>() {
        public Boolean apply(final ProvidedRole it) {
          boolean _isInstance = InfrastructureProvidedRole.class.isInstance(it);
          return Boolean.valueOf(_isInstance);
        }
      };
      Iterable<ProvidedRole> _filter_1 = IterableExtensions.<ProvidedRole>filter(_providedRoles_InterfaceProvidingEntity_1, _function_3);
      final Function1<ProvidedRole,InfrastructureProvidedRole> _function_4 = new Function1<ProvidedRole,InfrastructureProvidedRole>() {
        public InfrastructureProvidedRole apply(final ProvidedRole it) {
          return ((InfrastructureProvidedRole) it);
        }
      };
      Iterable<InfrastructureProvidedRole> _map_2 = IterableExtensions.<ProvidedRole, InfrastructureProvidedRole>map(_filter_1, _function_4);
      final Function1<InfrastructureProvidedRole,JField> _function_5 = new Function1<InfrastructureProvidedRole,JField>() {
        public JField apply(final InfrastructureProvidedRole it) {
          JField _jField = new JField();
          String _portMemberVar = JavaNames.portMemberVar(it);
          JField _withName = _jField.withName(_portMemberVar);
          InfrastructureInterface _providedInterface__InfrastructureProvidedRole = it.getProvidedInterface__InfrastructureProvidedRole();
          String _fqn = JavaNames.fqn(_providedInterface__InfrastructureProvidedRole);
          JField _withType = _withName.withType(_fqn);
          return _withType;
        }
      };
      Iterable<JField> _map_3 = IterableExtensions.<InfrastructureProvidedRole, JField>map(_map_2, _function_5);
      Iterables.<JField>addAll(results, _map_3);
      EList<PassiveResource> _passiveResource_BasicComponent = this.pcmEntity.getPassiveResource_BasicComponent();
      final Function1<PassiveResource,JField> _function_6 = new Function1<PassiveResource,JField>() {
        public JField apply(final PassiveResource it) {
          JField _jField = new JField();
          String _entityName = it.getEntityName();
          String _javaVariableName = JavaNames.javaVariableName(_entityName);
          String _plus = ("passive_resource_" + _javaVariableName);
          JField _withName = _jField.withName(_plus);
          JField _withType = _withName.withType("java.util.concurrent.Semaphore");
          return _withType;
        }
      };
      List<JField> _map_4 = ListExtensions.<PassiveResource, JField>map(_passiveResource_BasicComponent, _function_6);
      Iterables.<JField>addAll(results, _map_4);
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
  
  public Collection<? extends IJMethod> methods() {
    LinkedList<JMethod> _xblockexpression = null;
    {
      final LinkedList<JMethod> results = CollectionLiterals.<JMethod>newLinkedList();
      JMethod _jMethod = new JMethod();
      JMethod _withName = _jMethod.withName("setContext");
      JMethod _withParameters = _withName.withParameters("Object myContext");
      String _fqnContextInterface = JavaNames.fqnContextInterface(this.pcmEntity);
      String _plus = ("this.myContext = (" + _fqnContextInterface);
      String _plus_1 = (_plus + ") myContext;");
      JMethod _withImplementation = _withParameters.withImplementation(_plus_1);
      Iterables.<JMethod>addAll(results, Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation)));
      EList<ServiceEffectSpecification> _serviceEffectSpecifications__BasicComponent = this.pcmEntity.getServiceEffectSpecifications__BasicComponent();
      final Function1<ServiceEffectSpecification,JMethod> _function = new Function1<ServiceEffectSpecification,JMethod>() {
        public JMethod apply(final ServiceEffectSpecification it) {
          JMethod _jMethod = new JMethod();
          Signature _describedService__SEFF = it.getDescribedService__SEFF();
          String _serviceNameStub = JavaNames.serviceNameStub(_describedService__SEFF);
          JMethod _withName = _jMethod.withName(_serviceNameStub);
          Signature _describedService__SEFF_1 = it.getDescribedService__SEFF();
          String _returnDataType = DataTypes.getReturnDataType(_describedService__SEFF_1);
          JMethod _withReturnType = _withName.withReturnType(_returnDataType);
          Signature _describedService__SEFF_2 = it.getDescribedService__SEFF();
          String _parameterList = Parameters.getParameterList(_describedService__SEFF_2);
          JMethod _withParameters = _withReturnType.withParameters(_parameterList);
          StringConcatenation _builder = new StringConcatenation();
          PcmCodeStubAction _pcmCodeStubAction = new PcmCodeStubAction();
          EList<AbstractAction> _steps_Behaviour = ((ResourceDemandingBehaviour) it).getSteps_Behaviour();
          AbstractAction _get = _steps_Behaviour.get(0);
          String _actions = _pcmCodeStubAction.actions(_get);
          _builder.append(_actions, "");
          _builder.newLineIfNotEmpty();
          {
            Signature _describedService__SEFF_3 = it.getDescribedService__SEFF();
            String _returnDataType_1 = DataTypes.getReturnDataType(_describedService__SEFF_3);
            boolean _equals = _returnDataType_1.equals("void");
            boolean _not = (!_equals);
            if (_not) {
              _builder.append("return null;");
              _builder.newLine();
            }
          }
          JMethod _withImplementation = _withParameters.withImplementation(_builder.toString());
          return _withImplementation;
        }
      };
      List<JMethod> _map = ListExtensions.<ServiceEffectSpecification, JMethod>map(_serviceEffectSpecifications__BasicComponent, _function);
      Iterables.<JMethod>addAll(results, _map);
      EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity = this.pcmEntity.getProvidedRoles_InterfaceProvidingEntity();
      final Function1<ProvidedRole,Boolean> _function_1 = new Function1<ProvidedRole,Boolean>() {
        public Boolean apply(final ProvidedRole it) {
          boolean _isInstance = OperationProvidedRole.class.isInstance(it);
          return Boolean.valueOf(_isInstance);
        }
      };
      Iterable<ProvidedRole> _filter = IterableExtensions.<ProvidedRole>filter(_providedRoles_InterfaceProvidingEntity, _function_1);
      final Function1<ProvidedRole,JMethod> _function_2 = new Function1<ProvidedRole,JMethod>() {
        public JMethod apply(final ProvidedRole it) {
          JMethod _jMethod = new JMethod();
          String _portGetter = JavaNames.portGetter(it);
          JMethod _withName = _jMethod.withName(_portGetter);
          OperationInterface _providedInterface__OperationProvidedRole = ((OperationProvidedRole) it).getProvidedInterface__OperationProvidedRole();
          String _fqn = JavaNames.fqn(_providedInterface__OperationProvidedRole);
          JMethod _withReturnType = _withName.withReturnType(_fqn);
          String _portMemberVar = JavaNames.portMemberVar(((OperationProvidedRole) it));
          String _plus = ("return " + _portMemberVar);
          String _plus_1 = (_plus + ";");
          JMethod _withImplementation = _withReturnType.withImplementation(_plus_1);
          return _withImplementation;
        }
      };
      Iterable<JMethod> _map_1 = IterableExtensions.<ProvidedRole, JMethod>map(_filter, _function_2);
      Iterables.<JMethod>addAll(results, _map_1);
      JMethod _jMethod_1 = new JMethod();
      JMethod _withName_1 = _jMethod_1.withName("main");
      JMethod _withParameters_1 = _withName_1.withParameters("String[] args");
      JMethod _withStaticModifier = _withParameters_1.withStaticModifier();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("String ip = org.palladiosimulator.protocom.framework.registry.RmiRegistry.getIpFromArguments(args);");
      _builder.newLine();
      _builder.append("int port = org.palladiosimulator.protocom.framework.registry.RmiRegistry.getPortFromArguments(args);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("String assemblyContext = org.palladiosimulator.protocom.framework.AbstractMain.getAssemblyContextFromArguments(args);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("org.palladiosimulator.protocom.framework.registry.RmiRegistry.setRemoteAddress(ip);");
      _builder.newLine();
      _builder.append("org.palladiosimulator.protocom.framework.registry.RmiRegistry.setRegistryPort(port);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("new ");
      String _fqn = JavaNames.fqn(this.pcmEntity);
      _builder.append(_fqn, "");
      _builder.append("(assemblyContext);");
      _builder.newLineIfNotEmpty();
      JMethod _withImplementation_1 = _withStaticModifier.withImplementation(_builder.toString());
      results.add(_withImplementation_1);
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
}
