package org.palladiosimulator.protocom.lang.xml.impl;

import java.util.Collection;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.xml.IJeeGlassfishEjbDescriptor;

@SuppressWarnings("all")
public class JeeGlassfishEjbDescriptor extends GeneratedFile<IJeeGlassfishEjbDescriptor> implements IJeeGlassfishEjbDescriptor {
  public CharSequence header() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!DOCTYPE glassfish-ejb-jar PUBLIC \"-//GlassFish.org//DTD GlassFish Application Server 3.1 EJB 3.1//EN\" \"http://glassfish.org/dtds/glassfish-ejb-jar_3_1-1.dtd\">");
    return _builder;
  }
  
  public CharSequence body() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<glassfish-ejb-jar>");
    _builder.newLine();
    {
      Collection<String> _ejbRefName = this.ejbRefName();
      boolean _isEmpty = _ejbRefName.isEmpty();
      if (_isEmpty) {
        _builder.append("<enterprise-beans/>");
        _builder.newLine();
      } else {
        {
          Collection<String> _ejbRefName_1 = this.ejbRefName();
          for(final String r : _ejbRefName_1) {
            _builder.append("<enterprise-beans>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("<ejb>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("<ejb-name>");
            String _ejbName = this.ejbName();
            _builder.append(_ejbName, "\t\t");
            _builder.append("</ejb-name>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("<ejb-ref>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("<ejb-ref-name>");
            _builder.append(r, "\t\t\t");
            _builder.append("</ejb-ref-name>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("<jndi-name>corbaname:iiop:ipAddress#java:global/");
            String _jndiName = this.jndiName();
            _builder.append(_jndiName, "\t\t\t");
            _builder.append("</jndi-name>");
            _builder.newLineIfNotEmpty();
            _builder.append("       ");
            _builder.append("</ejb-ref>");
            _builder.newLine();
            _builder.append("     ");
            _builder.append("</ejb>");
            _builder.newLine();
            _builder.append("</enterprise-beans>");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("</glassfish-ejb-jar>");
    return _builder;
  }
  
  public String ejbName() {
    return this.provider.ejbName();
  }
  
  public Collection<String> ejbRefName() {
    return this.provider.ejbRefName();
  }
  
  public String jndiName() {
    return this.provider.jndiName();
  }
  
  public String generate() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _header = this.header();
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    CharSequence _body = this.body();
    _builder.append(_body, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String displayName() {
    return this.provider.displayName();
  }
}
