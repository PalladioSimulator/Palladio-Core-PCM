package com.palladio_simulator.protocom.tech.rmi;

import com.google.common.collect.Iterables;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.impl.JMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaNames;
import com.palladio_simulator.protocom.tech.rmi.PojoInterface;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import java.util.Collection;
import java.util.LinkedList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class PojoBasicComponentContextInterface extends PojoInterface<BasicComponent> {
  public PojoBasicComponentContextInterface(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String filePath() {
    String _fqnContextInterface = JavaNames.fqnContextInterface(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnContextInterface);
    String _plus = (_fqnToDirectoryPath + ".java");
    return _plus;
  }
  
  public String packageName() {
    String _fqnContextPackage = JavaNames.fqnContextPackage(this.pcmEntity);
    return _fqnContextPackage;
  }
  
  public String compilationUnitName() {
    String _contextInterfaceName = JavaNames.contextInterfaceName(this.pcmEntity);
    return _contextInterfaceName;
  }
  
  public Collection<? extends IJMethod> methods() {
    LinkedList<JMethod> _xblockexpression = null;
    {
      final LinkedList<JMethod> results = CollectionLiterals.<JMethod>newLinkedList();
      EList<RequiredRole> _requiredRoles_InterfaceRequiringEntity = this.pcmEntity.getRequiredRoles_InterfaceRequiringEntity();
      final Function1<RequiredRole,Boolean> _function = new Function1<RequiredRole,Boolean>() {
          public Boolean apply(final RequiredRole it) {
            boolean _isInstance = OperationRequiredRole.class.isInstance(it);
            return Boolean.valueOf(_isInstance);
          }
        };
      Iterable<RequiredRole> _filter = IterableExtensions.<RequiredRole>filter(_requiredRoles_InterfaceRequiringEntity, _function);
      final Function1<RequiredRole,JMethod> _function_1 = new Function1<RequiredRole,JMethod>() {
          public JMethod apply(final RequiredRole it) {
            JMethod _jMethod = new JMethod();
            String _javaName = JavaNames.javaName(it);
            String _plus = ("getRole" + _javaName);
            JMethod _withName = _jMethod.withName(_plus);
            OperationInterface _requiredInterface__OperationRequiredRole = ((OperationRequiredRole) it).getRequiredInterface__OperationRequiredRole();
            String _fqn = JavaNames.fqn(_requiredInterface__OperationRequiredRole);
            JMethod _withReturnType = _withName.withReturnType(_fqn);
            return _withReturnType;
          }
        };
      Iterable<JMethod> _map = IterableExtensions.<RequiredRole, JMethod>map(_filter, _function_1);
      Iterables.<JMethod>addAll(results, _map);
      EList<RequiredRole> _requiredRoles_InterfaceRequiringEntity_1 = this.pcmEntity.getRequiredRoles_InterfaceRequiringEntity();
      final Function1<RequiredRole,Boolean> _function_2 = new Function1<RequiredRole,Boolean>() {
          public Boolean apply(final RequiredRole it) {
            boolean _isInstance = OperationRequiredRole.class.isInstance(it);
            return Boolean.valueOf(_isInstance);
          }
        };
      Iterable<RequiredRole> _filter_1 = IterableExtensions.<RequiredRole>filter(_requiredRoles_InterfaceRequiringEntity_1, _function_2);
      final Function1<RequiredRole,JMethod> _function_3 = new Function1<RequiredRole,JMethod>() {
          public JMethod apply(final RequiredRole it) {
            JMethod _jMethod = new JMethod();
            String _javaName = JavaNames.javaName(it);
            String _plus = ("setRole" + _javaName);
            JMethod _withName = _jMethod.withName(_plus);
            OperationInterface _requiredInterface__OperationRequiredRole = ((OperationRequiredRole) it).getRequiredInterface__OperationRequiredRole();
            String _fqn = JavaNames.fqn(_requiredInterface__OperationRequiredRole);
            String _plus_1 = (_fqn + " newValue");
            JMethod _withParameters = _withName.withParameters(_plus_1);
            return _withParameters;
          }
        };
      Iterable<JMethod> _map_1 = IterableExtensions.<RequiredRole, JMethod>map(_filter_1, _function_3);
      Iterables.<JMethod>addAll(results, _map_1);
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
}
