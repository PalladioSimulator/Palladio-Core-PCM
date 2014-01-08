package com.palladio_simulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import com.palladio_simulator.protocom.lang.java.IJField;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaNames;
import com.palladio_simulator.protocom.tech.rmi.PojoClass;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("all")
public class PojoUsageScenario /* extends /* PojoClass<UsageScenario> */  */{
  public PojoUsageScenario(final /* UsageScenario */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<? extends IJMethod> constructors() {
    throw new Error("Unresolved compilation problems:"
      + "\nscenarioBehaviour_UsageScenario cannot be resolved"
      + "\nprovidedRole_EntryLevelSystemCall cannot be resolved");
  }
  
  public String contextInit(final /* OperationProvidedRole */Object role) {
    throw new Error("Unresolved compilation problems:"
      + "\nAmbiguous feature call.\nThe methods\n\tportMemberVar(OperationProvidedRole) in JavaNames and\n\tportMemberVar(InfrastructureProvidedRole) in JavaNames\nboth match."
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved");
  }
  
  public Collection<String> interfaces() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList("java.lang.Runnable"));
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Start is undefined for the type PojoUsageScenario"
      + "\nscenarioBehaviour_UsageScenario cannot be resolved"
      + "\nactions_ScenarioBehaviour cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nget cannot be resolved");
  }
  
  public Collection<? extends IJField> fields() {
    throw new Error("Unresolved compilation problems:"
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nOperationProvidedRole cannot be resolved to a type."
      + "\nAmbiguous feature call.\nThe methods\n\tportMemberVar(OperationProvidedRole) in JavaNames and\n\tportMemberVar(InfrastructureProvidedRole) in JavaNames\nboth match."
      + "\nscenarioBehaviour_UsageScenario cannot be resolved"
      + "\nprovidedRole_EntryLevelSystemCall cannot be resolved"
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved");
  }
  
  public String filePath() {
    Object _implementationPackage = JavaNames.implementationPackage(this.pcmEntity);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_implementationPackage);
    String _plus = (_fqnToDirectoryPath + "/");
    String _javaName = JavaNames.javaName(this.pcmEntity);
    String _plus_1 = (_plus + _javaName);
    String _plus_2 = (_plus_1 + ".java");
    return _plus_2;
  }
}
