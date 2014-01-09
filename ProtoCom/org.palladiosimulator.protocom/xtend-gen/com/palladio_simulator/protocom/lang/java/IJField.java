package com.palladio_simulator.protocom.lang.java;

@SuppressWarnings("all")
public interface IJField {
  /**
   * The name of the field.
   */
  public abstract String name();
  
  /**
   * Type of the field.
   */
  public abstract String type();
  
  /**
   * The visibility modifier of this field.
   * 
   * Default value is PROTECTED.
   */
  public abstract String visibility();
}
