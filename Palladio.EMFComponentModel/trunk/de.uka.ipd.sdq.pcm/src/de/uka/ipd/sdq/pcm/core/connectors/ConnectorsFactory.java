/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.connectors;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage
 * @generated
 */
public interface ConnectorsFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConnectorsFactory eINSTANCE = de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorsFactoryImpl.init();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConnectorsPackage getConnectorsPackage();

} //ConnectorsFactory
