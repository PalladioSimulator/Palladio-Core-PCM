package com.palladio_simulator.protocom.lang.java.util;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Common PCM stuff.
 * 
 * TODO: write something ingenious to justify this class here.
 */
@SuppressWarnings("all")
public class PcmCommons {
  public static String stackframeType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>");
    return _builder.toString();
  }
  
  public static String stackframeParameterList() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame");
    return _builder.toString();
  }
  
  public static String stackContextParameterList() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("de.uka.ipd.sdq.simucomframework.variables.StackContext ctx");
    return _builder.toString();
  }
  
  public static String stackContextClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("de.uka.ipd.sdq.simucomframework.variables.StackContext");
    return _builder.toString();
  }
  
  public static String stackContextParameterUsageList() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ctx");
    return _builder.toString();
  }
  
  public static String call(final /* OperationSignature */Object signature, final /* Entity */Object call, final String prefix, final /* List<VariableUsage> */Object parameterUsages, final /* List<VariableUsage> */Object outParameterUsages) {
    throw new Error("Unresolved compilation problems:"
      + "\nAmbiguous feature call.\nThe methods\n\tjavaSignature(OperationSignature) in JavaNames and\n\tjavaSignature(InfrastructureSignature) in JavaNames\nboth match.");
  }
  
  public static /* ProvidedDelegationConnector */Object getProvidedDelegationConnector(final /* ComposedStructure */Object s, final /* ProvidedRole */Object p) {
    throw new Error("Unresolved compilation problems:"
      + "\nProvidedDelegationConnector cannot be resolved to a type."
      + "\nProvidedDelegationConnector cannot be resolved to a type."
      + "\nThe method or field ProvidedDelegationConnector is undefined for the type PcmCommons"
      + "\nconnectors__ComposedStructure cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nouterProvidedRole_ProvidedDelegationConnector cannot be resolved"
      + "\n== cannot be resolved"
      + "\ntoList cannot be resolved"
      + "\nget cannot be resolved");
  }
  
  public static /* List<Connector> */Object getProvidedDelegationConnector(final /* ComposedStructure */Object s) {
    throw new Error("Unresolved compilation problems:"
      + "\nConnector cannot be resolved to a type."
      + "\nThe method or field ProvidedDelegationConnector is undefined for the type PcmCommons"
      + "\nconnectors__ComposedStructure cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\ntoList cannot be resolved");
  }
  
  public static /* RequiredDelegationConnector */Object getRequiredDelegationConnector(final /* ComposedStructure */Object s, final /* RequiredRole */Object p) {
    throw new Error("Unresolved compilation problems:"
      + "\nRequiredDelegationConnector cannot be resolved to a type."
      + "\nRequiredDelegationConnector cannot be resolved to a type."
      + "\nThe method or field RequiredDelegationConnector is undefined for the type PcmCommons"
      + "\nconnectors__ComposedStructure cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nouterRequiredRole_RequiredDelegationConnector cannot be resolved"
      + "\n== cannot be resolved"
      + "\ntoList cannot be resolved"
      + "\nget cannot be resolved");
  }
  
  public static /* List<Connector> */Object getRequiredDelegationConnector(final /* ComposedStructure */Object s) {
    throw new Error("Unresolved compilation problems:"
      + "\nConnector cannot be resolved to a type."
      + "\nThe method or field RequiredDelegationConnector is undefined for the type PcmCommons"
      + "\nconnectors__ComposedStructure cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nisInstance cannot be resolved"
      + "\ntoList cannot be resolved");
  }
  
  public static boolean hasConnector(final /* ComposedStructure */Object s, final /* AssemblyContext */Object ctx, final /* RequiredRole */Object r) {
    throw new Error("Unresolved compilation problems:"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nfilter cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public static Object getConnector(final /* ComposedStructure */Object s, final /* AssemblyContext */Object ctx, final /* RequiredRole */Object r) {
    throw new Error("Unresolved compilation problems:"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nfilter cannot be resolved"
      + "\nget cannot be resolved");
  }
}
