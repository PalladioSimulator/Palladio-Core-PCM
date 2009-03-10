/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.util;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentEndpoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeComponent;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.EndPoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Entity;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.FirstClassEntity;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.InterfacePort;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Message;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.NamedEntity;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Parameter;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Port;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveComponent;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Type;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage
 * @generated
 */
public class StaticStructureValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final StaticStructureValidator INSTANCE = new StaticStructureValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "eu.qimpress.commonmodel.commonmodel.StaticStructure";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inner Components Of Composite Components Can Not Be Services Again' of 'Composite Structure'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPOSITE_STRUCTURE__INNER_COMPONENTS_OF_COMPOSITE_COMPONENTS_CAN_NOT_BE_SERVICES_AGAIN = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Only Services On Top Level' of 'Service Architecture Model'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE_ARCHITECTURE_MODEL__ONLY_SERVICES_ON_TOP_LEVEL = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticStructureValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return StaticStructurePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case StaticStructurePackage.COMPOSITE_STRUCTURE:
				return validateCompositeStructure((CompositeStructure)value, diagnostics, context);
			case StaticStructurePackage.COMPONENT_TYPE:
				return validateComponentType((ComponentType)value, diagnostics, context);
			case StaticStructurePackage.NAMED_ENTITY:
				return validateNamedEntity((NamedEntity)value, diagnostics, context);
			case StaticStructurePackage.ENTITY:
				return validateEntity((Entity)value, diagnostics, context);
			case StaticStructurePackage.PORT:
				return validatePort((Port)value, diagnostics, context);
			case StaticStructurePackage.OPERATION:
				return validateOperation((Operation)value, diagnostics, context);
			case StaticStructurePackage.MESSAGE:
				return validateMessage((Message)value, diagnostics, context);
			case StaticStructurePackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case StaticStructurePackage.TYPE:
				return validateType((Type)value, diagnostics, context);
			case StaticStructurePackage.EXCEPTION:
				return validateException((eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception)value, diagnostics, context);
			case StaticStructurePackage.SUBCOMPONENT_INSTANCE:
				return validateSubcomponentInstance((SubcomponentInstance)value, diagnostics, context);
			case StaticStructurePackage.CONNECTOR:
				return validateConnector((Connector)value, diagnostics, context);
			case StaticStructurePackage.END_POINT:
				return validateEndPoint((EndPoint)value, diagnostics, context);
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL:
				return validateServiceArchitectureModel((ServiceArchitectureModel)value, diagnostics, context);
			case StaticStructurePackage.INTERFACE:
				return validateInterface((Interface)value, diagnostics, context);
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT:
				return validateSubcomponentEndpoint((SubcomponentEndpoint)value, diagnostics, context);
			case StaticStructurePackage.REPOSITORY:
				return validateRepository((Repository)value, diagnostics, context);
			case StaticStructurePackage.COMPONENT_ENDPOINT:
				return validateComponentEndpoint((ComponentEndpoint)value, diagnostics, context);
			case StaticStructurePackage.PRIMITIVE_DATA_TYPE:
				return validatePrimitiveDataType((PrimitiveDataType)value, diagnostics, context);
			case StaticStructurePackage.COMPLEX_DATA_TYPE:
				return validateComplexDataType((ComplexDataType)value, diagnostics, context);
			case StaticStructurePackage.INNER_ELEMENT:
				return validateInnerElement((InnerElement)value, diagnostics, context);
			case StaticStructurePackage.COMPOSITE_COMPONENT:
				return validateCompositeComponent((CompositeComponent)value, diagnostics, context);
			case StaticStructurePackage.PRIMITIVE_COMPONENT:
				return validatePrimitiveComponent((PrimitiveComponent)value, diagnostics, context);
			case StaticStructurePackage.EVENT_PORT:
				return validateEventPort((EventPort)value, diagnostics, context);
			case StaticStructurePackage.INTERFACE_PORT:
				return validateInterfacePort((InterfacePort)value, diagnostics, context);
			case StaticStructurePackage.COLLECTION_DATA_TYPE:
				return validateCollectionDataType((CollectionDataType)value, diagnostics, context);
			case StaticStructurePackage.FIRST_CLASS_ENTITY:
				return validateFirstClassEntity((FirstClassEntity)value, diagnostics, context);
			case StaticStructurePackage.XSD_PRIMITIVE_DATA_TYPES:
				return validateXSDPrimitiveDataTypes((XSDPrimitiveDataTypes)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeStructure(CompositeStructure compositeStructure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(compositeStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(compositeStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(compositeStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(compositeStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(compositeStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(compositeStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(compositeStructure, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompositeStructure_InnerComponentsOfCompositeComponentsCanNotBeServicesAgain(compositeStructure, diagnostics, context);
		return result;
	}

	/**
	 * Validates the InnerComponentsOfCompositeComponentsCanNotBeServicesAgain constraint of '<em>Composite Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeStructure_InnerComponentsOfCompositeComponentsCanNotBeServicesAgain(CompositeStructure compositeStructure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return compositeStructure.InnerComponentsOfCompositeComponentsCanNotBeServicesAgain(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentType(ComponentType componentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedEntity(NamedEntity namedEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedEntity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(entity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(port, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(operation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage(Message message, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(message, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(type, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateException(eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception exception, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exception, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubcomponentInstance(SubcomponentInstance subcomponentInstance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subcomponentInstance, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector(Connector connector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndPoint(EndPoint endPoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(endPoint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceArchitectureModel(ServiceArchitectureModel serviceArchitectureModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(serviceArchitectureModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(serviceArchitectureModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(serviceArchitectureModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(serviceArchitectureModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(serviceArchitectureModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(serviceArchitectureModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(serviceArchitectureModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompositeStructure_InnerComponentsOfCompositeComponentsCanNotBeServicesAgain(serviceArchitectureModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateServiceArchitectureModel_OnlyServicesOnTopLevel(serviceArchitectureModel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the OnlyServicesOnTopLevel constraint of '<em>Service Architecture Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceArchitectureModel_OnlyServicesOnTopLevel(ServiceArchitectureModel serviceArchitectureModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return serviceArchitectureModel.OnlyServicesOnTopLevel(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterface(Interface interface_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interface_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubcomponentEndpoint(SubcomponentEndpoint subcomponentEndpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subcomponentEndpoint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository(Repository repository, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(repository, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentEndpoint(ComponentEndpoint componentEndpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentEndpoint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveDataType(PrimitiveDataType primitiveDataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(primitiveDataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComplexDataType(ComplexDataType complexDataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(complexDataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInnerElement(InnerElement innerElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(innerElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeComponent(CompositeComponent compositeComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompositeStructure_InnerComponentsOfCompositeComponentsCanNotBeServicesAgain(compositeComponent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveComponent(PrimitiveComponent primitiveComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(primitiveComponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventPort(EventPort eventPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterfacePort(InterfacePort interfacePort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interfacePort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionDataType(CollectionDataType collectionDataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(collectionDataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFirstClassEntity(FirstClassEntity firstClassEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(firstClassEntity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateXSDPrimitiveDataTypes(XSDPrimitiveDataTypes xsdPrimitiveDataTypes, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //StaticStructureValidator
