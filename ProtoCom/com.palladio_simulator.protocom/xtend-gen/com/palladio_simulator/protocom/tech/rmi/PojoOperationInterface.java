package com.palladio_simulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaConstants;
import com.palladio_simulator.protocom.tech.rmi.PojoInterface;
import java.util.Collection;
import java.util.Collections;

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
