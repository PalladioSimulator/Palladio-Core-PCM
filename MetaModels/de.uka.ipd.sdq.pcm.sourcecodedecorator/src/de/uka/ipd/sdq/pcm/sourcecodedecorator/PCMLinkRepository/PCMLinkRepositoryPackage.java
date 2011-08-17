/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * <!-- begin-model-doc -->
 * Repository Package for LoggerLink and GastPCMLink Packages. Contains the core root element of both other packages.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryFactory
 * @model kind="package"
 * @generated
 */
public interface PCMLinkRepositoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PCMLinkRepository";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///SourceCodeDecorator/PCMLinkRepository.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SourceCodeDecorator.PCMLinkRepository";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PCMLinkRepositoryPackage eINSTANCE = de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryImpl <em>PCM Link Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryPackageImpl#getPCMLinkRepository()
	 * @generated
	 */
	int PCM_LINK_REPOSITORY = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY__LOGGING_POSITION_LINKS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Internal Action Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY__INTERNAL_ACTION_LINKS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Parameter Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY__INPUT_PARAMETER_LINKS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>PCM Link Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_LINK_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository <em>PCM Link Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Link Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository
	 * @generated
	 */
	EClass getPCMLinkRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository#getLoggingPositionLinks <em>Logging Position Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Logging Position Links</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository#getLoggingPositionLinks()
	 * @see #getPCMLinkRepository()
	 * @generated
	 */
	EReference getPCMLinkRepository_LoggingPositionLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository#getInternalActionLinks <em>Internal Action Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Action Links</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository#getInternalActionLinks()
	 * @see #getPCMLinkRepository()
	 * @generated
	 */
	EReference getPCMLinkRepository_InternalActionLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository#getInputParameterLinks <em>Input Parameter Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Parameter Links</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository#getInputParameterLinks()
	 * @see #getPCMLinkRepository()
	 * @generated
	 */
	EReference getPCMLinkRepository_InputParameterLinks();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PCMLinkRepositoryFactory getPCMLinkRepositoryFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryImpl <em>PCM Link Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryPackageImpl#getPCMLinkRepository()
		 * @generated
		 */
		EClass PCM_LINK_REPOSITORY = eINSTANCE.getPCMLinkRepository();

		/**
		 * The meta object literal for the '<em><b>Logging Position Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_LINK_REPOSITORY__LOGGING_POSITION_LINKS = eINSTANCE.getPCMLinkRepository_LoggingPositionLinks();

		/**
		 * The meta object literal for the '<em><b>Internal Action Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_LINK_REPOSITORY__INTERNAL_ACTION_LINKS = eINSTANCE.getPCMLinkRepository_InternalActionLinks();

		/**
		 * The meta object literal for the '<em><b>Input Parameter Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_LINK_REPOSITORY__INPUT_PARAMETER_LINKS = eINSTANCE.getPCMLinkRepository_InputParameterLinks();

	}

} //PCMLinkRepositoryPackage
