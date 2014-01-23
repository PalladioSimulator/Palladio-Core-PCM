package org.palladiosimulator.protocom.lang.java;

import org.palladiosimulator.protocom.lang.ICompilationUnit;

@SuppressWarnings("all")
public interface IJeeEjbDescriptor extends ICompilationUnit {
  public abstract String displayName();
  
  public abstract String ejbClientJar();
}
