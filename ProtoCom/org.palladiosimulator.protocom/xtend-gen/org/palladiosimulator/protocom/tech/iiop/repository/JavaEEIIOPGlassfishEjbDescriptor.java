package org.palladiosimulator.protocom.tech.iiop.repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPDescriptor;

@SuppressWarnings("all")
public class JavaEEIIOPGlassfishEjbDescriptor extends JavaEEIIOPDescriptor<BasicComponent> {
  public JavaEEIIOPGlassfishEjbDescriptor(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String ejbName() {
    return JavaNames.javaName(this.pcmEntity);
  }
  
  public Collection<String> ejbRefName() {
    return this.requiredInterfaces();
  }
  
  public String jndiName() {
    return "Package of the required Component";
  }
  
  public String filePath() {
    String _fqnJavaEEDescriptorPath = JavaNames.fqnJavaEEDescriptorPath(this.pcmEntity);
    return (_fqnJavaEEDescriptorPath + "glassfish-ejb-jar.xml");
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEDescriptorProjectName(this.pcmEntity);
  }
  
  public LinkedList<String> requiredInterfaces() {
    LinkedList<String> _xblockexpression = null;
    {
      final LinkedList<String> results = CollectionLiterals.<String>newLinkedList();
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
        OperationInterface _requiredInterface__OperationRequiredRole = required.getRequiredInterface__OperationRequiredRole();
        String _javaName = JavaNames.javaName(_requiredInterface__OperationRequiredRole);
        Iterables.<String>addAll(results, Collections.<String>unmodifiableList(Lists.<String>newArrayList(_javaName)));
      }
      _xblockexpression = results;
    }
    return _xblockexpression;
  }
}
