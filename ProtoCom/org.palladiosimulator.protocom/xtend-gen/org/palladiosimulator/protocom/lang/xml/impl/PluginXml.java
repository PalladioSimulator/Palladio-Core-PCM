package org.palladiosimulator.protocom.lang.xml.impl;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.GeneratedFile;
import org.palladiosimulator.protocom.lang.xml.IPluginXml;

@SuppressWarnings("all")
public class PluginXml extends GeneratedFile<IPluginXml> implements IPluginXml {
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
  
  public CharSequence header() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\'1.0\'?>");
    return _builder;
  }
  
  public CharSequence body() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("point=\"");
    String _extensionPoint = this.extensionPoint();
    _builder.append(_extensionPoint, "   ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("     ");
    _builder.append("<actionDelegate");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("class=\"");
    String _actionDelegateClass = this.actionDelegateClass();
    _builder.append(_actionDelegateClass, "        ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("id=\"");
    String _actionDelegateId = this.actionDelegateId();
    _builder.append(_actionDelegateId, "        ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("     ");
    _builder.append("</actionDelegate>");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("</plugin>");
    return _builder;
  }
  
  public String extensionPoint() {
    return this.provider.extensionPoint();
  }
  
  public String actionDelegateClass() {
    return this.provider.actionDelegateClass();
  }
  
  public String actionDelegateId() {
    return this.provider.actionDelegateId();
  }
}
