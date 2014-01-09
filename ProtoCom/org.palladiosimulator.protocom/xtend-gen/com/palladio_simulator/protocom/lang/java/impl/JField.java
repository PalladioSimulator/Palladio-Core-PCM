package com.palladio_simulator.protocom.lang.java.impl;

import com.google.common.base.Objects;
import com.palladio_simulator.protocom.lang.java.IJField;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Class representing a field in Java.
 * 
 * This is a data class. Since methods are not a compilation unit, they do not
 * inherit GeneratedFile.
 * 
 * TODO: Change class to @Data
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class JField implements IJField {
  private String name;
  
  private String type;
  
  private String visibility;
  
  public String name() {
    return this.name;
  }
  
  public String type() {
    return this.type;
  }
  
  public String visibility() {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.visibility, null));
      if (_notEquals) {
        _builder.append(this.visibility, "");
      } else {
        _builder.append("protected");
      }
    }
    return _builder.toString();
  }
  
  public JField withName(final String name) {
    JField _xblockexpression = null;
    {
      this.name = name;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public JField withType(final String type) {
    JField _xblockexpression = null;
    {
      this.type = type;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public JField withModifierVisibility(final String visibility) {
    JField _xblockexpression = null;
    {
      this.visibility = visibility;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
}
