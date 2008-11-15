/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Phase Activities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.PhaseActivities#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getPhaseActivities()
 * @model extendedMetaData="name='PhaseActivities' kind='elementOnly'"
 * @generated
 */
public interface PhaseActivities extends EObject {
	/**
	 * Returns the value of the '<em><b>Activity</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ActivityPhasesType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getPhaseActivities_Activity()
	 * @model containment="true" required="true" upper="3"
	 *        extendedMetaData="kind='element' name='activity' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ActivityPhasesType> getActivity();

} // PhaseActivities
