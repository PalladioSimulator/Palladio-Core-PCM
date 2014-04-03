package org.palladiosimulator.protocom.tech.rmi.repository;

import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmCommons;
import org.palladiosimulator.protocom.tech.rmi.PojoInterface;

/**
 * Defining the content of InfrastructureInterface classes.
 * 
 * @author Thomas Zolynski, Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PojoInfrastructureInterface extends PojoInterface<InfrastructureInterface> {
  public PojoInfrastructureInterface(final InfrastructureInterface entity) {
    super(entity);
  }
  
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(JavaConstants.RMI_REMOTE_INTERFACE));
  }
  
  public Collection<? extends IJMethod> methods() {
    EList<InfrastructureSignature> _infrastructureSignatures__InfrastructureInterface = this.pcmEntity.getInfrastructureSignatures__InfrastructureInterface();
    final Function1<InfrastructureSignature,JMethod> _function = new Function1<InfrastructureSignature,JMethod>() {
      public JMethod apply(final InfrastructureSignature it) {
        JMethod _jMethod = new JMethod();
        String _javaSignature = JavaNames.javaSignature(it);
        JMethod _withName = _jMethod.withName(_javaSignature);
        String _stackframeType = PcmCommons.stackframeType();
        JMethod _withReturnType = _withName.withReturnType(_stackframeType);
        String _stackContextParameterList = PcmCommons.stackContextParameterList();
        JMethod _withParameters = _withReturnType.withParameters(_stackContextParameterList);
        return _withParameters.withThrows(JavaConstants.RMI_REMOTE_EXCEPTION);
      }
    };
    return ListExtensions.<InfrastructureSignature, JMethod>map(_infrastructureSignatures__InfrastructureInterface, _function);
  }
}
