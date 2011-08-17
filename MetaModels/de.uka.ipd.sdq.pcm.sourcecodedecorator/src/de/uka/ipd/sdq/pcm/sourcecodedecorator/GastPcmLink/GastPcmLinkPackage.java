/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink;

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
 * Trace link package for mapping&nbsp;GAST model elements and reverse engineered PCM model elements.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkFactory
 * @model kind="package"
 * @generated
 */
public interface GastPcmLinkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "GastPcmLink";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///SourceCodeDecorator/GastPcmLink.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SourceCodeDecorator.GastPcmLink";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GastPcmLinkPackage eINSTANCE = de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.GastPcmLinkPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.InternalActionLinkImpl <em>Internal Action Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.InternalActionLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.GastPcmLinkPackageImpl#getInternalActionLink()
	 * @generated
	 */
	int INTERNAL_ACTION_LINK = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION_LINK__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Linked Internal Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION_LINK__LINKED_INTERNAL_ACTION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Internal Action Statements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION_LINK__INTERNAL_ACTION_STATEMENTS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Internal Action Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION_LINK_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.ParameterLinkImpl <em>Parameter Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.ParameterLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.GastPcmLinkPackageImpl#getParameterLink()
	 * @generated
	 */
	int PARAMETER_LINK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LINK__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Linked Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LINK__LINKED_PARAMETER = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LINK__PARAMETER = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LINK_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink <em>Internal Action Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Action Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink
	 * @generated
	 */
	EClass getInternalActionLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink#getLinkedInternalAction <em>Linked Internal Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked Internal Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink#getLinkedInternalAction()
	 * @see #getInternalActionLink()
	 * @generated
	 */
	EReference getInternalActionLink_LinkedInternalAction();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink#getInternalActionStatements <em>Internal Action Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Internal Action Statements</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink#getInternalActionStatements()
	 * @see #getInternalActionLink()
	 * @generated
	 */
	EReference getInternalActionLink_InternalActionStatements();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink <em>Parameter Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink
	 * @generated
	 */
	EClass getParameterLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink#getLinkedParameter <em>Linked Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked Parameter</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink#getLinkedParameter()
	 * @see #getParameterLink()
	 * @generated
	 */
	EReference getParameterLink_LinkedParameter();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink#getParameter()
	 * @see #getParameterLink()
	 * @generated
	 */
	EReference getParameterLink_Parameter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GastPcmLinkFactory getGastPcmLinkFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.InternalActionLinkImpl <em>Internal Action Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.InternalActionLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.GastPcmLinkPackageImpl#getInternalActionLink()
		 * @generated
		 */
		EClass INTERNAL_ACTION_LINK = eINSTANCE.getInternalActionLink();

		/**
		 * The meta object literal for the '<em><b>Linked Internal Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_ACTION_LINK__LINKED_INTERNAL_ACTION = eINSTANCE.getInternalActionLink_LinkedInternalAction();

		/**
		 * The meta object literal for the '<em><b>Internal Action Statements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_ACTION_LINK__INTERNAL_ACTION_STATEMENTS = eINSTANCE.getInternalActionLink_InternalActionStatements();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.ParameterLinkImpl <em>Parameter Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.ParameterLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.GastPcmLinkPackageImpl#getParameterLink()
		 * @generated
		 */
		EClass PARAMETER_LINK = eINSTANCE.getParameterLink();

		/**
		 * The meta object literal for the '<em><b>Linked Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_LINK__LINKED_PARAMETER = eINSTANCE.getParameterLink_LinkedParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_LINK__PARAMETER = eINSTANCE.getParameterLink_Parameter();

	}

} //GastPcmLinkPackage
