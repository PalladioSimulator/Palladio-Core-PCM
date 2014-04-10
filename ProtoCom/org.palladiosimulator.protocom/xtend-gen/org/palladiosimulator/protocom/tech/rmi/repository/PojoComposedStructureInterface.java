package org.palladiosimulator.protocom.tech.rmi.repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJInterface;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.ConceptMapping;

/**
 * Defining the content of component implementation interfaces (the interfaces for
 * the classes implementing the component behavior).
 * 
 * @author Thomas Zolynski, Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PojoComposedStructureInterface extends ConceptMapping<InterfaceProvidingEntity> implements IJInterface {
  public PojoComposedStructureInterface(final InterfaceProvidingEntity pcmEntity) {
    super(pcmEntity);
  }
  
  public String packageName() {
    return JavaNames.implementationPackage(this.pcmEntity);
  }
  
  public String compilationUnitName() {
    return JavaNames.interfaceName(this.pcmEntity);
  }
  
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(JavaConstants.RMI_REMOTE_INTERFACE, JavaConstants.SERIALIZABLE_INTERFACE));
  }
  
  public Collection<? extends IJMethod> methods() {
    LinkedList<JMethod> _xblockexpression = null;
    {
      final LinkedList<JMethod> results = CollectionLiterals.<JMethod>newLinkedList();
      JMethod _jMethod = new JMethod();
      JMethod _withName = _jMethod.withName("setContext");
      JMethod _withParameters = _withName.withParameters("Object myContext");
      Iterables.<JMethod>addAll(results, Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withParameters)));
      EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity = this.pcmEntity.getProvidedRoles_InterfaceProvidingEntity();
      final Function1<ProvidedRole,Boolean> _function = new Function1<ProvidedRole,Boolean>() {
        public Boolean apply(final ProvidedRole it) {
          return Boolean.valueOf(OperationProvidedRole.class.isInstance(it));
        }
      };
      Iterable<ProvidedRole> _filter = IterableExtensions.<ProvidedRole>filter(_providedRoles_InterfaceProvidingEntity, _function);
      final Function1<ProvidedRole,JMethod> _function_1 = new Function1<ProvidedRole,JMethod>() {
        public JMethod apply(final ProvidedRole it) {
          JMethod _jMethod = new JMethod();
          String _portGetter = JavaNames.portGetter(it);
          JMethod _withName = _jMethod.withName(_portGetter);
          OperationInterface _providedInterface__OperationProvidedRole = ((OperationProvidedRole) it).getProvidedInterface__OperationProvidedRole();
          String _fqn = JavaNames.fqn(_providedInterface__OperationProvidedRole);
          return _withName.withReturnType(_fqn);
        }
      };
      Iterable<JMethod> _map = IterableExtensions.<ProvidedRole, JMethod>map(_filter, _function_1);
      Iterables.<JMethod>addAll(results, _map);
      _xblockexpression = results;
    }
    return _xblockexpression;
  }
  
  public Collection<? extends IJField> fields() {
    return null;
  }
  
  public String filePath() {
    String _fqnInterface = JavaNames.fqnInterface(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_fqnInterface);
    return (_fqnToDirectoryPath + ".java");
  }
}
