package org.palladiosimulator.protocom.tech.rmi;

import java.util.Collection;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.tech.rmi.PojoClass;

@SuppressWarnings("all")
public class PojoSystemMain /* extends /* PojoClass<UsageScenario> */  */{
  public PojoSystemMain(final /* UsageScenario */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    return "org.palladiosimulator.protocom.framework.AbstractMain";
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
