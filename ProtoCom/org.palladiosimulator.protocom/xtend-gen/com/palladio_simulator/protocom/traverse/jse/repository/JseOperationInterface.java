package com.palladio_simulator.protocom.traverse.jse.repository;

import com.palladio_simulator.protocom.lang.GeneratedFile;
import com.palladio_simulator.protocom.lang.java.IJInterface;
import com.palladio_simulator.protocom.lang.java.impl.JInterface;
import com.palladio_simulator.protocom.tech.rmi.PojoOperationInterface;
import com.palladio_simulator.protocom.traverse.framework.repository.XOperationInterface;

/**
 * An Operation Interface translates into the following Java compilation units:
 * <ul>
 * 	<li> an interface.
 * </ul>
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class JseOperationInterface extends XOperationInterface {
  public void generate() {
    JInterface _instance = this.injector.<JInterface>getInstance(JInterface.class);
    PojoOperationInterface _pojoOperationInterface = new PojoOperationInterface(this.entity);
    GeneratedFile<IJInterface> _createFor = _instance.createFor(_pojoOperationInterface);
    this.generatedFiles.add(_createFor);
  }
}
