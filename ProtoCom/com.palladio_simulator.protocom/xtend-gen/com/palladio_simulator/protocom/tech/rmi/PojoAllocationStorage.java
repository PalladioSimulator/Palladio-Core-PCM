package com.palladio_simulator.protocom.tech.rmi;

import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.tech.rmi.PojoClass;
import java.util.Collection;

@SuppressWarnings("all")
public class PojoAllocationStorage /* extends /* PojoClass<Allocation> */  */{
  public PojoAllocationStorage(final /* Allocation */Object pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    return "com.palladio_simulator.protocom.framework.AbstractAllocationStorage";
  }
  
  public String packageName() {
    return "ProtoComBootstrap";
  }
  
  public String compilationUnitName() {
    return "AllocationStorage";
  }
  
  public Collection<? extends IJMethod> methods() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method resourceContainer_AllocationContext is undefined for the type PojoAllocationStorage"
      + "\nThe method resourceContainer_AllocationContext is undefined for the type PojoAllocationStorage"
      + "\nThe method assemblyContext_AllocationContext is undefined for the type PojoAllocationStorage"
      + "\nThe method assemblyContext_AllocationContext is undefined for the type PojoAllocationStorage"
      + "\nallocationContexts_Allocation cannot be resolved"
      + "\nid cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\nencapsulatedComponent__AssemblyContext cannot be resolved"
      + "\nid cannot be resolved");
  }
  
  public String filePath() {
    return "ProtoComBootstrap/AllocationStorage.java";
  }
}
