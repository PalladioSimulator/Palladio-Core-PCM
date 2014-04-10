package org.palladiosimulator.protocom.tech.pojo.repository;

import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.DataTypes;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.Parameters;
import org.palladiosimulator.protocom.tech.rmi.PojoInterface;

/**
 * Defining the content of OperationInterface classes.
 * 
 * @author Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PojoOperationInterface extends PojoInterface<OperationInterface> {
  public PojoOperationInterface(final OperationInterface entity) {
    super(entity);
  }
  
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(JavaConstants.RMI_REMOTE_INTERFACE));
  }
  
  public Collection<? extends IJMethod> methods() {
    EList<OperationSignature> _signatures__OperationInterface = this.pcmEntity.getSignatures__OperationInterface();
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
        return _withParameters.withThrows(JavaConstants.RMI_REMOTE_EXCEPTION);
      }
    };
    return ListExtensions.<OperationSignature, JMethod>map(_signatures__OperationInterface, _function);
  }
}
