package com.palladio_simulator.protocom.lang.java.impl;

import com.google.common.base.Objects;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Class representing a Java method.
 * 
 * This is a data class. Since methods are not a compilation unit, they do not
 * inherit GeneratedFile.
 * 
 * A JMethod without name should be handled as a constructor.
 * 
 * TODO: Change class to @Data ?
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class JMethod implements IJMethod {
  private String returnType;
  
  private String name;
  
  private String parameters;
  
  private String implementation;
  
  private String throwsType;
  
  private String visibility;
  
  private boolean isStatic;
  
  public JMethod() {
  }
  
  public String returnType() {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.returnType, null));
      if (_notEquals) {
        _builder.append(this.returnType, "");
      } else {
        _builder.append("void");
      }
    }
    return _builder.toString();
  }
  
  public String name() {
    return this.name;
  }
  
  public String parameters() {
    return this.parameters;
  }
  
  public String visibilityModifier() {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.visibility, null));
      if (_notEquals) {
        _builder.append(this.visibility, "");
      } else {
        _builder.append("public");
      }
    }
    return _builder.toString();
  }
  
  public String throwsType() {
    return this.throwsType;
  }
  
  public String staticModifier() {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (this.isStatic) {
        _builder.append("static");
      }
    }
    return _builder.toString();
  }
  
  public String body() {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.implementation, null));
      if (_notEquals) {
        _builder.append(this.implementation, "");
      } else {
      }
    }
    return _builder.toString();
  }
  
  public JMethod withReturnType(final String returnType) {
    JMethod _xblockexpression = null;
    {
      this.returnType = returnType;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public JMethod withName(final String name) {
    JMethod _xblockexpression = null;
    {
      this.name = name;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public JMethod withParameters(final String parameters) {
    JMethod _xblockexpression = null;
    {
      this.parameters = parameters;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public JMethod withImplementation(final String implementation) {
    JMethod _xblockexpression = null;
    {
      this.implementation = implementation;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public JMethod withVisibilityModifier(final String visibility) {
    JMethod _xblockexpression = null;
    {
      this.visibility = visibility;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public JMethod withStaticModifier() {
    JMethod _xblockexpression = null;
    {
      this.isStatic = true;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public JMethod withThrows(final String throwsType) {
    JMethod _xblockexpression = null;
    {
      this.throwsType = throwsType;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
}
