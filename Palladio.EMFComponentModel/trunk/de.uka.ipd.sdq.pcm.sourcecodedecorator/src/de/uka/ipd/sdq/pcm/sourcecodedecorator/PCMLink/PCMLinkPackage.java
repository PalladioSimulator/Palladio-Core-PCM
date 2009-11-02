/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkFactory
 * @model kind="package"
 * @generated
 */
public interface PCMLinkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PCMLink";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///SourceCodeDecorator/PCMLink.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SourceCodeDecorator.PCMLink";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PCMLinkPackage eINSTANCE = de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ComponentFileLinkImpl <em>Component File Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ComponentFileLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl#getComponentFileLink()
	 * @generated
	 */
	int COMPONENT_FILE_LINK = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FILE_LINK__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Filelevelsourcecodelink</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FILE_LINK__FILELEVELSOURCECODELINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Repositorycomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FILE_LINK__REPOSITORYCOMPONENT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component File Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FILE_LINK_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.SEFFMethodLinkImpl <em>SEFF Method Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.SEFFMethodLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl#getSEFFMethodLink()
	 * @generated
	 */
	int SEFF_METHOD_LINK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEFF_METHOD_LINK__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Methodlevelsourcecodelink</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEFF_METHOD_LINK__METHODLEVELSOURCECODELINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Serviceeffectspecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEFF_METHOD_LINK__SERVICEEFFECTSPECIFICATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SEFF Method Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEFF_METHOD_LINK_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ActionControlFlowLinkImpl <em>Action Control Flow Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ActionControlFlowLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl#getActionControlFlowLink()
	 * @generated
	 */
	int ACTION_CONTROL_FLOW_LINK = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CONTROL_FLOW_LINK__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Controlflowlevelsourcecodelink</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CONTROL_FLOW_LINK__CONTROLFLOWLEVELSOURCECODELINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstractaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CONTROL_FLOW_LINK__ABSTRACTACTION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Action Control Flow Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CONTROL_FLOW_LINK_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkRepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl#getPCMLinkRepository()
	 * @generated
	 */
	int PCM_LINK_REPOSITORY = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Componentfilelink</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY__COMPONENTFILELINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Seffmethodlink</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY__SEFFMETHODLINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actioncontrolflowlink</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logging Position Ids</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink <em>Component File Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component File Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink
	 * @generated
	 */
	EClass getComponentFileLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink#getFilelevelsourcecodelink <em>Filelevelsourcecodelink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Filelevelsourcecodelink</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink#getFilelevelsourcecodelink()
	 * @see #getComponentFileLink()
	 * @generated
	 */
	EReference getComponentFileLink_Filelevelsourcecodelink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink#getRepositorycomponent <em>Repositorycomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Repositorycomponent</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink#getRepositorycomponent()
	 * @see #getComponentFileLink()
	 * @generated
	 */
	EReference getComponentFileLink_Repositorycomponent();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink <em>SEFF Method Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SEFF Method Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink
	 * @generated
	 */
	EClass getSEFFMethodLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink#getMethodlevelsourcecodelink <em>Methodlevelsourcecodelink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Methodlevelsourcecodelink</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink#getMethodlevelsourcecodelink()
	 * @see #getSEFFMethodLink()
	 * @generated
	 */
	EReference getSEFFMethodLink_Methodlevelsourcecodelink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink#getServiceeffectspecification <em>Serviceeffectspecification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Serviceeffectspecification</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink#getServiceeffectspecification()
	 * @see #getSEFFMethodLink()
	 * @generated
	 */
	EReference getSEFFMethodLink_Serviceeffectspecification();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink <em>Action Control Flow Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Control Flow Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink
	 * @generated
	 */
	EClass getActionControlFlowLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink#getControlflowlevelsourcecodelink <em>Controlflowlevelsourcecodelink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Controlflowlevelsourcecodelink</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink#getControlflowlevelsourcecodelink()
	 * @see #getActionControlFlowLink()
	 * @generated
	 */
	EReference getActionControlFlowLink_Controlflowlevelsourcecodelink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink#getAbstractaction <em>Abstractaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Abstractaction</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink#getAbstractaction()
	 * @see #getActionControlFlowLink()
	 * @generated
	 */
	EReference getActionControlFlowLink_Abstractaction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository
	 * @generated
	 */
	EClass getPCMLinkRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getComponentfilelink <em>Componentfilelink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Componentfilelink</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getComponentfilelink()
	 * @see #getPCMLinkRepository()
	 * @generated
	 */
	EReference getPCMLinkRepository_Componentfilelink();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getSeffmethodlink <em>Seffmethodlink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Seffmethodlink</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getSeffmethodlink()
	 * @see #getPCMLinkRepository()
	 * @generated
	 */
	EReference getPCMLinkRepository_Seffmethodlink();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getActioncontrolflowlink <em>Actioncontrolflowlink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actioncontrolflowlink</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getActioncontrolflowlink()
	 * @see #getPCMLinkRepository()
	 * @generated
	 */
	EReference getPCMLinkRepository_Actioncontrolflowlink();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getLoggingPositionIds <em>Logging Position Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Logging Position Ids</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getLoggingPositionIds()
	 * @see #getPCMLinkRepository()
	 * @generated
	 */
	EReference getPCMLinkRepository_LoggingPositionIds();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PCMLinkFactory getPCMLinkFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ComponentFileLinkImpl <em>Component File Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ComponentFileLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl#getComponentFileLink()
		 * @generated
		 */
		EClass COMPONENT_FILE_LINK = eINSTANCE.getComponentFileLink();

		/**
		 * The meta object literal for the '<em><b>Filelevelsourcecodelink</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_FILE_LINK__FILELEVELSOURCECODELINK = eINSTANCE.getComponentFileLink_Filelevelsourcecodelink();

		/**
		 * The meta object literal for the '<em><b>Repositorycomponent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_FILE_LINK__REPOSITORYCOMPONENT = eINSTANCE.getComponentFileLink_Repositorycomponent();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.SEFFMethodLinkImpl <em>SEFF Method Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.SEFFMethodLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl#getSEFFMethodLink()
		 * @generated
		 */
		EClass SEFF_METHOD_LINK = eINSTANCE.getSEFFMethodLink();

		/**
		 * The meta object literal for the '<em><b>Methodlevelsourcecodelink</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEFF_METHOD_LINK__METHODLEVELSOURCECODELINK = eINSTANCE.getSEFFMethodLink_Methodlevelsourcecodelink();

		/**
		 * The meta object literal for the '<em><b>Serviceeffectspecification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEFF_METHOD_LINK__SERVICEEFFECTSPECIFICATION = eINSTANCE.getSEFFMethodLink_Serviceeffectspecification();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ActionControlFlowLinkImpl <em>Action Control Flow Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ActionControlFlowLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl#getActionControlFlowLink()
		 * @generated
		 */
		EClass ACTION_CONTROL_FLOW_LINK = eINSTANCE.getActionControlFlowLink();

		/**
		 * The meta object literal for the '<em><b>Controlflowlevelsourcecodelink</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_CONTROL_FLOW_LINK__CONTROLFLOWLEVELSOURCECODELINK = eINSTANCE.getActionControlFlowLink_Controlflowlevelsourcecodelink();

		/**
		 * The meta object literal for the '<em><b>Abstractaction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_CONTROL_FLOW_LINK__ABSTRACTACTION = eINSTANCE.getActionControlFlowLink_Abstractaction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkRepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkRepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl#getPCMLinkRepository()
		 * @generated
		 */
		EClass PCM_LINK_REPOSITORY = eINSTANCE.getPCMLinkRepository();

		/**
		 * The meta object literal for the '<em><b>Componentfilelink</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_LINK_REPOSITORY__COMPONENTFILELINK = eINSTANCE.getPCMLinkRepository_Componentfilelink();

		/**
		 * The meta object literal for the '<em><b>Seffmethodlink</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_LINK_REPOSITORY__SEFFMETHODLINK = eINSTANCE.getPCMLinkRepository_Seffmethodlink();

		/**
		 * The meta object literal for the '<em><b>Actioncontrolflowlink</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK = eINSTANCE.getPCMLinkRepository_Actioncontrolflowlink();

		/**
		 * The meta object literal for the '<em><b>Logging Position Ids</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS = eINSTANCE.getPCMLinkRepository_LoggingPositionIds();

	}

} //PCMLinkPackage
