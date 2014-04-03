package org.palladiosimulator.protocom.lang.java.util;

import com.google.common.base.Objects;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
  
  public static String javaName(final Entity e) {
    String _entityName = e.getEntityName();
    String _replaceAll = _entityName.replaceAll("\"", "_");
    String _replaceAll_1 = _replaceAll.replaceAll(" ", "_");
    String _replaceAll_2 = _replaceAll_1.replaceAll("<", "_");
    String _replaceAll_3 = _replaceAll_2.replaceAll(">", "_");
    String _replaceAll_4 = _replaceAll_3.replaceAll(":", "_");
    String _replaceAll_5 = _replaceAll_4.replaceAll("\\.", "_");
    String _replaceAll_6 = _replaceAll_5.replaceAll("\\,", "_");
    String _replaceAll_7 = _replaceAll_6.replaceAll("\\+", "_");
    String _replaceAll_8 = _replaceAll_7.replaceAll("-", "_");
    String _replaceAll_9 = _replaceAll_8.replaceAll("\\(", "_");
    return _replaceAll_9.replaceAll("\\)", "_");
  }
  
  public static String javaString(final String s) {
    String _replaceAll = s.replaceAll("\"", "\\\\\"");
    String _replaceAll_1 = _replaceAll.replaceAll(" ", "_");
    String _replaceAll_2 = _replaceAll_1.replaceAll("<", "_");
    String _replaceAll_3 = _replaceAll_2.replaceAll(">", "_");
    String _replaceAll_4 = _replaceAll_3.replaceAll(":", "_");
    return _replaceAll_4.replaceAll("\\.", "_");
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
    return _replaceAll_9.replaceAll("\\)", "_");
  }
  
  public static String specificationString(final String s) {
    String _replaceAll = s.replaceAll("\"", "\\\\\"");
    return JavaNames.removeAllSpecialChars(_replaceAll);
  }
  
  public static String javaSignature(final OperationSignature s) {
    String _entityName = s.getEntityName();
    int _posInInterface = JavaNames.posInInterface(s, 0);
    return (_entityName + Integer.valueOf(_posInInterface));
  }
  
  public static int posInInterface(final OperationSignature s, final int pos) {
    int _xifexpression = (int) 0;
    OperationInterface _interface__OperationSignature = s.getInterface__OperationSignature();
    EList<OperationSignature> _signatures__OperationInterface = _interface__OperationSignature.getSignatures__OperationInterface();
    OperationSignature _get = _signatures__OperationInterface.get(pos);
    boolean _equals = Objects.equal(_get, s);
    if (_equals) {
      _xifexpression = pos;
    } else {
      _xifexpression = JavaNames.posInInterface(s, (pos + 1));
    }
    return _xifexpression;
  }
  
  public static String javaSignature(final InfrastructureSignature s) {
    String _entityName = s.getEntityName();
    int _posInInterface = JavaNames.posInInterface(s, 0);
    return (_entityName + Integer.valueOf(_posInInterface));
  }
  
  public static int posInInterface(final InfrastructureSignature s, final int pos) {
    int _xifexpression = (int) 0;
    InfrastructureInterface _infrastructureInterface__InfrastructureSignature = s.getInfrastructureInterface__InfrastructureSignature();
    EList<InfrastructureSignature> _infrastructureSignatures__InfrastructureInterface = _infrastructureInterface__InfrastructureSignature.getInfrastructureSignatures__InfrastructureInterface();
    InfrastructureSignature _get = _infrastructureSignatures__InfrastructureInterface.get(pos);
    boolean _equals = Objects.equal(_get, s);
    if (_equals) {
      _xifexpression = pos;
    } else {
      _xifexpression = JavaNames.posInInterface(s, (pos + 1));
    }
    return _xifexpression;
  }
  
  protected static String _portClassName(final OperationProvidedRole r) {
    OperationInterface _providedInterface__OperationProvidedRole = r.getProvidedInterface__OperationProvidedRole();
    String _javaName = JavaNames.javaName(_providedInterface__OperationProvidedRole);
    String _plus = (_javaName + "_");
    InterfaceProvidingEntity _providingEntity_ProvidedRole = r.getProvidingEntity_ProvidedRole();
    String _javaName_1 = JavaNames.javaName(_providingEntity_ProvidedRole);
    return (_plus + _javaName_1);
  }
  
  protected static String _portClassName(final InfrastructureProvidedRole r) {
    InfrastructureInterface _providedInterface__InfrastructureProvidedRole = r.getProvidedInterface__InfrastructureProvidedRole();
    String _javaName = JavaNames.javaName(_providedInterface__InfrastructureProvidedRole);
    String _plus = (_javaName + "_");
    InterfaceProvidingEntity _providingEntity_ProvidedRole = r.getProvidingEntity_ProvidedRole();
    String _javaName_1 = JavaNames.javaName(_providingEntity_ProvidedRole);
    return (_plus + _javaName_1);
  }
  
  /**
   * TODO Implement SinkRole?
   */
  protected static String _portClassName(final SinkRole r) {
    return "FIXME";
  }
  
  public static String contextClassName(final InterfaceRequiringEntity c) {
    String _javaName = JavaNames.javaName(c);
    return (_javaName + "Context");
  }
  
  public static String contextInterfaceName(final InterfaceRequiringEntity c) {
    String _javaName = JavaNames.javaName(c);
    String _plus = ("I" + _javaName);
    return (_plus + "Context");
  }
  
  public static String portMemberVar(final OperationProvidedRole r) {
    String _javaName = JavaNames.javaName(r);
    return ("m_port" + _javaName);
  }
  
  public static String portMemberVar(final InfrastructureProvidedRole r) {
    String _javaName = JavaNames.javaName(r);
    return ("m_port" + _javaName);
  }
  
  protected static String _portGetter(final OperationProvidedRole r) {
    String _javaName = JavaNames.javaName(r);
    return ("getPort" + _javaName);
  }
  
  protected static String _portGetter(final InfrastructureProvidedRole r) {
    String _javaName = JavaNames.javaName(r);
    return ("getPort" + _javaName);
  }
  
  public static String basePackageName(final Entity s) {
    String _javaName = JavaNames.javaName(s);
    return _javaName.toLowerCase();
  }
  
  protected static String _implementationPackage(final OperationInterface i) {
    Repository _repository__Interface = i.getRepository__Interface();
    return JavaNames.basePackageName(_repository__Interface);
  }
  
  protected static String _implementationPackage(final InfrastructureInterface i) {
    Repository _repository__Interface = i.getRepository__Interface();
    return JavaNames.basePackageName(_repository__Interface);
  }
  
  protected static String _implementationPackage(final de.uka.ipd.sdq.pcm.system.System s) {
    String _basePackageName = JavaNames.basePackageName(s);
    return (_basePackageName + ".impl");
  }
  
  protected static String _implementationPackage(final UsageScenario u) {
    String _basePackageName = JavaNames.basePackageName(u);
    return (_basePackageName + ".impl");
  }
  
  protected static String _implementationPackage(final RepositoryComponent c) {
    Repository _repository__RepositoryComponent = c.getRepository__RepositoryComponent();
    String _basePackageName = JavaNames.basePackageName(_repository__RepositoryComponent);
    return (_basePackageName + ".impl");
  }
  
  protected static String _implementationPackage(final FailureType ft) {
    Repository _repository__FailureType = ft.getRepository__FailureType();
    String _basePackageName = JavaNames.basePackageName(_repository__FailureType);
    return (_basePackageName + ".exceptions");
  }
  
  protected static String _implementationPackage(final PrimitiveDataType dt) {
    Repository _repository__DataType = dt.getRepository__DataType();
    String _basePackageName = JavaNames.basePackageName(_repository__DataType);
    return (_basePackageName + ".datatypes");
  }
  
  protected static String _implementationPackage(final CollectionDataType dt) {
    Repository _repository__DataType = dt.getRepository__DataType();
    String _basePackageName = JavaNames.basePackageName(_repository__DataType);
    return (_basePackageName + ".datatypes");
  }
  
  protected static String _implementationPackage(final CompositeDataType dt) {
    Repository _repository__DataType = dt.getRepository__DataType();
    String _basePackageName = JavaNames.basePackageName(_repository__DataType);
    return (_basePackageName + ".datatypes");
  }
  
  public static String className(final ComposedStructure s) {
    return JavaNames.javaName(s);
  }
  
  public static String fqnAllocationContextPackage(final Allocation a) {
    de.uka.ipd.sdq.pcm.system.System _system_Allocation = a.getSystem_Allocation();
    String _implementationPackage = JavaNames.implementationPackage(_system_Allocation);
    return (_implementationPackage + ".allocation");
  }
  
  public static String fqnAllocationContextClass(final Allocation a) {
    String _javaName = JavaNames.javaName(a);
    return (_javaName + "RuntimeContext");
  }
  
  public static String fqnAllocationContext(final Allocation a) {
    String _fqnAllocationContextPackage = JavaNames.fqnAllocationContextPackage(a);
    String _plus = (_fqnAllocationContextPackage + ".");
    String _fqnAllocationContextClass = JavaNames.fqnAllocationContextClass(a);
    return (_plus + _fqnAllocationContextClass);
  }
  
  protected static String _fqn(final OperationInterface i) {
    String _implementationPackage = JavaNames.implementationPackage(i);
    String _plus = (_implementationPackage + ".");
    String _javaName = JavaNames.javaName(i);
    return (_plus + _javaName);
  }
  
  protected static String _fqn(final InfrastructureInterface i) {
    String _implementationPackage = JavaNames.implementationPackage(i);
    String _plus = (_implementationPackage + ".");
    String _javaName = JavaNames.javaName(i);
    return (_plus + _javaName);
  }
  
  protected static String _fqn(final RepositoryComponent c) {
    String _implementationPackage = JavaNames.implementationPackage(c);
    String _plus = (_implementationPackage + ".");
    String _javaName = JavaNames.javaName(c);
    return (_plus + _javaName);
  }
  
  protected static String _fqn(final de.uka.ipd.sdq.pcm.system.System s) {
    String _implementationPackage = JavaNames.implementationPackage(s);
    String _plus = (_implementationPackage + ".");
    String _javaName = JavaNames.javaName(s);
    return (_plus + _javaName);
  }
  
  protected static String _fqn(final UsageScenario us) {
    String _implementationPackage = JavaNames.implementationPackage(us);
    String _plus = (_implementationPackage + ".");
    String _javaName = JavaNames.javaName(us);
    return (_plus + _javaName);
  }
  
  public static String fqnContextPackage(final Entity c) {
    String _implementationPackage = JavaNames.implementationPackage(c);
    return (_implementationPackage + ".contexts");
  }
  
  public static String fqnContext(final InterfaceRequiringEntity c) {
    String _fqnContextPackage = JavaNames.fqnContextPackage(c);
    String _plus = (_fqnContextPackage + ".");
    String _contextClassName = JavaNames.contextClassName(c);
    return (_plus + _contextClassName);
  }
  
  public static String fqnContextInterface(final InterfaceRequiringEntity c) {
    String _fqnContextPackage = JavaNames.fqnContextPackage(c);
    String _plus = (_fqnContextPackage + ".I");
    String _contextClassName = JavaNames.contextClassName(c);
    return (_plus + _contextClassName);
  }
  
  protected static String _fqnPortPackage(final OperationProvidedRole pr) {
    InterfaceProvidingEntity _providingEntity_ProvidedRole = pr.getProvidingEntity_ProvidedRole();
    String _implementationPackage = JavaNames.implementationPackage(_providingEntity_ProvidedRole);
    return (_implementationPackage + ".ports");
  }
  
  protected static String _fqnPortPackage(final InfrastructureProvidedRole pr) {
    InterfaceProvidingEntity _providingEntity_ProvidedRole = pr.getProvidingEntity_ProvidedRole();
    String _implementationPackage = JavaNames.implementationPackage(_providingEntity_ProvidedRole);
    return (_implementationPackage + ".ports");
  }
  
  /**
   * TODO Implement SinkRoles?
   */
  protected static String _fqnPortPackage(final SinkRole pr) {
    return "FIXME";
  }
  
  public static String fqnPort(final OperationProvidedRole pr) {
    InterfaceProvidingEntity _providingEntity_ProvidedRole = pr.getProvidingEntity_ProvidedRole();
    String _implementationPackage = JavaNames.implementationPackage(_providingEntity_ProvidedRole);
    String _plus = (_implementationPackage + ".ports.");
    String _portClassName = JavaNames.portClassName(pr);
    return (_plus + _portClassName);
  }
  
  public static String fqnPort(final InfrastructureProvidedRole pr) {
    InterfaceProvidingEntity _providingEntity_ProvidedRole = pr.getProvidingEntity_ProvidedRole();
    String _implementationPackage = JavaNames.implementationPackage(_providingEntity_ProvidedRole);
    String _plus = (_implementationPackage + ".ports.");
    String _portClassName = JavaNames.portClassName(pr);
    return (_plus + _portClassName);
  }
  
  public static String beanName(final RepositoryComponent c) {
    String _javaName = JavaNames.javaName(c);
    return (_javaName + "Bean");
  }
  
  public static String fqnInterface(final InterfaceProvidingEntity c) {
    String _implementationPackage = JavaNames.implementationPackage(c);
    String _plus = (_implementationPackage + ".I");
    String _javaName = JavaNames.javaName(c);
    return (_plus + _javaName);
  }
  
  public static String interfaceName(final InterfaceProvidingEntity c) {
    String _javaName = JavaNames.javaName(c);
    return ("I" + _javaName);
  }
  
  public static String dummyComponentName(final OperationRequiredRole rr) {
    OperationInterface _requiredInterface__OperationRequiredRole = rr.getRequiredInterface__OperationRequiredRole();
    String _javaName = JavaNames.javaName(_requiredInterface__OperationRequiredRole);
    return (_javaName + "Dummy");
  }
  
  public static String dummyComponentName(final InfrastructureRequiredRole rr) {
    InfrastructureInterface _requiredInterface__InfrastructureRequiredRole = rr.getRequiredInterface__InfrastructureRequiredRole();
    String _javaName = JavaNames.javaName(_requiredInterface__InfrastructureRequiredRole);
    return (_javaName + "Dummy");
  }
  
  public static String fqnDummyComponentPackage(final OperationRequiredRole rr) {
    return "dummies";
  }
  
  public static String fqnDummyComponentPackage(final InfrastructureRequiredRole rr) {
    return "dummies";
  }
  
  public static String fqnDummyComponent(final OperationRequiredRole rr) {
    String _fqnDummyComponentPackage = JavaNames.fqnDummyComponentPackage(rr);
    String _plus = (_fqnDummyComponentPackage + ".");
    String _dummyComponentName = JavaNames.dummyComponentName(rr);
    return (_plus + _dummyComponentName);
  }
  
  public static String fqnDummyComponent(final InfrastructureRequiredRole rr) {
    String _fqnDummyComponentPackage = JavaNames.fqnDummyComponentPackage(rr);
    String _plus = (_fqnDummyComponentPackage + ".");
    String _dummyComponentName = JavaNames.dummyComponentName(rr);
    return (_plus + _dummyComponentName);
  }
  
  public static String fqnToDirectoryPath(final String fqn) {
    return fqn.replaceAll("\\.", "/");
  }
  
  public static String getFileName(final Entity e) {
    String _implementationPackage = JavaNames.implementationPackage(e);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_implementationPackage);
    String _plus = (_fqnToDirectoryPath + "/");
    String _javaName = JavaNames.javaName(e);
    String _plus_1 = (_plus + _javaName);
    return (_plus_1 + ".java");
  }
  
  public static String getFilePath(final Entity e) {
    String _implementationPackage = JavaNames.implementationPackage(e);
    String _fqnToDirectoryPath = JavaNames.fqnToDirectoryPath(_implementationPackage);
    return (_fqnToDirectoryPath + "/");
  }
  
  protected static String _serviceName(final OperationSignature s) {
    OperationInterface _interface__OperationSignature = s.getInterface__OperationSignature();
    String _javaName = JavaNames.javaName(_interface__OperationSignature);
    String _firstLower = StringExtensions.toFirstLower(_javaName);
    String _plus = (_firstLower + "_");
    String _javaSignature = JavaNames.javaSignature(s);
    return (_plus + _javaSignature);
  }
  
  protected static String _serviceName(final InfrastructureSignature s) {
    InfrastructureInterface _infrastructureInterface__InfrastructureSignature = s.getInfrastructureInterface__InfrastructureSignature();
    String _javaName = JavaNames.javaName(_infrastructureInterface__InfrastructureSignature);
    String _firstLower = StringExtensions.toFirstLower(_javaName);
    String _plus = (_firstLower + "_");
    String _javaSignature = JavaNames.javaSignature(s);
    return (_plus + _javaSignature);
  }
  
  /**
   * TODO Implement EventTypes?
   */
  protected static String _serviceName(final EventType s) {
    return "FIXME";
  }
  
  protected static String _serviceNameStub(final OperationSignature s) {
    OperationInterface _interface__OperationSignature = s.getInterface__OperationSignature();
    String _javaName = JavaNames.javaName(_interface__OperationSignature);
    String _firstLower = StringExtensions.toFirstLower(_javaName);
    String _plus = (_firstLower + "_");
    String _javaName_1 = JavaNames.javaName(s);
    return (_plus + _javaName_1);
  }
  
  protected static String _serviceNameStub(final InfrastructureSignature s) {
    InfrastructureInterface _infrastructureInterface__InfrastructureSignature = s.getInfrastructureInterface__InfrastructureSignature();
    String _javaName = JavaNames.javaName(_infrastructureInterface__InfrastructureSignature);
    String _firstLower = StringExtensions.toFirstLower(_javaName);
    String _plus = (_firstLower + "_");
    String _javaName_1 = JavaNames.javaName(s);
    return (_plus + _javaName_1);
  }
  
  /**
   * TODO Implement EventTypes?
   */
  protected static String _serviceNameStub(final EventType s) {
    return "FIXME";
  }
  
  public static String externalCallActionDescription(final OperationSignature os, final Object call) {
    OperationInterface _interface__OperationSignature = os.getInterface__OperationSignature();
    String _entityName = _interface__OperationSignature.getEntityName();
    String _plus = ("Call " + _entityName);
    String _plus_1 = (_plus + ".");
    String _javaSignature = JavaNames.javaSignature(os);
    String _plus_2 = (_plus_1 + _javaSignature);
    String _plus_3 = (_plus_2 + " <Component: ");
    BasicComponent _findContainerComponent = JavaNames.findContainerComponent(((EObject) call));
    String _entityName_1 = _findContainerComponent.getEntityName();
    String _plus_4 = (_plus_3 + _entityName_1);
    String _plus_5 = (_plus_4 + 
      ", AssemblyCtx: \"+this.assemblyContextID+\", CallID: ");
    String _id = ((ExternalCallAction) call).getId();
    String _plus_6 = (_plus_5 + _id);
    return (_plus_6 + ">");
  }
  
  public static String internalActionDescription(final InfrastructureSignature os, final Object call) {
    InfrastructureInterface _infrastructureInterface__InfrastructureSignature = os.getInfrastructureInterface__InfrastructureSignature();
    String _entityName = _infrastructureInterface__InfrastructureSignature.getEntityName();
    String _plus = ("Call " + _entityName);
    String _plus_1 = (_plus + ".");
    String _javaSignature = JavaNames.javaSignature(os);
    String _plus_2 = (_plus_1 + _javaSignature);
    String _plus_3 = (_plus_2 + 
      " <Component: ");
    BasicComponent _findContainerComponent = JavaNames.findContainerComponent(((EObject) call));
    String _entityName_1 = _findContainerComponent.getEntityName();
    String _plus_4 = (_plus_3 + _entityName_1);
    String _plus_5 = (_plus_4 + 
      ", AssemblyCtx: \"+this.assemblyContextID+\", CallID: ");
    String _id = ((InternalAction) call).getId();
    String _plus_6 = (_plus_5 + _id);
    return (_plus_6 + ">");
  }
  
  public static String entryLevelSystemCallActionDescription(final OperationSignature os, final Object call) {
    String _javaSignature = JavaNames.javaSignature(os);
    String _plus = ("Call_" + _javaSignature);
    String _plus_1 = (_plus + " <EntryLevelSystemCall id: ");
    String _id = ((Entity) call).getId();
    String _plus_2 = (_plus_1 + _id);
    return (_plus_2 + " >");
  }
  
  public static String entryLevelSystemCallActionDescription(final InfrastructureSignature os, final Object call) {
    String _javaSignature = JavaNames.javaSignature(os);
    String _plus = ("Call_" + _javaSignature);
    String _plus_1 = (_plus + " <EntryLevelSystemCall id: ");
    String _id = ((Entity) call).getId();
    String _plus_2 = (_plus_1 + _id);
    return (_plus_2 + " >");
  }
  
  public static String seffDescription(final OperationSignature os, final RepositoryComponent component) {
    OperationInterface _interface__OperationSignature = os.getInterface__OperationSignature();
    String _entityName = _interface__OperationSignature.getEntityName();
    String _plus = ("SEFF " + _entityName);
    String _plus_1 = (_plus + ".");
    String _javaSignature = JavaNames.javaSignature(os);
    String _plus_2 = (_plus_1 + _javaSignature);
    String _plus_3 = (_plus_2 + " <Component: ");
    String _entityName_1 = component.getEntityName();
    String _plus_4 = (_plus_3 + _entityName_1);
    return (_plus_4 + ", AssemblyCtx: \"+this.assemblyContextID+\">");
  }
  
  public static String seffDescription(final InfrastructureSignature os, final RepositoryComponent component) {
    InfrastructureInterface _infrastructureInterface__InfrastructureSignature = os.getInfrastructureInterface__InfrastructureSignature();
    String _entityName = _infrastructureInterface__InfrastructureSignature.getEntityName();
    String _plus = ("SEFF " + _entityName);
    String _plus_1 = (_plus + ".");
    String _javaSignature = JavaNames.javaSignature(os);
    String _plus_2 = (_plus_1 + _javaSignature);
    String _plus_3 = (_plus_2 + 
      " <Component: ");
    String _entityName_1 = component.getEntityName();
    String _plus_4 = (_plus_3 + _entityName_1);
    return (_plus_4 + ", AssemblyCtx: \"+this.assemblyContextID+\">");
  }
  
  public static BasicComponent findContainerComponent(final EObject o) {
    BasicComponent _xifexpression = null;
    boolean _isInstance = BasicComponent.class.isInstance(o);
    if (_isInstance) {
      _xifexpression = ((BasicComponent) o);
    } else {
      EObject _eContainer = o.eContainer();
      _xifexpression = JavaNames.findContainerComponent(_eContainer);
    }
    return _xifexpression;
  }
  
  public static String portClassName(final ProvidedRole r) {
    if (r instanceof InfrastructureProvidedRole) {
      return _portClassName((InfrastructureProvidedRole)r);
    } else if (r instanceof OperationProvidedRole) {
      return _portClassName((OperationProvidedRole)r);
    } else if (r instanceof SinkRole) {
      return _portClassName((SinkRole)r);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(r).toString());
    }
  }
  
  public static String portGetter(final ProvidedRole r) {
    if (r instanceof InfrastructureProvidedRole) {
      return _portGetter((InfrastructureProvidedRole)r);
    } else if (r instanceof OperationProvidedRole) {
      return _portGetter((OperationProvidedRole)r);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(r).toString());
    }
  }
  
  public static String implementationPackage(final EObject s) {
    if (s instanceof de.uka.ipd.sdq.pcm.system.System) {
      return _implementationPackage((de.uka.ipd.sdq.pcm.system.System)s);
    } else if (s instanceof RepositoryComponent) {
      return _implementationPackage((RepositoryComponent)s);
    } else if (s instanceof InfrastructureInterface) {
      return _implementationPackage((InfrastructureInterface)s);
    } else if (s instanceof OperationInterface) {
      return _implementationPackage((OperationInterface)s);
    } else if (s instanceof FailureType) {
      return _implementationPackage((FailureType)s);
    } else if (s instanceof CollectionDataType) {
      return _implementationPackage((CollectionDataType)s);
    } else if (s instanceof CompositeDataType) {
      return _implementationPackage((CompositeDataType)s);
    } else if (s instanceof UsageScenario) {
      return _implementationPackage((UsageScenario)s);
    } else if (s instanceof PrimitiveDataType) {
      return _implementationPackage((PrimitiveDataType)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public static String fqn(final EObject s) {
    if (s instanceof de.uka.ipd.sdq.pcm.system.System) {
      return _fqn((de.uka.ipd.sdq.pcm.system.System)s);
    } else if (s instanceof RepositoryComponent) {
      return _fqn((RepositoryComponent)s);
    } else if (s instanceof InfrastructureInterface) {
      return _fqn((InfrastructureInterface)s);
    } else if (s instanceof OperationInterface) {
      return _fqn((OperationInterface)s);
    } else if (s instanceof UsageScenario) {
      return _fqn((UsageScenario)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public static String fqnPortPackage(final ProvidedRole pr) {
    if (pr instanceof InfrastructureProvidedRole) {
      return _fqnPortPackage((InfrastructureProvidedRole)pr);
    } else if (pr instanceof OperationProvidedRole) {
      return _fqnPortPackage((OperationProvidedRole)pr);
    } else if (pr instanceof SinkRole) {
      return _fqnPortPackage((SinkRole)pr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(pr).toString());
    }
  }
  
  public static String serviceName(final Signature s) {
    if (s instanceof EventType) {
      return _serviceName((EventType)s);
    } else if (s instanceof InfrastructureSignature) {
      return _serviceName((InfrastructureSignature)s);
    } else if (s instanceof OperationSignature) {
      return _serviceName((OperationSignature)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public static String serviceNameStub(final Signature s) {
    if (s instanceof EventType) {
      return _serviceNameStub((EventType)s);
    } else if (s instanceof InfrastructureSignature) {
      return _serviceNameStub((InfrastructureSignature)s);
    } else if (s instanceof OperationSignature) {
      return _serviceNameStub((OperationSignature)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
}
