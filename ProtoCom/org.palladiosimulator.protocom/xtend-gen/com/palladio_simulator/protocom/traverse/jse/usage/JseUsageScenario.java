package com.palladio_simulator.protocom.traverse.jse.usage;

import com.palladio_simulator.protocom.lang.GeneratedFile;
import com.palladio_simulator.protocom.lang.java.IJClass;
import com.palladio_simulator.protocom.lang.java.impl.JClass;
import com.palladio_simulator.protocom.tech.rmi.PojoSystemMain;
import com.palladio_simulator.protocom.tech.rmi.PojoUsageClosedScenarioThread;
import com.palladio_simulator.protocom.tech.rmi.PojoUsageScenario;
import com.palladio_simulator.protocom.traverse.framework.usage.XUsageScenario;

@SuppressWarnings("all")
public class JseUsageScenario extends XUsageScenario {
  public void generate() {
    JClass _instance = this.injector.<JClass>getInstance(JClass.class);
    PojoUsageScenario _pojoUsageScenario = new PojoUsageScenario(this.entity);
    GeneratedFile<IJClass> _createFor = _instance.createFor(_pojoUsageScenario);
    this.generatedFiles.add(_createFor);
    JClass _instance_1 = this.injector.<JClass>getInstance(JClass.class);
    PojoUsageClosedScenarioThread _pojoUsageClosedScenarioThread = new PojoUsageClosedScenarioThread(this.entity);
    GeneratedFile<IJClass> _createFor_1 = _instance_1.createFor(_pojoUsageClosedScenarioThread);
    this.generatedFiles.add(_createFor_1);
    JClass _instance_2 = this.injector.<JClass>getInstance(JClass.class);
    PojoSystemMain _pojoSystemMain = new PojoSystemMain(this.entity);
    GeneratedFile<IJClass> _createFor_2 = _instance_2.createFor(_pojoSystemMain);
    this.generatedFiles.add(_createFor_2);
  }
}
