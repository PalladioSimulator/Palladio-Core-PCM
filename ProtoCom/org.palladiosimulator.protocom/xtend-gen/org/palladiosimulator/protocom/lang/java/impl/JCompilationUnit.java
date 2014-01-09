package org.palladiosimulator.protocom.lang.java.impl;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.java.IJCompilationUnit;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;

@SuppressWarnings("all")
public abstract class JCompilationUnit<E extends IJCompilationUnit> extends GeneratedFile<E> implements IJCompilationUnit {
  public String packageName() {
    String _packageName = this.provider.packageName();
    return _packageName;
  }
  
  public String compilationUnitName() {
    String _compilationUnitName = this.provider.compilationUnitName();
    return _compilationUnitName;
  }
  
  public Collection<String> interfaces() {
    Collection<String> _xblockexpression = null;
    {
      final Collection<String> i = this.provider.interfaces();
      Collection<String> _xifexpression = null;
      boolean _notEquals = (!Objects.equal(i, null));
      if (_notEquals) {
        _xifexpression = i;
      } else {
        _xifexpression = Collections.<String>unmodifiableList(Lists.<String>newArrayList());
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public Collection<? extends IJMethod> methods() {
    Collection<? extends IJMethod> _xblockexpression = null;
    {
      final Collection<? extends IJMethod> m = this.provider.methods();
      Collection<? extends IJMethod> _xifexpression = null;
      boolean _notEquals = (!Objects.equal(m, null));
      if (_notEquals) {
        _xifexpression = m;
      } else {
        _xifexpression = Collections.<IJMethod>unmodifiableList(Lists.<IJMethod>newArrayList());
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public Collection<? extends IJField> fields() {
    Collection<? extends IJField> _xblockexpression = null;
    {
      final Collection<? extends IJField> f = this.provider.fields();
      Collection<? extends IJField> _xifexpression = null;
      boolean _notEquals = (!Objects.equal(f, null));
      if (_notEquals) {
        _xifexpression = f;
      } else {
        _xifexpression = Collections.<IJField>unmodifiableList(Lists.<IJField>newArrayList());
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String generate() {
    StringConcatenation _builder = new StringConcatenation();
    String _header = this.header();
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    _builder.append("{\t");
    _builder.newLine();
    _builder.append("\t");
    String _body = this.body();
    _builder.append(_body, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public CharSequence implementedClasses() {
    StringConcatenation _builder = new StringConcatenation();
    {
      Collection<String> _interfaces = this.interfaces();
      boolean _hasElements = false;
      for(final String implInterface : _interfaces) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append(" implements ", "");
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append(implInterface, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * Template for the header part of this compilation unit: package, imports, type definition.
   */
  public abstract String header();
  
  /**
   * Template for the body part of this compilation unit: members, methods/signatures.
   */
  public abstract String body();
}
