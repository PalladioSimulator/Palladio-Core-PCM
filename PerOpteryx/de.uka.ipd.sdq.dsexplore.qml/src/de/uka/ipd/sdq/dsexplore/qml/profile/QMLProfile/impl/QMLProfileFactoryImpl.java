/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.*;

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
public class QMLProfileFactoryImpl extends EFactoryImpl implements QMLProfileFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QMLProfileFactory init() {
		try {
			QMLProfileFactory theQMLProfileFactory = (QMLProfileFactory)EPackage.Registry.INSTANCE.getEFactory("http:///QMLProfile.ecore"); 
			if (theQMLProfileFactory != null) {
				return theQMLProfileFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QMLProfileFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLProfileFactoryImpl() {
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
			case QMLProfilePackage.SIMPLE_QML_PROFILE: return createSimpleQMLProfile();
			case QMLProfilePackage.REFINED_QML_PROFILE: return createRefinedQMLProfile();
			case QMLProfilePackage.USAGE_SCENARIO_REQUIREMENT: return createUsageScenarioRequirement();
			case QMLProfilePackage.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT: return createEntryLevelSystemCallRequirement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleQMLProfile createSimpleQMLProfile() {
		SimpleQMLProfileImpl simpleQMLProfile = new SimpleQMLProfileImpl();
		return simpleQMLProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefinedQMLProfile createRefinedQMLProfile() {
		RefinedQMLProfileImpl refinedQMLProfile = new RefinedQMLProfileImpl();
		return refinedQMLProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageScenarioRequirement createUsageScenarioRequirement() {
		UsageScenarioRequirementImpl usageScenarioRequirement = new UsageScenarioRequirementImpl();
		return usageScenarioRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCallRequirement createEntryLevelSystemCallRequirement() {
		EntryLevelSystemCallRequirementImpl entryLevelSystemCallRequirement = new EntryLevelSystemCallRequirementImpl();
		return entryLevelSystemCallRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLProfilePackage getQMLProfilePackage() {
		return (QMLProfilePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QMLProfilePackage getPackage() {
		return QMLProfilePackage.eINSTANCE;
	}

} //QMLProfileFactoryImpl
