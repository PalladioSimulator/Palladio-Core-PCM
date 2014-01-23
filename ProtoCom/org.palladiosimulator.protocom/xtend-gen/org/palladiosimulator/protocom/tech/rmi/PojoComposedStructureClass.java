package org.palladiosimulator.protocom.tech.rmi;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
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
import org.palladiosimulator.protocom.lang.java.IJClass;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JField;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmCalls;
import org.palladiosimulator.protocom.tech.rmi.PojoClass;

/**
 * Common provider for System and CompositeComponent elements.
 * 
 * The most important difference between a System and a CompositeComponent is that the
 * BasicComponents of a CompositeComponent are always deployed on the same ResourceEnvironment
 * and therefore can be initialized by the enclosing child component.
 * 
 * This does NOT hold for Systems, as these use the RMI registry to assembly their enclosed
 * child components.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public abstract class PojoComposedStructureClass<E extends ComposedProvidingRequiringEntity> extends PojoClass<E> implements IJClass {
  public PojoComposedStructureClass(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<? extends IJField> fields() {
    LinkedList<JField> _xblockexpression = null;
    {
      LinkedList<JField> results = CollectionLiterals.<JField>newLinkedList();
      JField _jField = new JField();
      JField _withName = _jField.withName("myContext");
      String _fqnContextInterface = JavaNames.fqnContextInterface(this.pcmEntity);
      JField _withType = _withName.withType(_fqnContextInterface);
      Iterables.<JField>addAll(results, Collections.<JField>unmodifiableList(Lists.<JField>newArrayList(_withType)));
      JField _jField_1 = new JField();
      JField _withName_1 = _jField_1.withName("assemblyContextID");
      JField _withType_1 = _withName_1.withType(JavaConstants.TYPE_STRING);
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
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
  
  public Collection<? extends IJMethod> methods() {
    LinkedList<JMethod> _xblockexpression = null;
    {
      LinkedList<JMethod> results = CollectionLiterals.<JMethod>newLinkedList();
      JMethod _jMethod = new JMethod();
      JMethod _withName = _jMethod.withName("setContext");
      JMethod _withParameters = _withName.withParameters("Object myContext");
      String _fqnContextInterface = JavaNames.fqnContextInterface(this.pcmEntity);
      String _plus = ("this.myContext = (" + _fqnContextInterface);
      String _plus_1 = (_plus + ") myContext;");
      JMethod _withImplementation = _withParameters.withImplementation(_plus_1);
      Iterables.<JMethod>addAll(results, Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation)));
      EList<AssemblyContext> _assemblyContexts__ComposedStructure = this.pcmEntity.getAssemblyContexts__ComposedStructure();
      final Function1<AssemblyContext,JMethod> _function = new Function1<AssemblyContext,JMethod>() {
        public JMethod apply(final AssemblyContext it) {
          JMethod _jMethod = new JMethod();
          String _javaName = JavaNames.javaName(it);
          String _plus = ("init" + _javaName);
          JMethod _withName = _jMethod.withName(_plus);
          JMethod _withVisibilityModifier = _withName.withVisibilityModifier(JavaConstants.VISIBILITY_PRIVATE);
          JMethod _withThrows = _withVisibilityModifier.withThrows(JavaConstants.RMI_REMOTE_EXCEPTION);
          StringConcatenation _builder = new StringConcatenation();
          RepositoryComponent _encapsulatedComponent__AssemblyContext = it.getEncapsulatedComponent__AssemblyContext();
          String _fqnContext = JavaNames.fqnContext(_encapsulatedComponent__AssemblyContext);
          _builder.append(_fqnContext, "");
          _builder.append(" context = new ");
          RepositoryComponent _encapsulatedComponent__AssemblyContext_1 = it.getEncapsulatedComponent__AssemblyContext();
          String _fqnContext_1 = JavaNames.fqnContext(_encapsulatedComponent__AssemblyContext_1);
          _builder.append(_fqnContext_1, "");
          _builder.append("(");
          _builder.newLineIfNotEmpty();
          {
            RepositoryComponent _encapsulatedComponent__AssemblyContext_2 = it.getEncapsulatedComponent__AssemblyContext();
            EList<RequiredRole> _requiredRoles_InterfaceRequiringEntity = _encapsulatedComponent__AssemblyContext_2.getRequiredRoles_InterfaceRequiringEntity();
            final Function1<RequiredRole,Boolean> _function = new Function1<RequiredRole,Boolean>() {
              public Boolean apply(final RequiredRole it) {
                boolean _isInstance = OperationRequiredRole.class.isInstance(it);
                return Boolean.valueOf(_isInstance);
              }
            };
            Iterable<RequiredRole> _filter = IterableExtensions.<RequiredRole>filter(_requiredRoles_InterfaceRequiringEntity, _function);
            final Function1<RequiredRole,OperationRequiredRole> _function_1 = new Function1<RequiredRole,OperationRequiredRole>() {
              public OperationRequiredRole apply(final RequiredRole it) {
                return ((OperationRequiredRole) it);
              }
            };
            Iterable<OperationRequiredRole> _map = IterableExtensions.<RequiredRole, OperationRequiredRole>map(_filter, _function_1);
            boolean _hasElements = false;
            for(final OperationRequiredRole requiredRole : _map) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(", ", "");
              }
              CharSequence _portQuery = PcmCalls.portQuery(requiredRole, PojoComposedStructureClass.this.pcmEntity, it);
              _builder.append(_portQuery, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t\t");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();");
          _builder.newLine();
          _builder.append("my");
          String _javaName_1 = JavaNames.javaName(it);
          _builder.append(_javaName_1, "");
          _builder.append(".setComponentFrame(componentStackFrame);");
          _builder.newLineIfNotEmpty();
          _builder.append("my");
          String _javaName_2 = JavaNames.javaName(it);
          _builder.append(_javaName_2, "");
          _builder.append(".setContext(context);");
          _builder.newLineIfNotEmpty();
          JMethod _withImplementation = _withThrows.withImplementation(_builder.toString());
          return _withImplementation;
        }
      };
      List<JMethod> _map = ListExtensions.<AssemblyContext, JMethod>map(_assemblyContexts__ComposedStructure, _function);
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
          String _portMemberVar = JavaNames.portMemberVar(it);
          String _plus = ("return " + _portMemberVar);
          String _plus_1 = (_plus + ";");
          JMethod _withImplementation = _withReturnType.withImplementation(_plus_1);
          return _withImplementation;
        }
      };
      Iterable<JMethod> _map_2 = IterableExtensions.<OperationProvidedRole, JMethod>map(_map_1, _function_3);
      Iterables.<JMethod>addAll(results, _map_2);
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
}
