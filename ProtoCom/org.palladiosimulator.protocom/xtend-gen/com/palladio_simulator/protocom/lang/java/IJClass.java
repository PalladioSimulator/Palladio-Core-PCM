package com.palladio_simulator.protocom.lang.java;

import com.palladio_simulator.protocom.lang.java.IJCompilationUnit;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import java.util.Collection;

@SuppressWarnings("all")
public interface IJClass extends IJCompilationUnit {
  /**
   * Inherited class name.
   */
  public abstract String superClass();
  
  /**
   * Constructors of this class.
   * 
   * FIXME: JMethod is ok'ish, but not entirely correct.
   */
  public abstract Collection<? extends IJMethod> constructors();
}
