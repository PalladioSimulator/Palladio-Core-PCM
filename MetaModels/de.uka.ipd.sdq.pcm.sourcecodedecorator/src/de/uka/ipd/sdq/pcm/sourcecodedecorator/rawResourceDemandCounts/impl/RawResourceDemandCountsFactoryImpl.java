/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.*;

import org.eclipse.emf.ecore.EClass;
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
public class RawResourceDemandCountsFactoryImpl extends EFactoryImpl implements RawResourceDemandCountsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RawResourceDemandCountsFactory init() {
		try {
			RawResourceDemandCountsFactory theRawResourceDemandCountsFactory = (RawResourceDemandCountsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///SourceCodeDecorator/rawResourceDemandCounts.ecore"); 
			if (theRawResourceDemandCountsFactory != null) {
				return theRawResourceDemandCountsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RawResourceDemandCountsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawResourceDemandCountsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK: return createRawResourceDemandsLink();
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN: return createBytecodeMonitoringRun();
			case RawResourceDemandCountsPackage.PARAMETER_VALUE: return createParameterValue();
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY: return createRawResourceDemandsRepository();
			case RawResourceDemandCountsPackage.DOUBLE_CHARACTERISATION_VALUE: return createDoubleCharacterisationValue();
			case RawResourceDemandCountsPackage.LONG_CHARACTERISATION_VALUE: return createLongCharacterisationValue();
			case RawResourceDemandCountsPackage.BOOLEAN_CHARACTERISATION_VALUE: return createBooleanCharacterisationValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawResourceDemandsLink createRawResourceDemandsLink() {
		RawResourceDemandsLinkImpl rawResourceDemandsLink = new RawResourceDemandsLinkImpl();
		return rawResourceDemandsLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BytecodeMonitoringRun createBytecodeMonitoringRun() {
		BytecodeMonitoringRunImpl bytecodeMonitoringRun = new BytecodeMonitoringRunImpl();
		return bytecodeMonitoringRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterValue createParameterValue() {
		ParameterValueImpl parameterValue = new ParameterValueImpl();
		return parameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawResourceDemandsRepository createRawResourceDemandsRepository() {
		RawResourceDemandsRepositoryImpl rawResourceDemandsRepository = new RawResourceDemandsRepositoryImpl();
		return rawResourceDemandsRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleCharacterisationValue createDoubleCharacterisationValue() {
		DoubleCharacterisationValueImpl doubleCharacterisationValue = new DoubleCharacterisationValueImpl();
		return doubleCharacterisationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongCharacterisationValue createLongCharacterisationValue() {
		LongCharacterisationValueImpl longCharacterisationValue = new LongCharacterisationValueImpl();
		return longCharacterisationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanCharacterisationValue createBooleanCharacterisationValue() {
		BooleanCharacterisationValueImpl booleanCharacterisationValue = new BooleanCharacterisationValueImpl();
		return booleanCharacterisationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawResourceDemandCountsPackage getRawResourceDemandCountsPackage() {
		return (RawResourceDemandCountsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RawResourceDemandCountsPackage getPackage() {
		return RawResourceDemandCountsPackage.eINSTANCE;
	}

} //RawResourceDemandCountsFactoryImpl
