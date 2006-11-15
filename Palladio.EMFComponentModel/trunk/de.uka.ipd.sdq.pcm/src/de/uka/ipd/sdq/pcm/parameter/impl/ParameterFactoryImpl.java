/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import de.uka.ipd.sdq.pcm.parameter.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParameterFactoryImpl extends EFactoryImpl implements ParameterFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParameterFactory init() {
		try {
			ParameterFactory theParameterFactory = (ParameterFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/1.0"); 
			if (theParameterFactory != null) {
				return theParameterFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ParameterFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ParameterPackage.PARAMETER_CHARACTERISATION: return createParameterCharacterisation();
			case ParameterPackage.COMPOSITE_PARAMETER_USAGE: return createCompositeParameterUsage();
			case ParameterPackage.COLLECTION_PARAMETER_USAGE: return createCollectionParameterUsage();
			case ParameterPackage.COLLECTION_PARAMETER_CHARACTERISATION: return createCollectionParameterCharacterisation();
			case ParameterPackage.PRIMITIVE_PARAMETER_USAGE: return createPrimitiveParameterUsage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ParameterPackage.PARAMETER_CHARACTERISATION_TYPE:
				return createParameterCharacterisationTypeFromString(eDataType, initialValue);
			case ParameterPackage.COLLECTION_PARAMETER_CHARACTERISATION_TYPE:
				return createCollectionParameterCharacterisationTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ParameterPackage.PARAMETER_CHARACTERISATION_TYPE:
				return convertParameterCharacterisationTypeToString(eDataType, instanceValue);
			case ParameterPackage.COLLECTION_PARAMETER_CHARACTERISATION_TYPE:
				return convertCollectionParameterCharacterisationTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterCharacterisation createParameterCharacterisation() {
		ParameterCharacterisationImpl parameterCharacterisation = new ParameterCharacterisationImpl();
		return parameterCharacterisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeParameterUsage createCompositeParameterUsage() {
		CompositeParameterUsageImpl compositeParameterUsage = new CompositeParameterUsageImpl();
		return compositeParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionParameterUsage createCollectionParameterUsage() {
		CollectionParameterUsageImpl collectionParameterUsage = new CollectionParameterUsageImpl();
		return collectionParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionParameterCharacterisation createCollectionParameterCharacterisation() {
		CollectionParameterCharacterisationImpl collectionParameterCharacterisation = new CollectionParameterCharacterisationImpl();
		return collectionParameterCharacterisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveParameterUsage createPrimitiveParameterUsage() {
		PrimitiveParameterUsageImpl primitiveParameterUsage = new PrimitiveParameterUsageImpl();
		return primitiveParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterCharacterisationType createParameterCharacterisationTypeFromString(EDataType eDataType, String initialValue) {
		ParameterCharacterisationType result = ParameterCharacterisationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParameterCharacterisationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionParameterCharacterisationType createCollectionParameterCharacterisationTypeFromString(EDataType eDataType, String initialValue) {
		CollectionParameterCharacterisationType result = CollectionParameterCharacterisationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionParameterCharacterisationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterPackage getParameterPackage() {
		return (ParameterPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ParameterPackage getPackage() {
		return ParameterPackage.eINSTANCE;
	}

} //ParameterFactoryImpl
