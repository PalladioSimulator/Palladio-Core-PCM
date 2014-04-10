package org.palladiosimulator.protocom.tech.iiop.repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
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
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JField;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmCommons;
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPClass;

@SuppressWarnings("all")
public class JavaEEIIOPBasicComponentPortClass extends JavaEEIIOPClass<ProvidedRole> {
  public JavaEEIIOPBasicComponentPortClass(final ProvidedRole pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.palladiosimulator.protocom.framework.port.AbstractPerformancePrototypeBasicPort<");
    InterfaceProvidingEntity _providingEntity_ProvidedRole = this.pcmEntity.getProvidingEntity_ProvidedRole();
    String _fqnInterface = JavaNames.fqnInterface(_providingEntity_ProvidedRole);
    _builder.append(_fqnInterface, "");
    _builder.append(">");
    return _builder.toString();
  }
  
  public String packageName() {
    return JavaNames.fqnPortPackage(this.pcmEntity);
  }
  
  public String compilationUnitName() {
    return JavaNames.portClassName(this.pcmEntity);
  }
  
  public Collection<String> interfaces() {
    String _providedRoleInterface = this.providedRoleInterface(this.pcmEntity);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_providedRoleInterface));
  }
  
  public Collection<? extends IJMethod> constructors() {
    JMethod _jMethod = new JMethod();
    JMethod _jMethod_1 = new JMethod();
    JMethod _withParameters = _jMethod_1.withParameters("String assemblyContext");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("addVisitor(org.palladiosimulator.protocom.framework.visitor.SensorFrameworkVisitor.getInstance());");
    _builder.newLine();
    JMethod _withImplementation = _withParameters.withImplementation(_builder.toString());
    return Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_jMethod, _withImplementation));
  }
  
  public Collection<? extends IJMethod> methods() {
    return this.providedRoleMethods(this.pcmEntity);
  }
  
  public String filePath() {
    String _fqnPortPackage = JavaNames.fqnPortPackage(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnPortPackage);
    String _plus = (_fqnToDirectoryPath + "/");
    String _portClassName = JavaNames.portClassName(this.pcmEntity);
    String _plus_1 = (_plus + _portClassName);
    return (_plus_1 + ".java");
  }
  
  protected List<JMethod> _providedRoleMethods(final OperationProvidedRole role) {
    OperationInterface _providedInterface__OperationProvidedRole = role.getProvidedInterface__OperationProvidedRole();
    EList<OperationSignature> _signatures__OperationInterface = _providedInterface__OperationProvidedRole.getSignatures__OperationInterface();
    final Function1<OperationSignature,JMethod> _function = new Function1<OperationSignature,JMethod>() {
      public JMethod apply(final OperationSignature it) {
        JMethod _jMethod = new JMethod();
        String _javaSignature = JavaNames.javaSignature(it);
        JMethod _withName = _jMethod.withName(_javaSignature);
        String _stackframeType = PcmCommons.stackframeType();
        JMethod _withReturnType = _withName.withReturnType(_stackframeType);
        String _stackContextParameterList = PcmCommons.stackContextParameterList();
        JMethod _withParameters = _withReturnType.withParameters(_stackContextParameterList);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("preCallVisitor(ctx, \"");
        String _serviceName = JavaNames.serviceName(it);
        _builder.append(_serviceName, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> result = myComponent.");
        String _serviceName_1 = JavaNames.serviceName(it);
        _builder.append(_serviceName_1, "");
        _builder.append("(ctx);");
        _builder.newLineIfNotEmpty();
        _builder.append("postCallVisitor(ctx, \"");
        String _serviceName_2 = JavaNames.serviceName(it);
        _builder.append(_serviceName_2, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("return result;");
        _builder.newLine();
        return _withParameters.withImplementation(_builder.toString());
      }
    };
    return ListExtensions.<OperationSignature, JMethod>map(_signatures__OperationInterface, _function);
  }
  
  protected List<JMethod> _providedRoleMethods(final InfrastructureProvidedRole role) {
    InfrastructureInterface _providedInterface__InfrastructureProvidedRole = role.getProvidedInterface__InfrastructureProvidedRole();
    EList<InfrastructureSignature> _infrastructureSignatures__InfrastructureInterface = _providedInterface__InfrastructureProvidedRole.getInfrastructureSignatures__InfrastructureInterface();
    final Function1<InfrastructureSignature,JMethod> _function = new Function1<InfrastructureSignature,JMethod>() {
      public JMethod apply(final InfrastructureSignature it) {
        JMethod _jMethod = new JMethod();
        String _javaSignature = JavaNames.javaSignature(it);
        JMethod _withName = _jMethod.withName(_javaSignature);
        String _stackframeType = PcmCommons.stackframeType();
        JMethod _withReturnType = _withName.withReturnType(_stackframeType);
        String _stackContextParameterList = PcmCommons.stackContextParameterList();
        JMethod _withParameters = _withReturnType.withParameters(_stackContextParameterList);
        return _withParameters.withImplementation("return null;");
      }
    };
    return ListExtensions.<InfrastructureSignature, JMethod>map(_infrastructureSignatures__InfrastructureInterface, _function);
  }
  
  protected String _providedRoleInterface(final OperationProvidedRole role) {
    OperationInterface _providedInterface__OperationProvidedRole = role.getProvidedInterface__OperationProvidedRole();
    return JavaNames.fqn(_providedInterface__OperationProvidedRole);
  }
  
  protected String _providedRoleInterface(final InfrastructureProvidedRole role) {
    InfrastructureInterface _providedInterface__InfrastructureProvidedRole = role.getProvidedInterface__InfrastructureProvidedRole();
    return JavaNames.fqn(_providedInterface__InfrastructureProvidedRole);
  }
  
  public Collection<? extends IJField> jeeClassDependencyInjection() {
    LinkedList<JField> _xblockexpression = null;
    {
      final LinkedList<JField> results = CollectionLiterals.<JField>newLinkedList();
      JField _jField = new JField();
      JField _withName = _jField.withName("myComponent");
      InterfaceProvidingEntity _providingEntity_ProvidedRole = this.pcmEntity.getProvidingEntity_ProvidedRole();
      String _javaName = JavaNames.javaName(_providingEntity_ProvidedRole);
      JField _withType = _withName.withType(_javaName);
      Iterables.<JField>addAll(results, Collections.<JField>unmodifiableList(Lists.<JField>newArrayList(_withType)));
      _xblockexpression = results;
    }
    return _xblockexpression;
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
