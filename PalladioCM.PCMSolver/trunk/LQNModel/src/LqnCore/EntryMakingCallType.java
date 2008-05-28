/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Making Call Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.EntryMakingCallType#getProb <em>Prob</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getEntryMakingCallType()
 * @model extendedMetaData="name='EntryMakingCallType' kind='elementOnly'"
 * @generated
 */
public interface EntryMakingCallType extends MakingCallType {
	/**
	 * Returns the value of the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prob</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prob</em>' attribute.
	 * @see #setProb(Object)
	 * @see LqnCore.LqnCorePackage#getEntryMakingCallType_Prob()
	 * @model dataType="LqnCore.SrvnFloat" required="true"
	 *        extendedMetaData="kind='attribute' name='prob' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getProb();

	/**
	 * Sets the value of the '{@link LqnCore.EntryMakingCallType#getProb <em>Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prob</em>' attribute.
	 * @see #getProb()
	 * @generated
	 */
	void setProb(Object value);

} // EntryMakingCallType
