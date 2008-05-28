/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Entry Distribution Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.OutputEntryDistributionType#getPhase <em>Phase</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getOutputEntryDistributionType()
 * @model extendedMetaData="name='OutputEntryDistributionType' kind='elementOnly'"
 * @generated
 */
public interface OutputEntryDistributionType extends OutputDistributionType {
	/**
	 * Returns the value of the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phase</em>' attribute.
	 * @see #setPhase(BigInteger)
	 * @see LqnCore.LqnCorePackage#getOutputEntryDistributionType_Phase()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NonNegativeInteger" required="true"
	 *        extendedMetaData="kind='attribute' name='phase' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getPhase();

	/**
	 * Sets the value of the '{@link LqnCore.OutputEntryDistributionType#getPhase <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase</em>' attribute.
	 * @see #getPhase()
	 * @generated
	 */
	void setPhase(BigInteger value);

} // OutputEntryDistributionType
