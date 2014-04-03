package org.palladiosimulator.protocom.lang.java.impl;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.java.IJeeGlassfishEjbDescriptor;

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
    _builder.append("    \t");
    _builder.append("<enterprise-beans>");
    _builder.newLine();
    _builder.append("       \t ");
    _builder.append("<ejb>");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("<ejb-name>");
    String _ejbName = this.ejbName();
    _builder.append(_ejbName, "        \t");
    _builder.append("</ejb-name>");
    _builder.newLineIfNotEmpty();
    _builder.append("        \t");
    _builder.append("<ejb-ref>");
    _builder.newLine();
    _builder.append("            \t");
    _builder.append("<ejb-ref-name>");
    String _ejbRefName = this.ejbRefName();
    _builder.append(_ejbRefName, "            \t");
    _builder.append("</ejb-ref-name>");
    _builder.newLineIfNotEmpty();
    _builder.append("           \t\t ");
    _builder.append("<jndi-name>");
    String _jndiName = this.jndiName();
    _builder.append(_jndiName, "           \t\t ");
    _builder.append("</jndi-name>");
    _builder.newLineIfNotEmpty();
    _builder.append("      \t\t ");
    _builder.append("</ejb-ref>");
    _builder.newLine();
    _builder.append("       \t ");
    _builder.append("</ejb>");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("</enterprise-beans>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</glassfish-ejb-jar>");
    return _builder;
  }
  
  public String ejbName() {
    return this.provider.ejbName();
  }
  
  public String ejbRefName() {
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
}
