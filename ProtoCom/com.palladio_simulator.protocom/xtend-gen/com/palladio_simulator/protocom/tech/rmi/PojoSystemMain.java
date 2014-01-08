package com.palladio_simulator.protocom.tech.rmi;

import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.tech.rmi.PojoClass;
import java.util.Collection;

@SuppressWarnings("all")
public class PojoSystemMain /* extends /* PojoClass<UsageScenario> */  */{
  public PojoSystemMain(final /* UsageScenario */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    return "com.palladio_simulator.protocom.framework.AbstractMain";
  }
  
  public String packageName() {
    return "ProtoComBootstrap";
  }
  
  public String compilationUnitName() {
    return "Main";
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nscenarioBehaviour_UsageScenario cannot be resolved"
      + "\nscenarioBehaviour_UsageScenario cannot be resolved");
  }
  
  public String filePath() {
    return "ProtoComBootstrap/Main.java";
  }
}
