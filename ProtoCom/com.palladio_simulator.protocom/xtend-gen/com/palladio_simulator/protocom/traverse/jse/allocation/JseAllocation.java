package com.palladio_simulator.protocom.traverse.jse.allocation;

import com.palladio_simulator.protocom.lang.GeneratedFile;
import com.palladio_simulator.protocom.lang.java.IJClass;
import com.palladio_simulator.protocom.lang.java.impl.JClass;
import com.palladio_simulator.protocom.tech.rmi.PojoAllocationStorage;
import com.palladio_simulator.protocom.traverse.framework.allocation.XAllocation;

/**
 * An Allocation for JSE translates into one additional container information file.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class JseAllocation extends XAllocation {
  public void generate() {
    JClass _instance = this.injector.<JClass>getInstance(JClass.class);
    PojoAllocationStorage _pojoAllocationStorage = new PojoAllocationStorage(this.entity);
    GeneratedFile<IJClass> _createFor = _instance.createFor(_pojoAllocationStorage);
    this.generatedFiles.add(_createFor);
  }
}
