package com.palladio_simulator.protocom.lang.java.util;

import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;

/**
 * 1:1 copy from the old JavaNames xtend1 extension.
 * Ugly as hell, but whatever works.
 * 
 * @author Totally not Thomas Zolynski. I swear!
 * 
 * FIXME: clean up, refactor location, burn evidence of this mess.
 */
@SuppressWarnings("all")
public class JavaNames {
  public static String removeAllSpecialChars(final String s) {
    String _replace = s.replace("\n", " ");
    String _replace_1 = _replace.replace("\t", " ");
    return _replace_1.replace("\r", " ");
  }
  
  public static String javaName(final /* Entity */Object e) {
    throw new Error("Unresolved compilation problems:"
      + "\nentityName cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved"
      + "\nreplaceAll cannot be resolved");
  }
  
  public static String javaString(final String s) {
    String _replaceAll = s.replaceAll("\"", "\\\\\"");
    String _replaceAll_1 = _replaceAll.replaceAll(" ", "_");
    String _replaceAll_2 = _replaceAll_1.replaceAll("<", "_");
    String _replaceAll_3 = _replaceAll_2.replaceAll(">", "_");
    String _replaceAll_4 = _replaceAll_3.replaceAll(":", "_");
    String _replaceAll_5 = _replaceAll_4.replaceAll("\\.", "_");
    return _replaceAll_5;
  }
  
  public static String javaVariableName(final String s) {
    String _replaceAll = s.replaceAll("\"", "_");
    String _replaceAll_1 = _replaceAll.replaceAll(" ", "_");
    String _replaceAll_2 = _replaceAll_1.replaceAll("<", "_");
    String _replaceAll_3 = _replaceAll_2.replaceAll(">", "_");
    String _replaceAll_4 = _replaceAll_3.replaceAll(":", "_");
    String _replaceAll_5 = _replaceAll_4.replaceAll("\\.", "_");
    String _replaceAll_6 = _replaceAll_5.replaceAll("\\,", "_");
    String _replaceAll_7 = _replaceAll_6.replaceAll("\\+", "_");
    String _replaceAll_8 = _replaceAll_7.replaceAll("-", "__");
    String _replaceAll_9 = _replaceAll_8.replaceAll("\\(", "_");
    String _replaceAll_10 = _replaceAll_9.replaceAll("\\)", "_");
    return _replaceAll_10;
  }
  
  public static String specificationString(final String s) {
    String _replaceAll = s.replaceAll("\"", "\\\\\"");
    String _removeAllSpecialChars = JavaNames.removeAllSpecialChars(_replaceAll);
    return _removeAllSpecialChars;
  }
  
  public static String javaSignature(final /* OperationSignature */Object s) {
    throw new Error("Unresolved compilation problems:"
      + "\nentityName cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nposInInterface cannot be resolved");
  }
  
  public static int posInInterface(final /* OperationSignature */Object s, final int pos) {
    throw new Error("Unresolved compilation problems:"
      + "\ninterface__OperationSignature cannot be resolved"
      + "\nsignatures__OperationInterface cannot be resolved"
      + "\nget cannot be resolved"
      + "\n== cannot be resolved"
      + "\nposInInterface cannot be resolved");
  }
  
  public static String javaSignature(final /* InfrastructureSignature */Object s) {
    throw new Error("Unresolved compilation problems:"
      + "\nentityName cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nposInInterface cannot be resolved");
  }
  
  public static int posInInterface(final /* InfrastructureSignature */Object s, final int pos) {
    throw new Error("Unresolved compilation problems:"
      + "\ninfrastructureInterface__InfrastructureSignature cannot be resolved"
      + "\ninfrastructureSignatures__InfrastructureInterface cannot be resolved"
      + "\nget cannot be resolved"
      + "\n== cannot be resolved"
      + "\nposInInterface cannot be resolved");
  }
  
  protected static Object _portClassName(final /* OperationProvidedRole */Object r) {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidedInterface__OperationProvidedRole cannot be resolved"
      + "\njavaName cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\njavaName cannot be resolved");
  }
  
  protected static Object _portClassName(final /* InfrastructureProvidedRole */Object r) {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidedInterface__InfrastructureProvidedRole cannot be resolved"
      + "\njavaName cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\njavaName cannot be resolved");
  }
  
  public static Object contextClassName(final /* InterfaceRequiringEntity */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static String contextInterfaceName(final /* InterfaceRequiringEntity */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved");
  }
  
  public static String portMemberVar(final /* OperationProvidedRole */Object r) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved");
  }
  
  public static String portMemberVar(final /* InfrastructureProvidedRole */Object r) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved");
  }
  
  protected static String _portGetter(final /* OperationProvidedRole */Object r) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved");
  }
  
  protected static String _portGetter(final /* InfrastructureProvidedRole */Object r) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved");
  }
  
  public static Object basePackageName(final /* Entity */Object s) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved"
      + "\ntoLowerCase cannot be resolved");
  }
  
  protected static Object _implementationPackage(final /* OperationInterface */Object i) {
    throw new Error("Unresolved compilation problems:"
      + "\nrepository__Interface cannot be resolved"
      + "\nbasePackageName cannot be resolved");
  }
  
  protected static Object _implementationPackage(final /* InfrastructureInterface */Object i) {
    throw new Error("Unresolved compilation problems:"
      + "\nrepository__Interface cannot be resolved"
      + "\nbasePackageName cannot be resolved");
  }
  
  protected static Object _implementationPackage(final System s) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method basePackageName is undefined for the type JavaNames"
      + "\n+ cannot be resolved");
  }
  
  protected static Object _implementationPackage(final /* UsageScenario */Object u) {
    throw new Error("Unresolved compilation problems:"
      + "\nbasePackageName cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  protected static Object _implementationPackage(final /* RepositoryComponent */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\nrepository__RepositoryComponent cannot be resolved"
      + "\nbasePackageName cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  protected static Object _implementationPackage(final /* FailureType */Object ft) {
    throw new Error("Unresolved compilation problems:"
      + "\nrepository__FailureType cannot be resolved"
      + "\nbasePackageName cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static Object className(final /* ComposedStructure */Object s) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved");
  }
  
  public static Object fqnAllocationContextPackage(final /* Allocation */Object a) {
    throw new Error("Unresolved compilation problems:"
      + "\nsystem_Allocation cannot be resolved"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static Object fqnAllocationContextClass(final /* Allocation */Object a) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static Object fqnAllocationContext(final /* Allocation */Object a) {
    throw new Error("Unresolved compilation problems:"
      + "\nfqnAllocationContextPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nfqnAllocationContextClass cannot be resolved");
  }
  
  protected static Object _fqn(final /* OperationInterface */Object i) {
    throw new Error("Unresolved compilation problems:"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\njavaName cannot be resolved");
  }
  
  protected static Object _fqn(final /* InfrastructureInterface */Object i) {
    throw new Error("Unresolved compilation problems:"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\njavaName cannot be resolved");
  }
  
  protected static Object _fqn(final /* RepositoryComponent */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\njavaName cannot be resolved");
  }
  
  protected static Object _fqn(final System s) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method javaName is undefined for the type JavaNames"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  protected static Object _fqn(final /* UsageScenario */Object us) {
    throw new Error("Unresolved compilation problems:"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\njavaName cannot be resolved");
  }
  
  public static Object fqnContextPackage(final /* Entity */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static Object fqnContext(final /* InterfaceRequiringEntity */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\nfqnContextPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ncontextClassName cannot be resolved");
  }
  
  public static Object fqnContextInterface(final /* InterfaceRequiringEntity */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\nfqnContextPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ncontextClassName cannot be resolved");
  }
  
  protected static Object _fqnPortPackage(final /* OperationProvidedRole */Object pr) {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  protected static Object _fqnPortPackage(final /* InfrastructureProvidedRole */Object pr) {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static Object fqnPort(final /* OperationProvidedRole */Object pr) {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nportClassName cannot be resolved");
  }
  
  public static Object fqnPort(final /* InfrastructureProvidedRole */Object pr) {
    throw new Error("Unresolved compilation problems:"
      + "\nprovidingEntity_ProvidedRole cannot be resolved"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nportClassName cannot be resolved");
  }
  
  public static Object beanName(final /* RepositoryComponent */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static Object fqnInterface(final /* InterfaceProvidingEntity */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\nimplementationPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\njavaName cannot be resolved");
  }
  
  public static String interfaceName(final /* InterfaceProvidingEntity */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\njavaName cannot be resolved");
  }
  
  public static Object dummyComponentName(final /* OperationRequiredRole */Object rr) {
    throw new Error("Unresolved compilation problems:"
      + "\nrequiredInterface__OperationRequiredRole cannot be resolved"
      + "\njavaName cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static Object dummyComponentName(final /* InfrastructureRequiredRole */Object rr) {
    throw new Error("Unresolved compilation problems:"
      + "\nrequiredInterface__InfrastructureRequiredRole cannot be resolved"
      + "\njavaName cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static String fqnDummyComponentPackage(final /* OperationRequiredRole */Object rr) {
    return "dummies";
  }
  
  public static String fqnDummyComponentPackage(final /* InfrastructureRequiredRole */Object rr) {
    return "dummies";
  }
  
  public static Object fqnDummyComponent(final /* OperationRequiredRole */Object rr) {
    throw new Error("Unresolved compilation problems:"
      + "\nfqnDummyComponentPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ndummyComponentName cannot be resolved");
  }
  
  public static Object fqnDummyComponent(final /* InfrastructureRequiredRole */Object rr) {
    throw new Error("Unresolved compilation problems:"
      + "\nfqnDummyComponentPackage cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ndummyComponentName cannot be resolved");
  }
  
  public static String fqnToDirectoryPath(final String fqn) {
    String _replaceAll = fqn.replaceAll("\\.", "/");
    return _replaceAll;
  }
  
  public static Object getFileName(final /* Entity */Object e) {
    throw new Error("Unresolved compilation problems:"
      + "\nimplementationPackage cannot be resolved"
      + "\nfqnToDirectoryPath cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\njavaName cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  protected static Object _serviceName(final /* OperationSignature */Object s) {
    throw new Error("Unresolved compilation problems:"
      + "\nAmbiguous feature call.\nThe methods\n\tjavaSignature(OperationSignature) in JavaNames and\n\tjavaSignature(InfrastructureSignature) in JavaNames\nboth match."
      + "\ninterface__OperationSignature cannot be resolved"
      + "\njavaName cannot be resolved"
      + "\ntoFirstLower cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  protected static Object _serviceName(final /* InfrastructureSignature */Object s) {
    throw new Error("Unresolved compilation problems:"
      + "\nAmbiguous feature call.\nThe methods\n\tjavaSignature(OperationSignature) in JavaNames and\n\tjavaSignature(InfrastructureSignature) in JavaNames\nboth match."
      + "\ninfrastructureInterface__InfrastructureSignature cannot be resolved"
      + "\njavaName cannot be resolved"
      + "\ntoFirstLower cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static String externalCallActionDescription(final /* OperationSignature */Object os, final Object call) {
    throw new Error("Unresolved compilation problems:"
      + "\nExternalCallAction cannot be resolved to a type."
      + "\ninterface__OperationSignature cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\njavaSignature cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\nid cannot be resolved");
  }
  
  public static String internalActionDescription(final /* InfrastructureSignature */Object os, final Object call) {
    throw new Error("Unresolved compilation problems:"
      + "\nInternalAction cannot be resolved to a type."
      + "\ninfrastructureInterface__InfrastructureSignature cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\njavaSignature cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\nid cannot be resolved");
  }
  
  public static String entryLevelSystemCallActionDescription(final /* OperationSignature */Object os, final Object call) {
    throw new Error("Unresolved compilation problems:"
      + "\nEntity cannot be resolved to a type."
      + "\njavaSignature cannot be resolved"
      + "\nid cannot be resolved");
  }
  
  public static String entryLevelSystemCallActionDescription(final /* InfrastructureSignature */Object os, final Object call) {
    throw new Error("Unresolved compilation problems:"
      + "\nEntity cannot be resolved to a type."
      + "\njavaSignature cannot be resolved"
      + "\nid cannot be resolved");
  }
  
  public static String seffDescription(final /* OperationSignature */Object os, final /* RepositoryComponent */Object component) {
    throw new Error("Unresolved compilation problems:"
      + "\ninterface__OperationSignature cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\njavaSignature cannot be resolved"
      + "\nentityName cannot be resolved");
  }
  
  public static String seffDescription(final /* InfrastructureSignature */Object os, final /* RepositoryComponent */Object component) {
    throw new Error("Unresolved compilation problems:"
      + "\ninfrastructureInterface__InfrastructureSignature cannot be resolved"
      + "\nentityName cannot be resolved"
      + "\njavaSignature cannot be resolved"
      + "\nentityName cannot be resolved");
  }
  
  public static /* BasicComponent */Object findContainerComponent(final EObject o) {
    throw new Error("Unresolved compilation problems:"
      + "\nBasicComponent cannot be resolved to a type."
      + "\nThe method or field BasicComponent is undefined for the type JavaNames"
      + "\nisInstance cannot be resolved");
  }
  
  public static Object portClassName(final OperationProvidedRole r) {
    if (r != null) {
      return _portClassName(r);
    } else if (r != null) {
      return _portClassName(r);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(r).toString());
    }
  }
  
  public static String portGetter(final OperationProvidedRole r) {
    if (r != null) {
      return _portGetter(r);
    } else if (r != null) {
      return _portGetter(r);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(r).toString());
    }
  }
  
  public static Object implementationPackage(final System s) {
    if (s != null) {
      return _implementationPackage(s);
    } else if (s != null) {
      return _implementationPackage(s);
    } else if (s != null) {
      return _implementationPackage(s);
    } else if (s != null) {
      return _implementationPackage(s);
    } else if (s != null) {
      return _implementationPackage(s);
    } else if (s != null) {
      return _implementationPackage(s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public static Object fqn(final System s) {
    if (s != null) {
      return _fqn(s);
    } else if (s != null) {
      return _fqn(s);
    } else if (s != null) {
      return _fqn(s);
    } else if (s != null) {
      return _fqn(s);
    } else if (s != null) {
      return _fqn(s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public static Object fqnPortPackage(final OperationProvidedRole pr) {
    if (pr != null) {
      return _fqnPortPackage(pr);
    } else if (pr != null) {
      return _fqnPortPackage(pr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(pr).toString());
    }
  }
  
  public static Object serviceName(final OperationSignature s) {
    if (s != null) {
      return _serviceName(s);
    } else if (s != null) {
      return _serviceName(s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
}
