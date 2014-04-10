package org.palladiosimulator.protocom.lang.java;

import org.palladiosimulator.protocom.lang.ICompilationUnit;

@SuppressWarnings("all")
public interface IJeeGlassfishEjbDescriptor extends ICompilationUnit {
  public abstract String ejbName();
  
  public abstract String ejbRefName();
  
  public abstract String jndiName();
}
