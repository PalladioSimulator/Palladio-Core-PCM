package org.palladiosimulator.protocom.tech.rmi;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmCommons;
import org.palladiosimulator.protocom.tech.rmi.PojoInterface;

/**
 * Defining the content of component implementation interfaces (the interfaces for the
 * classes implementing the component behavior).
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class PojoComponentClassInterface extends PojoInterface<BasicComponent> {
  public PojoComponentClassInterface(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String compilationUnitName() {
    String _interfaceName = JavaNames.interfaceName(this.pcmEntity);
    return _interfaceName;
  }
  
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList("org.palladiosimulator.protocom.framework.IComponent"));
  }
  
  public Collection<? extends IJMethod> methods() {
    LinkedList<JMethod> _xblockexpression = null;
    {
      final LinkedList<JMethod> results = CollectionLiterals.<JMethod>newLinkedList();
      JMethod _jMethod = new JMethod();
      JMethod _withName = _jMethod.withName("setContext");
      JMethod _withParameters = _withName.withParameters("Object myContext");
      JMethod _jMethod_1 = new JMethod();
      JMethod _withName_1 = _jMethod_1.withName("setComponentFrame");
      String _stackframeParameterList = PcmCommons.stackframeParameterList();
      JMethod _withParameters_1 = _withName_1.withParameters(_stackframeParameterList);
      Iterables.<JMethod>addAll(results, Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withParameters, _withParameters_1)));
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
          return _withParameters;
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
      final Function1<ProvidedRole,OperationProvidedRole> _function_2 = new Function1<ProvidedRole,OperationProvidedRole>() {
        public OperationProvidedRole apply(final ProvidedRole it) {
          return ((OperationProvidedRole) it);
        }
      };
      Iterable<OperationProvidedRole> _map_1 = IterableExtensions.<ProvidedRole, OperationProvidedRole>map(_filter, _function_2);
      final Function1<OperationProvidedRole,JMethod> _function_3 = new Function1<OperationProvidedRole,JMethod>() {
        public JMethod apply(final OperationProvidedRole it) {
          JMethod _jMethod = new JMethod();
          String _portGetter = JavaNames.portGetter(it);
          JMethod _withName = _jMethod.withName(_portGetter);
          OperationInterface _providedInterface__OperationProvidedRole = it.getProvidedInterface__OperationProvidedRole();
          String _fqn = JavaNames.fqn(_providedInterface__OperationProvidedRole);
          JMethod _withReturnType = _withName.withReturnType(_fqn);
          return _withReturnType;
        }
      };
      Iterable<JMethod> _map_2 = IterableExtensions.<OperationProvidedRole, JMethod>map(_map_1, _function_3);
      Iterables.<JMethod>addAll(results, _map_2);
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
  
  public String filePath() {
    String _fqnInterface = JavaNames.fqnInterface(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnInterface);
    String _plus = (_fqnToDirectoryPath + ".java");
    return _plus;
  }
}
