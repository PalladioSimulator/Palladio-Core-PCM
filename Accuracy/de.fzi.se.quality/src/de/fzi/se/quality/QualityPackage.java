/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality;

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
 * @see de.fzi.se.quality.QualityFactory
 * @model kind="package"
 * @generated
 */
public interface QualityPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "quality";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://fzi.de/PalladioComponentModel/Quality/0.2";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "quality";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	QualityPackage eINSTANCE = de.fzi.se.quality.impl.QualityPackageImpl.init();

	/**
     * The meta object id for the '{@link de.fzi.se.quality.impl.QualityRepositoryImpl <em>Repository</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.fzi.se.quality.impl.QualityRepositoryImpl
     * @see de.fzi.se.quality.impl.QualityPackageImpl#getQualityRepository()
     * @generated
     */
	int QUALITY_REPOSITORY = 0;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUALITY_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
     * The feature id for the '<em><b>Quality Statements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUALITY_REPOSITORY__QUALITY_STATEMENTS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Repository</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUALITY_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link de.fzi.se.quality.impl.QualityStatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.fzi.se.quality.impl.QualityStatementImpl
     * @see de.fzi.se.quality.impl.QualityPackageImpl#getQualityStatement()
     * @generated
     */
	int QUALITY_STATEMENT = 1;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUALITY_STATEMENT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
     * The feature id for the '<em><b>Quality Repository</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUALITY_STATEMENT__QUALITY_REPOSITORY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Statement</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUALITY_STATEMENT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;


	/**
     * Returns the meta object for class '{@link de.fzi.se.quality.QualityRepository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Repository</em>'.
     * @see de.fzi.se.quality.QualityRepository
     * @generated
     */
	EClass getQualityRepository();

	/**
     * Returns the meta object for the containment reference list '{@link de.fzi.se.quality.QualityRepository#getQualityStatements <em>Quality Statements</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Quality Statements</em>'.
     * @see de.fzi.se.quality.QualityRepository#getQualityStatements()
     * @see #getQualityRepository()
     * @generated
     */
	EReference getQualityRepository_QualityStatements();

	/**
     * Returns the meta object for class '{@link de.fzi.se.quality.QualityStatement <em>Statement</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Statement</em>'.
     * @see de.fzi.se.quality.QualityStatement
     * @generated
     */
	EClass getQualityStatement();

	/**
     * Returns the meta object for the container reference '{@link de.fzi.se.quality.QualityStatement#getQualityRepository <em>Quality Repository</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Quality Repository</em>'.
     * @see de.fzi.se.quality.QualityStatement#getQualityRepository()
     * @see #getQualityStatement()
     * @generated
     */
	EReference getQualityStatement_QualityRepository();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	QualityFactory getQualityFactory();

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
         * The meta object literal for the '{@link de.fzi.se.quality.impl.QualityRepositoryImpl <em>Repository</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.fzi.se.quality.impl.QualityRepositoryImpl
         * @see de.fzi.se.quality.impl.QualityPackageImpl#getQualityRepository()
         * @generated
         */
		EClass QUALITY_REPOSITORY = eINSTANCE.getQualityRepository();

		/**
         * The meta object literal for the '<em><b>Quality Statements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUALITY_REPOSITORY__QUALITY_STATEMENTS = eINSTANCE.getQualityRepository_QualityStatements();

		/**
         * The meta object literal for the '{@link de.fzi.se.quality.impl.QualityStatementImpl <em>Statement</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.fzi.se.quality.impl.QualityStatementImpl
         * @see de.fzi.se.quality.impl.QualityPackageImpl#getQualityStatement()
         * @generated
         */
		EClass QUALITY_STATEMENT = eINSTANCE.getQualityStatement();

		/**
         * The meta object literal for the '<em><b>Quality Repository</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUALITY_STATEMENT__QUALITY_REPOSITORY = eINSTANCE.getQualityStatement_QualityRepository();

	}

} //QualityPackage
