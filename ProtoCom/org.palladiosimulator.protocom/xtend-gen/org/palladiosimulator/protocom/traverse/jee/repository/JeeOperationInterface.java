package org.palladiosimulator.protocom.traverse.jee.repository;

import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.java.IJeeInterface;
import org.palladiosimulator.protocom.lang.java.impl.JeeInterface;
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPOperationInterface;
import org.palladiosimulator.protocom.traverse.framework.repository.XOperationInterface;

@SuppressWarnings("all")
public class JeeOperationInterface extends XOperationInterface {
  public void generate() {
    JeeInterface _instance = this.injector.<JeeInterface>getInstance(JeeInterface.class);
    JavaEEIIOPOperationInterface _javaEEIIOPOperationInterface = new JavaEEIIOPOperationInterface(this.entity);
    GeneratedFile<IJeeInterface> _createFor = _instance.createFor(_javaEEIIOPOperationInterface);
    this.generatedFiles.add(_createFor);
  }
}
