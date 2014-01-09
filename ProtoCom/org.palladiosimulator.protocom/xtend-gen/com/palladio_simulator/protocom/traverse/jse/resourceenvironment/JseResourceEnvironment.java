package com.palladio_simulator.protocom.traverse.jse.resourceenvironment;

import com.palladio_simulator.protocom.lang.GeneratedFile;
import com.palladio_simulator.protocom.lang.java.IJClass;
import com.palladio_simulator.protocom.lang.java.impl.JClass;
import com.palladio_simulator.protocom.tech.rmi.PojoResourceEnvironment;
import com.palladio_simulator.protocom.traverse.framework.resourceenvironment.XResourceEnvironment;

/**
 * Resource Environments for JSE are a config file used for calibration of active resources.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class JseResourceEnvironment extends XResourceEnvironment {
  public void generate() {
    JClass _instance = this.injector.<JClass>getInstance(JClass.class);
    PojoResourceEnvironment _pojoResourceEnvironment = new PojoResourceEnvironment(this.entity);
    GeneratedFile<IJClass> _createFor = _instance.createFor(_pojoResourceEnvironment);
    this.generatedFiles.add(_createFor);
  }
}
