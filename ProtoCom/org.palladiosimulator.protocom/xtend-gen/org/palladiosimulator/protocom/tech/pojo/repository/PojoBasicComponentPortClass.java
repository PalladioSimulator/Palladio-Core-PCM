package org.palladiosimulator.protocom.tech.pojo.repository;

import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.DataTypes;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.Parameters;
import org.palladiosimulator.protocom.tech.rmi.PojoClass;

/**
 * Provider for port classes based on provided roles. Please note that InfrastructureProvidedRoles
 * were - to some degree - hacked into the PCM such that cumbersome case distinction for
 * Operation and Infrastructure is necessary.
 * 
 * Possible TODO is to split PojoBasicComponentPortClass into two classes with a common super type.
 * Keep in mind though that InfrastructureComponents in ProtoCom are not generated, but rather calls
 * to the real infrastructure!
 * 
 * TODO Code stubs may also use CallVistitors like the performance prototype implementation.
 *      Note that, in this case, the ctx object might simply be removed.
 * 
 * @author Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PojoBasicComponentPortClass extends PojoClass<ProvidedRole> {
  public PojoBasicComponentPortClass(final ProvidedRole pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.palladiosimulator.protocom.framework.port.AbstractBasicPort<");
    InterfaceProvidingEntity _providingEntity_ProvidedRole = this.pcmEntity.getProvidingEntity_ProvidedRole();
    String _fqnInterface = JavaNames.fqnInterface(_providingEntity_ProvidedRole);
    _builder.append(_fqnInterface, "");
    _builder.append(">");
    return _builder.toString();
  }
  
  public String packageName() {
    String _fqnPortPackage = JavaNames.fqnPortPackage(this.pcmEntity);
    return _fqnPortPackage;
  }
  
  public String compilationUnitName() {
    String _portClassName = JavaNames.portClassName(this.pcmEntity);
    return _portClassName;
  }
  
  public Collection<String> interfaces() {
    String _providedRoleInterface = this.providedRoleInterface(this.pcmEntity);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_providedRoleInterface));
  }
  
  public Collection<? extends IJMethod> constructors() {
    JMethod _jMethod = new JMethod();
    InterfaceProvidingEntity _providingEntity_ProvidedRole = this.pcmEntity.getProvidingEntity_ProvidedRole();
    String _fqnInterface = JavaNames.fqnInterface(_providingEntity_ProvidedRole);
    String _plus = (_fqnInterface + " myComponent, String assemblyContext");
    JMethod _withParameters = _jMethod.withParameters(_plus);
    JMethod _withThrows = _withParameters.withThrows("java.rmi.RemoteException");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.myComponent = myComponent;");
    _builder.newLine();
    _builder.append("org.palladiosimulator.protocom.framework.registry.RmiRegistry.registerPort(org.palladiosimulator.protocom.framework.registry.RmiRegistry.getRemoteAddress(),");
    _builder.newLine();
    _builder.append("org.palladiosimulator.protocom.framework.registry.RmiRegistry.getRegistryPort(), this, \"");
    String _portClassName = JavaNames.portClassName(this.pcmEntity);
    _builder.append(_portClassName, "");
    _builder.append("_\" + assemblyContext);");
    _builder.newLineIfNotEmpty();
    JMethod _withImplementation = _withThrows.withImplementation(_builder.toString());
    return Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation));
  }
  
  public Collection<? extends IJMethod> methods() {
    List<JMethod> _providedRoleMethods = this.providedRoleMethods(this.pcmEntity);
    return _providedRoleMethods;
  }
  
  public String filePath() {
    String _fqnPortPackage = JavaNames.fqnPortPackage(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnPortPackage);
    String _plus = (_fqnToDirectoryPath + "/");
    String _portClassName = JavaNames.portClassName(this.pcmEntity);
    String _plus_1 = (_plus + _portClassName);
    String _plus_2 = (_plus_1 + 
      ".java");
    return _plus_2;
  }
  
  protected List<JMethod> _providedRoleMethods(final OperationProvidedRole role) {
    OperationInterface _providedInterface__OperationProvidedRole = role.getProvidedInterface__OperationProvidedRole();
    EList<OperationSignature> _signatures__OperationInterface = _providedInterface__OperationProvidedRole.getSignatures__OperationInterface();
    final Function1<OperationSignature,JMethod> _function = new Function1<OperationSignature,JMethod>() {
      public JMethod apply(final OperationSignature it) {
        JMethod _jMethod = new JMethod();
        String _javaName = JavaNames.javaName(it);
        JMethod _withName = _jMethod.withName(_javaName);
        DataType _returnType__OperationSignature = it.getReturnType__OperationSignature();
        String _dataType = DataTypes.getDataType(_returnType__OperationSignature);
        JMethod _withReturnType = _withName.withReturnType(_dataType);
        String _parameterList = Parameters.getParameterList(it);
        JMethod _withParameters = _withReturnType.withParameters(_parameterList);
        StringConcatenation _builder = new StringConcatenation();
        {
          String _returnDataType = DataTypes.getReturnDataType(it);
          boolean _equals = _returnDataType.equals("void");
          boolean _not = (!_equals);
          if (_not) {
            _builder.append("return ");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("myComponent.");
        String _serviceNameStub = JavaNames.serviceNameStub(it);
        _builder.append(_serviceNameStub, "	");
        _builder.append("(");
        String _parameterUsageList = Parameters.getParameterUsageList(it);
        _builder.append(_parameterUsageList, "	");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        JMethod _withImplementation = _withParameters.withImplementation(_builder.toString());
        JMethod _withThrows = _withImplementation.withThrows(JavaConstants.RMI_REMOTE_EXCEPTION);
        return _withThrows;
      }
    };
    List<JMethod> _map = ListExtensions.<OperationSignature, JMethod>map(_signatures__OperationInterface, _function);
    return _map;
  }
  
  protected List<JMethod> _providedRoleMethods(final InfrastructureProvidedRole role) {
    InfrastructureInterface _providedInterface__InfrastructureProvidedRole = role.getProvidedInterface__InfrastructureProvidedRole();
    EList<InfrastructureSignature> _infrastructureSignatures__InfrastructureInterface = _providedInterface__InfrastructureProvidedRole.getInfrastructureSignatures__InfrastructureInterface();
    final Function1<InfrastructureSignature,JMethod> _function = new Function1<InfrastructureSignature,JMethod>() {
      public JMethod apply(final InfrastructureSignature it) {
        JMethod _jMethod = new JMethod();
        String _javaName = JavaNames.javaName(it);
        JMethod _withName = _jMethod.withName(_javaName);
        JMethod _withReturnType = _withName.withReturnType("void");
        String _parameterList = Parameters.getParameterList(it);
        JMethod _withParameters = _withReturnType.withParameters(_parameterList);
        JMethod _withImplementation = _withParameters.withImplementation("return null;");
        JMethod _withThrows = _withImplementation.withThrows(
          JavaConstants.RMI_REMOTE_EXCEPTION);
        return _withThrows;
      }
    };
    List<JMethod> _map = ListExtensions.<InfrastructureSignature, JMethod>map(_infrastructureSignatures__InfrastructureInterface, _function);
    return _map;
  }
  
  protected String _providedRoleInterface(final OperationProvidedRole role) {
    OperationInterface _providedInterface__OperationProvidedRole = role.getProvidedInterface__OperationProvidedRole();
    String _fqn = JavaNames.fqn(_providedInterface__OperationProvidedRole);
    return _fqn;
  }
  
  protected String _providedRoleInterface(final InfrastructureProvidedRole role) {
    InfrastructureInterface _providedInterface__InfrastructureProvidedRole = role.getProvidedInterface__InfrastructureProvidedRole();
    String _fqn = JavaNames.fqn(_providedInterface__InfrastructureProvidedRole);
    return _fqn;
  }
  
  public List<JMethod> providedRoleMethods(final ProvidedRole role) {
    if (role instanceof InfrastructureProvidedRole) {
      return _providedRoleMethods((InfrastructureProvidedRole)role);
    } else if (role instanceof OperationProvidedRole) {
      return _providedRoleMethods((OperationProvidedRole)role);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(role).toString());
    }
  }
  
  public String providedRoleInterface(final ProvidedRole role) {
    if (role instanceof InfrastructureProvidedRole) {
      return _providedRoleInterface((InfrastructureProvidedRole)role);
    } else if (role instanceof OperationProvidedRole) {
      return _providedRoleInterface((OperationProvidedRole)role);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(role).toString());
    }
  }
}
