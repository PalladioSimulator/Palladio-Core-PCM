/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Loop Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.ActivityLoopType#getCount <em>Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getActivityLoopType()
 * @model extendedMetaData="name='ActivityLoopType' kind='empty'"
 * @generated
 */
public interface ActivityLoopType extends ActivityType {
	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(Object)
	 * @see LqnCore.LqnCorePackage#getActivityLoopType_Count()
	 * @model dataType="LqnCore.SrvnFloat" required="true"
	 *        extendedMetaData="kind='attribute' name='count' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getCount();

	/**
	 * Sets the value of the '{@link LqnCore.ActivityLoopType#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(Object value);

} // ActivityLoopType
