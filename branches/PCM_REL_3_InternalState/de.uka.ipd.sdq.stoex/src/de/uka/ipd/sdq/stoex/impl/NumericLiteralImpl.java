/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.impl;

import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.stoex.NumericLiteral;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.units.impl.UnitCarryingElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numeric Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class NumericLiteralImpl extends UnitCarryingElementImpl implements NumericLiteral {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoexPackage.Literals.NUMERIC_LITERAL;
	}

} //NumericLiteralImpl
