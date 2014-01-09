package org.palladiosimulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.tech.rmi.PojoInterface;

/**
 * Defining the content of OperationInterface classes.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class PojoOperationInterface /* extends /* PojoInterface<OperationInterface> */  */{
  public PojoOperationInterface(final /* OperationInterface */Object entity) {
    super(entity);
  }
  
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(JavaConstants.RMI_REMOTE_INTERFACE));
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Object to OperationSignature"
      + "\nsignatures__OperationInterface cannot be resolved"
      + "\nmap cannot be resolved");
  }
}
