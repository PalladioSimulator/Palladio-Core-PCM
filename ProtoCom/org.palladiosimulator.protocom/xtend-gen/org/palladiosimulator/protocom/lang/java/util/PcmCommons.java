package org.palladiosimulator.protocom.lang.java.util;

import com.google.common.base.Objects;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmCalls;

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
  
  public static String call(final OperationSignature signature, final Entity call, final String prefix, final List<VariableUsage> parameterUsages, final List<VariableUsage> outParameterUsages) {
    String _javaSignature = JavaNames.javaSignature(signature);
    String _plus = (prefix + _javaSignature);
    String _plus_1 = (_plus + "(");
    String _plus_2 = (_plus_1 + "ctx");
    String _plus_3 = (_plus_2 + ");");
    return _plus_3;
  }
  
  public static ProvidedDelegationConnector getProvidedDelegationConnector(final ComposedStructure s, final ProvidedRole p) {
    EList<Connector> _connectors__ComposedStructure = s.getConnectors__ComposedStructure();
    final Function1<Connector,Boolean> _function = new Function1<Connector,Boolean>() {
      public Boolean apply(final Connector it) {
        boolean _isInstance = ProvidedDelegationConnector.class.isInstance(it);
        return Boolean.valueOf(_isInstance);
      }
    };
    Iterable<Connector> _filter = IterableExtensions.<Connector>filter(_connectors__ComposedStructure, _function);
    final Function1<Connector,Boolean> _function_1 = new Function1<Connector,Boolean>() {
      public Boolean apply(final Connector it) {
        OperationProvidedRole _outerProvidedRole_ProvidedDelegationConnector = ((ProvidedDelegationConnector) it).getOuterProvidedRole_ProvidedDelegationConnector();
        boolean _equals = Objects.equal(_outerProvidedRole_ProvidedDelegationConnector, p);
        return Boolean.valueOf(_equals);
      }
    };
    Iterable<Connector> _filter_1 = IterableExtensions.<Connector>filter(_filter, _function_1);
    List<Connector> _list = IterableExtensions.<Connector>toList(_filter_1);
    Connector _get = _list.get(0);
    return ((ProvidedDelegationConnector) _get);
  }
  
  public static List<Connector> getProvidedDelegationConnector(final ComposedStructure s) {
    EList<Connector> _connectors__ComposedStructure = s.getConnectors__ComposedStructure();
    final Function1<Connector,Boolean> _function = new Function1<Connector,Boolean>() {
      public Boolean apply(final Connector it) {
        boolean _isInstance = ProvidedDelegationConnector.class.isInstance(it);
        return Boolean.valueOf(_isInstance);
      }
    };
    Iterable<Connector> _filter = IterableExtensions.<Connector>filter(_connectors__ComposedStructure, _function);
    List<Connector> _list = IterableExtensions.<Connector>toList(_filter);
    return ((List<Connector>) _list);
  }
  
  public static RequiredDelegationConnector getRequiredDelegationConnector(final ComposedStructure s, final RequiredRole p) {
    EList<Connector> _connectors__ComposedStructure = s.getConnectors__ComposedStructure();
    final Function1<Connector,Boolean> _function = new Function1<Connector,Boolean>() {
      public Boolean apply(final Connector it) {
        boolean _isInstance = RequiredDelegationConnector.class.isInstance(it);
        return Boolean.valueOf(_isInstance);
      }
    };
    Iterable<Connector> _filter = IterableExtensions.<Connector>filter(_connectors__ComposedStructure, _function);
    final Function1<Connector,Boolean> _function_1 = new Function1<Connector,Boolean>() {
      public Boolean apply(final Connector it) {
        OperationRequiredRole _outerRequiredRole_RequiredDelegationConnector = ((RequiredDelegationConnector) it).getOuterRequiredRole_RequiredDelegationConnector();
        boolean _equals = Objects.equal(_outerRequiredRole_RequiredDelegationConnector, p);
        return Boolean.valueOf(_equals);
      }
    };
    Iterable<Connector> _filter_1 = IterableExtensions.<Connector>filter(_filter, _function_1);
    List<Connector> _list = IterableExtensions.<Connector>toList(_filter_1);
    Connector _get = _list.get(0);
    return ((RequiredDelegationConnector) _get);
  }
  
  public static List<Connector> getRequiredDelegationConnector(final ComposedStructure s) {
    EList<Connector> _connectors__ComposedStructure = s.getConnectors__ComposedStructure();
    final Function1<Connector,Boolean> _function = new Function1<Connector,Boolean>() {
      public Boolean apply(final Connector it) {
        boolean _isInstance = RequiredDelegationConnector.class.isInstance(it);
        return Boolean.valueOf(_isInstance);
      }
    };
    Iterable<Connector> _filter = IterableExtensions.<Connector>filter(_connectors__ComposedStructure, _function);
    List<Connector> _list = IterableExtensions.<Connector>toList(_filter);
    return ((List<Connector>) _list);
  }
  
  public static boolean hasConnector(final ComposedStructure s, final AssemblyContext ctx, final RequiredRole r) {
    Iterable<Connector> _connectors = PcmCalls.connectors(s);
    final Function1<Connector,Boolean> _function = new Function1<Connector,Boolean>() {
      public Boolean apply(final Connector con) {
        boolean _test = PcmCalls.test(con, ctx, r);
        return Boolean.valueOf(_test);
      }
    };
    Iterable<Connector> _filter = IterableExtensions.<Connector>filter(_connectors, _function);
    int _size = IterableExtensions.size(_filter);
    boolean _equals = (_size == 1);
    return _equals;
  }
  
  public static Connector getConnector(final ComposedStructure s, final AssemblyContext ctx, final RequiredRole r) {
    Iterable<Connector> _connectors = PcmCalls.connectors(s);
    final Function1<Connector,Boolean> _function = new Function1<Connector,Boolean>() {
      public Boolean apply(final Connector con) {
        boolean _test = PcmCalls.test(con, ctx, r);
        return Boolean.valueOf(_test);
      }
    };
    Iterable<Connector> _filter = IterableExtensions.<Connector>filter(_connectors, _function);
    Connector _get = ((Connector[])Conversions.unwrapArray(_filter, Connector.class))[0];
    return _get;
  }
}
